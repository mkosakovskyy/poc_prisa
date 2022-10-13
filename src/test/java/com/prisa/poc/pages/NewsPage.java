package com.prisa.poc.pages;

import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

@Slf4j
public class NewsPage extends AbstractPage {

    /** Locators */

    public static final String ATLETICO_URL = "https://as.com/noticias/atletico-madrid/?omnil=mpal";
    public static final String FORMULA_URL = "https://as.com/motor/formula_1/?omnil=mpal";
    public static final String FACEBOOK_URL = "https://www.facebook.com/";

    @FindBy(xpath = "//a[@href='/noticias/atletico-madrid/']")
    private WebElement titleAtletico;

    @FindBy(xpath = "//a[@href='https://as.com/motor/formula_1/']")
    private WebElement titleFormula;

    @FindBy(xpath = "//div[@dtm-region='tag_es_home>atletico-madrid-a_contenedornoticia_1_none_none']")
    private WebElement eFirstNews;

    @FindBy(xpath = "//a[@name='Navegar a facebook']")
    private WebElement btnFacebook;

    /** Constructor */

    NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Actions */

    public void waitAtleticoPageLoad() {
        waitForPageLoad(titleAtletico);
    }

    public boolean areNewsDisplayed() {
        return isElementPresent(eFirstNews);
    }

    public void waitFormulaPageLoad() {
        waitForPageLoad(titleFormula);
    }

    public void clickFacebook() {
        btnFacebook.click();
    }

    public boolean areAdvertisementDisplayed(DataTable table) {
        WebElement advertisement;
        boolean isPresent = false;
        try {
            advertisement = getDriver().findElement(By.xpath("//div[@id='" + table.asList().get(0) + "']"));
            waitForPageLoad(advertisement);
            for (int i =- 0; i < table.asList(String.class).size(); i++) {
                String xpath = "//div[@id='" + table.asList().get(i) + "']";
                advertisement = getDriver().findElement(By.xpath(xpath));
                if(!advertisement.isDisplayed()){
                    isPresent = false;
                    break;
                } else if(advertisement.isDisplayed()) { isPresent = true; }
            }
        } catch (NoSuchElementException e) { isPresent = false; }
        return isPresent;
    }

}