package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefs", "hooks"}, // make sure 'hooks' is included
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, tags = "@Regression")
public class TestRunner extends AbstractTestNGCucumberTests {
}


