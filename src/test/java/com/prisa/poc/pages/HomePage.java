package com.prisa.poc.pages;

import com.prisa.poc.locators.HeaderLocators;
import com.prisa.poc.locators.HomeLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends AbstractPage {

    public static final String PAGE_URL = "https://as.com/?nrd=1";
    public static final String PAGE_US_URL = "https://us.as.com/";

    /** Constructor */

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Actions */

    public String clickFirstNews() {
        String newsUrl = HomeLocators.titleFirstNews.getAttribute("href");
        HomeLocators.titleFirstNews.click();
        return newsUrl;
    }

    public void clickAcceptCookies() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(HeaderLocators.logoAS));
        if (isElementPresent(HomeLocators.btnAcceptCookies)) {
            HomeLocators.btnAcceptCookies.click();
        }
    }

    public void redirectSpain() {
        String currentUrl = getDriver().getCurrentUrl();
        if (currentUrl.equals(PAGE_US_URL)) {
            navigateTo(PAGE_URL);
        }
    }
}
