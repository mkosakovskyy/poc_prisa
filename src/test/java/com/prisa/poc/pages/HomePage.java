package com.prisa.poc.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends AbstractPage {

    /** Locators */

    public static final String PAGE_URL = "https://as.com/";

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement btnAcceptCookies;

    @FindBy(id = "gtp_diarioas_19753-MPU1")
    public WebElement eAdvertisement;

    @FindBy(css = "article h2.s__tl a")
    private WebElement titleFirstNews;

    /** Constructor */

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Actions */

    public void waitHomePageLoad() {
        waitForPageLoad(eAdvertisement);
    }

    public String clickFirstNews() {
        String newsUrl = titleFirstNews.getAttribute("href");
        titleFirstNews.click();
        return newsUrl;
    }

    public void clickAcceptCookies() {
        if(isElementPresent(btnAcceptCookies)){
            btnAcceptCookies.click();
        }
    }

}
