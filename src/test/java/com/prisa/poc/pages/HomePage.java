package com.prisa.poc.pages;

import com.prisa.poc.locators.HomeLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends AbstractPage {

    public static final String PAGE_URL = "https://as.com/?nrd=1";
    public static final String PAGE_US_URL = "https://us.as.com/";
    HomeLocators homeLoc;

    /** Constructor */

    HomePage(WebDriver driver) {
        super(driver);
        this.homeLoc = new HomeLocators();
        PageFactory.initElements(driver, homeLoc);
    }

    /** Actions */

    public String clickFirstNews() {
        String newsUrl = homeLoc.titleFirstNews.getAttribute("href");
        homeLoc.titleFirstNews.click();
        return newsUrl;
    }

    public void clickAcceptCookies() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(homeLoc.logoAS));
        if (isElementPresent(homeLoc.btnAcceptCookies)) {
            homeLoc.btnAcceptCookies.click();
        }
    }

    public void redirectSpain() {
        String currentUrl = getDriver().getCurrentUrl();
        if (currentUrl.equals(PAGE_US_URL)) {
            navigateTo(PAGE_URL);
        }
    }
}
