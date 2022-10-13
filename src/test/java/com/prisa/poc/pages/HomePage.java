package com.prisa.poc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends AbstractPage {

    /** Locators */

    public static final String PAGE_URL = "https://as.com/?nrd=1";
    public static final String PAGE_US_URL = "https://us.as.com/";

    @FindBy(xpath = "//span[@class='ai-as']")
    private WebElement logoAS;

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement btnAcceptCookies;

    @FindBy(css = "article h2.s__tl a")
    private WebElement titleFirstNews;

    /** Constructor */

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Actions */

    public String clickFirstNews() {
        String newsUrl = titleFirstNews.getAttribute("href");
        titleFirstNews.click();
        return newsUrl;
    }

    public void clickAcceptCookies() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(logoAS));
        if (isElementPresent(btnAcceptCookies)) {
            btnAcceptCookies.click();
        }
    }

    public void redirectSpain() {
        String currentUrl = getDriver().getCurrentUrl();
        if (currentUrl.equals("https://us.as.com/")) {
            navigateTo("https://as.com/?nrd=1");
        }
    }
}
