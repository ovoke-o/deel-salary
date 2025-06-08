package hooks;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.PlaywrightManager;
import utils.ScreenshotUtils;

import java.io.FileNotFoundException;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        PlaywrightManager.initialize();
        Allure.step("Test Started: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) throws FileNotFoundException {
        Page page = PlaywrightManager.getPage();
        if (scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(page, scenario.getName().replaceAll(" ", "_"));
        }
        PlaywrightManager.close();
    }

}
