package com.prisa.poc.pages;

import com.prisa.poc.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends AbstractPage {

    HeaderLocators headerLoc;

    /** Constructor */

    HeaderPage(WebDriver driver) {
        super(driver);
        this.headerLoc = new HeaderLocators();
        PageFactory.initElements(driver, headerLoc);
    }

    /** Actions */

    public void clickMenuAtletico() {
        moveTo(headerLoc.dropdownFutbol);
        headerLoc.optionAtletico.click();
    }

    public void clickMenuFormulaOne() {
        moveTo(headerLoc.dropdownMotor);
        headerLoc.optionFormulaOne.click();
    }

    public void clickHeaderLogo() {
        headerLoc.logoAS.click();
    }
}