package com.prisa.poc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PagesFactory {

    /** Variables */

    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final HomePage homePage;
    private final NewsPage newsPage;
    private final HeaderPage headerPage;

    /** Constructor */

    private PagesFactory(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        newsPage = new NewsPage(driver);
        headerPage = new HeaderPage(driver);
    }

    /** Actions */

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }

    public HomePage getHomePage() { return homePage; }

    public NewsPage getNewsPage() { return newsPage; }

    public HeaderPage getHeaderPage() { return headerPage; }

    public WebDriver getDriver() { return driver; }

    public String getUrl() { return driver.getCurrentUrl(); }

    public void waitForPageLoad() {
        try {
            WebElement elem = getDriver().findElement(By.id("pbnetVideo"));
            new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(elem));
        } catch (NoSuchElementException e) {}
    }
}