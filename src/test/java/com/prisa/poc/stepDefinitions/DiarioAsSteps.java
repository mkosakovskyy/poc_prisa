package com.prisa.poc.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import com.prisa.poc.pages.PagesFactory;
import com.prisa.poc.pages.HomePage;
import com.prisa.poc.pages.NewsPage;
import com.prisa.poc.pages.HeaderPage;
import org.junit.Assert;

@Slf4j
public class DiarioAsSteps {

    /** Variables */

    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    NewsPage newsPage = pf.getNewsPage();
    HeaderPage headerPage = pf.getHeaderPage();

    private String firstNewsURL;

    /** Steps */

    @Given("The user is on the as.com home page")
    public void theUserIsOnTheLoginPage() {
        log.info("El usuario se encuentra en la página principal de as.com");
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @And("The user accepts cookies pop-up")
    public void theUserAcceptsCookies() {
        log.info("El usuario acepta el pop-up de cookies");
        homePage.clickAcceptCookies();
    }

    @When("The user access Atletico de Madrid within the Futbol section")
    public void theUserAccessAtleticoDeMadrid() {
        log.info("El usuario accede al Atletico de Madrid dentro de la sección de Futbol");
        headerPage.clickMenuAtletico();
    }

    @Then("The Atletico de Madrid team page is correct")
    public void theAtleticoPageIsCorrect() {
        log.info("La página del Atletico de Madrid es correcta");
        newsPage.waitAtleticoPageLoad();
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertEquals("El usuario no se encuentra en la página de noticias del Atletico de Madrid", NewsPage.ATLETICO_URL, currentUrl);
    }

    @And("The Atletico de Madrid news are displayed")
    public void theAtleticoNewsAreDisplayed() {
        log.info("Se muestran las noticias del Atletico de Madrid");
        Assert.assertTrue("No se han encontrado las noticias del Atletico de Madrid", newsPage.areNewsDisplayed());
    }

    @And("The user clicks on the banner AS logo")
    public void theUserClicksOnTheBannerASLogo() {
        log.info("El usuario pulsa el logo de AS en el banner");
        headerPage.clickHeaderLogo();
    }

    @Then("The user is redirected to the home page")
    public void theUserIsRedirectedToTheHomePage() {
        log.info("El usuario se redirecciona a la página principal");
        homePage.waitHomePageLoad();
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertEquals("El usuario no se encuentra en la página de inicio", HomePage.PAGE_URL, currentUrl);
    }

    @When("The user clicks on the title of the first news")
    public void theUserClicksOnTheTitleOfTheFirstNews() {
        log.info("El usuario accede a la primera noticia de la página principal");
        firstNewsURL = homePage.clickFirstNews();
    }

    @Then("The user is on the selected news page")
    public void theUserIsOnTheSelectedNewsPage() {
        log.info("El usuario se encuentra en la página de la noticia seleccionada");
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertEquals("El usuario no se encuentra en la página de la primera noticia", firstNewsURL, currentUrl);
    }

    @When("The user clicks the Facebook icon")
    public void theUserClicksTheFacebookIcon() {
        log.info("El usuario pulsa el icono de Facebook");
        newsPage.clickFacebook();
    }

    @Then("The Facebook share window is displayed")
    public void theFacebookShareWindowIsDisplayed() {
        log.info("Se muestra la ventana para compartir con Facebook");
        String winHandleBefore = pf.getDriver().getWindowHandle();
        newsPage.switchWindow();
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertTrue("El usuario no se encuentra en la ventana de Facebook", currentUrl.contains(NewsPage.FACEBOOK_URL));
    }

    @When("The user access Formula One within the Motor section")
    public void theUserAccessMotorFormulaOne() {
        log.info("El usuario accede a la Formula Uno dentro de la sección de Motor");
        headerPage.clickMenuFormulaOne();
    }

    @Then("The Formula One league page is correct")
    public void theFormulaLeaguePageIsCorrect() {
        log.info("La página de Formula Uno es correcta");
        newsPage.waitFormulaPageLoad();
        String currentUrl = pf.getDriver().getCurrentUrl();
        Assert.assertEquals("El usuario no se encuentra en la página de noticias de la Formula Uno", NewsPage.FORMULA_URL, currentUrl);
    }

    @And("The Formula One league advertisement elements are displayed")
    public void theFormulaLeagueAdvertisementAreDisplayed(DataTable table) {
        log.info("Se muestran los elementos de anuncios indicados");
        Assert.assertTrue("No se han encontrado los anuncios indicados de Formula Uno", newsPage.areAdvertisementDisplayed(table));
    }

}