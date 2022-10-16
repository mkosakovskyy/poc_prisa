package com.prisa.poc.pages;

import com.prisa.poc.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends AbstractPage {

    /** Constructor */

    HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Actions */

    public void clickMenuAtletico() {
        moveTo(HeaderLocators.dropdownFutbol);
        HeaderLocators.optionAtletico.click();
    }

    public void clickMenuFormulaOne() {
        moveTo(HeaderLocators.dropdownMotor);
        HeaderLocators.optionFormulaOne.click();
    }

    public void clickHeaderLogo() {
        HeaderLocators.logoAS.click();
    }
}