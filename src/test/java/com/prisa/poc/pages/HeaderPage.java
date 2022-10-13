package com.prisa.poc.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HeaderPage extends AbstractPage {

    /** Locators */

    @FindBy(xpath = "//span[@class='ai-as']")
    private WebElement logoAS;

    @FindBy(xpath = "//a[@data-subnav='futbol']")
    private WebElement dropdownFutbol;

    @FindBy(xpath = "//a[@data-subnav='motor']")
    private WebElement dropdownMotor;

    @FindBy(xpath = "//li/a[@title='Atlético de Madrid']")
    private WebElement optionAtletico;

    @FindBy(xpath = "//li/a[@title='Fórmula 1']")
    private WebElement optionFormulaOne;

    /** Constructor */

    HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Actions */

    public void clickMenuAtletico() {
        moveTo(dropdownFutbol);
        optionAtletico.click();
    }

    public void clickMenuFormulaOne() {
        moveTo(dropdownMotor);
        optionFormulaOne.click();
    }

    public void clickHeaderLogo() { logoAS.click(); }

}
