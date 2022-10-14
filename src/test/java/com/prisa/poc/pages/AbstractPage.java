package com.prisa.poc.pages;

import com.prisa.poc.utils.MyFluentWait;
import java.time.temporal.ChronoUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
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

    protected Wait<WebDriver> getWait() { return wait; }

    protected void setWait(Wait<WebDriver> wait) { this.wait = wait; }

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
        boolean isPresent;
        try {
            isPresent = elem.isDisplayed();
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }

    /** Navigation Methods */

    public void navigateTo(String url) {
        try {
            getDriver().navigate().to(url);
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
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }

    public static void dragAndDropElement(WebDriver driver, By locator, int xOffset, int yOffset){
        WebElement slider = driver.findElement(locator);
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, xOffset, yOffset).build();
        action.perform();
    }
}