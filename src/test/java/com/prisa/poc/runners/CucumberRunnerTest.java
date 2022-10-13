package com.prisa.poc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty"},
        glue = {"com.prisa.poc.stepDefinitions"},
        features = {"src/test/resources/functionalTest"}
)
public class CucumberRunnerTest {
}