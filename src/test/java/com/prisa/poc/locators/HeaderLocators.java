package com.prisa.poc.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderLocators {

    /** Locators */

    @FindBy(xpath = "//span[@class='ai-as']")
    public WebElement logoAS;

    @FindBy(xpath = "//a[@data-subnav='futbol']")
    public WebElement dropdownFutbol;

    @FindBy(xpath = "//a[@data-subnav='motor']")
    public WebElement dropdownMotor;

    @FindBy(xpath = "//li/a[@title='Atlético de Madrid']")
    public WebElement optionAtletico;

    @FindBy(xpath = "//li/a[@title='Fórmula 1']")
    public WebElement optionFormulaOne;
}
