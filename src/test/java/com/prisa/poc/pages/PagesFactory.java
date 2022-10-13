package com.prisa.poc.pages;

import org.openqa.selenium.WebDriver;

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

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public NewsPage getNewsPage() {return newsPage; }

    public HeaderPage getHeaderPage() {return headerPage; }

}