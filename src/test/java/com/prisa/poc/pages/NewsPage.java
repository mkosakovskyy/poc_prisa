package com.prisa.poc.pages;

import com.prisa.poc.locators.NewsLocators;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Slf4j
public class NewsPage extends AbstractPage {

    public static final String ATLETICO_URL = "https://as.com/noticias/atletico-madrid/?omnil=mpal";
    public static final String FORMULA_URL = "https://as.com/motor/formula_1/?omnil=mpal";
    public static final String FACEBOOK_URL = "https://www.facebook.com/";
    NewsLocators newsLoc;

    /** Constructor */

    NewsPage(WebDriver driver) {
        super(driver);
        this.newsLoc = new NewsLocators();
        PageFactory.initElements(driver, newsLoc);
    }

    /** Actions */

    public boolean areNewsDisplayed() { return isElementPresent(newsLoc.eFirstNews); }

    public void clickFacebook() { newsLoc.btnFacebook.click(); }

    public void waitForAdvertisements() {
        try {
            WebElement elem = getDriver().findElement(By.id("pbnetVideo"));
            new WebDriverWait(getDriver(), Duration.ofSeconds(35)).until(ExpectedConditions.visibilityOf(elem));
        } catch (NoSuchElementException e) {}
    }

    public boolean areAdvertisementDisplayed(DataTable table) {
        boolean isPresent = false;
        try {
            for(int i = 0; i < table.asList(String.class).size(); ++i) {
                WebElement advertisement = getDriver().findElement(By.id(table.asList().get(i)));
                if (!advertisement.isDisplayed()) {
                    log.info("No se ha encontrado: " + table.asList().get(i));
                    isPresent = false;
                    break;
                }
                if (advertisement.isDisplayed()) {
                    isPresent = true;
                }
            }
        } catch (NoSuchElementException e) { isPresent = false; }
        return isPresent;
    }
}
