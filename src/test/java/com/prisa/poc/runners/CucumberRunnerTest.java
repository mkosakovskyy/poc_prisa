package com.prisa.poc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:cucumber-reporting/json/cucumberJson.json",
                "html:cucumber-reporting/html/cucumberIndex.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        glue = {"com.prisa.poc.stepDefinitions"},
        features = {"src/test/resources/functionalTest"}
)
public class CucumberRunnerTest {
}