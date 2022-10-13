package com.prisa.poc.stepDefinitions;

import com.prisa.poc.pages.PagesFactory;
import com.prisa.poc.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.codehaus.plexus.util.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    /** Delete all cookies at the start of each scenario to avoid shared state between tests */
    @Before()
    @SuppressWarnings("deprecation")
    public void setUp() {
        String browser = Flags.getInstance().getBrowser();
        if (StringUtils.isBlank(browser)) browser = "chrome";
        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("--headless");
                driver = new FirefoxDriver(optionsFirefox);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--headless");
                optionsChrome.addArguments("--no-sandbox");
                optionsChrome.addArguments("--disable-dev-shm-usage");
                //optionsChrome.addArguments("window-size=1280,720");
                driver = new ChromeDriver(optionsChrome);
        }
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        PagesFactory.start(driver);
    }

    /** Embed a screenshot in test report if test is marked as failed */
    @After
    public void tearDown(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            long time = new Date().getTime();
            String outputName = "screenshot_" + time + ".png";
            scenario.attach(screenshot, "image/png", outputName);
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        driver.quit();
    }

    /** @AfterStep
    public void afterStep(Scenario scenario) {
    ScreenshotTaker.takeScreenshot(scenario);
    } */

}