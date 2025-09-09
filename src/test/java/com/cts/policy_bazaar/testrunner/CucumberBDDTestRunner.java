package com.cts.policy_bazaar.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.cts.policy_bazaar.stepdefinitions", "com.cts.policy_bazaar.frameworkutils"},

        // Reporting plugins for different formats
        plugin = {
                "pretty",
                "html:target/cucumber_reports/cucumber.html",
                "json:target/cucumber_reports/cucumber.json",
                "junit:target/cucumber_reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        // Removes unnecessary characters from console output
        monochrome = true
)
public class CucumberBDDTestRunner extends AbstractTestNGCucumberTests {
        // Executes Cucumber tests using TestNG
}
