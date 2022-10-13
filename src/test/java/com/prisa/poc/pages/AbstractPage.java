package com.prisa.poc.pages;

import java.time.temporal.ChronoUnit;
import com.prisa.poc.utils.MyFluentWait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

@Slf4j
public abstract class AbstractPage {

    /** Variables */

    protected Wait<WebDriver> wait;
    private final WebDriver driver;

    /** Constructor */

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new MyFluentWait<>(driver)
                .withTimeout(5, ChronoUnit.SECONDS)
                .pollingEvery(2, ChronoUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    /** Methods */
    /** Getters & Setters Methods */

    protected WebDriver getDriver() { return driver; }

    protected Wait<WebDriver> getWait() {
        return wait;
    }

    protected void setWait(Wait<WebDriver> wait) {
        this.wait = wait;
    }

    /** Is Methods */

    protected boolean isPageLoaded(WebElement elem) {
        boolean isLoaded = false;
        try {
            isLoaded = elem.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return isLoaded;
    }

    protected boolean isElementPresent(WebElement elem) {
        boolean isPresent = false;
        try {
            isPresent = elem.isDisplayed();
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }

    /** Navigation Methods */

    public void navigateTo(String url) {
        WebDriver driver = getDriver();
        try {
            driver.navigate().to(url);
        } catch (java.lang.Exception e) {
            if (e instanceof TimeoutException) {
                log.info("Timeout loading home page");
            } else if (e instanceof ScriptTimeoutException) {
                log.info("Script Timeout loading home page");
            } else {
                log.error(e.getMessage());
            }
        }
    }

    protected void moveTo(WebElement elem) {
        if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equals("firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
        } else {
            Actions actions = new Actions(driver);
            actions.moveToElement(elem).build().perform();
        }
    }

    public void switchWindow() {
        WebDriver driver = getDriver();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    /** Wait Methods */

    protected void waitForPageLoad(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

}