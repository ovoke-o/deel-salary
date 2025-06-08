package stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pages.SalaryInsightsPage;
import utils.PlaywrightManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalarySteps {

    private Page page;
    private SalaryInsightsPage salaryInsightsPage;

    @Given("user is on the Deel Salary Insight page")
    public void user_on_salary_insight_page() {
        page = PlaywrightManager.getPage();
        salaryInsightsPage = new SalaryInsightsPage(page);
        salaryInsightsPage.launchApplication();
    }

    @When("user selects role {string} and country {string}")
    public void user_selects_role_and_country(String role, String country) {
        salaryInsightsPage.selectRole(role);
        salaryInsightsPage.selectCountry(country);
        salaryInsightsPage.clickSearch();
    }

    @Then("salary insights for {string} and country {string} should be displayed")
    public void salary_insights_should_be_displayed(String role, String country) {
        assertTrue(salaryInsightsPage.isSalaryInsightDisplayed(role, country), "Salary insights not displayed");
    }
}
