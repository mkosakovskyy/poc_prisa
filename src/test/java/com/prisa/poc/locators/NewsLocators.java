package com.prisa.poc.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsLocators {

    /** Locators */

    @FindBy(xpath = "//div[@dtm-region='tag_es_home>atletico-madrid-a_contenedornoticia_1_none_none']")
    public WebElement eFirstNews;

    @FindBy(xpath = "//a[@name='Navegar a facebook']")
    public WebElement btnFacebook;
}
