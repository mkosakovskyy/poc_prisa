package com.prisa.poc.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderLocators {

    /** Locators */

    @FindBy(xpath = "//span[@class='ai-as']")
    public static WebElement logoAS;

    @FindBy(xpath = "//a[@data-subnav='futbol']")
    public static WebElement dropdownFutbol;

    @FindBy(xpath = "//a[@data-subnav='motor']")
    public static WebElement dropdownMotor;

    @FindBy(xpath = "//li/a[@title='Atlético de Madrid']")
    public static WebElement optionAtletico;

    @FindBy(xpath = "//li/a[@title='Fórmula 1']")
    public static WebElement optionFormulaOne;
}
