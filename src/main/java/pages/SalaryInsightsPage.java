package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.WebUtils;

import static org.junit.Assert.assertEquals;

public class SalaryInsightsPage {
    private final Page page;

    public SalaryInsightsPage(Page page) {
        this.page = page;
    }

    public void launchApplication() {
        page.navigate(utils.ConfigReader.get("base.url"));  // from config.properties
        page.waitForTimeout(2000);
    }

    public void selectRole(String role) {
        WebUtils.selectDropdownOption(page, "Select a role", role);
    }

    public void selectCountry(String country) {
        WebUtils.selectDropdownOption(page, "Select a country", country);
    }

    public void clickSearch() {
        page.locator("button:has-text('Search')").click();
    }

    public boolean isSalaryInsightDisplayed(String role, String country) {
        String expectedText = "Senior " + role + " compensation in " + country;

        Locator heading = page.locator("text='Senior " + role + " compensation in " + country + "'");
        heading.waitFor();

        String actualText = heading.textContent().trim();
        assertEquals(expectedText, actualText);
        System.out.println("Text assertion passed: " + actualText);

        return true;
    }
}