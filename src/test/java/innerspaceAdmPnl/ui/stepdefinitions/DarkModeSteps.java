package innerspaceAdmPnl.ui.stepdefinitions;

import innerspaceAdmPnl.ui.browser.BrowserManager;
import innerspaceAdmPnl.ui.pages.login.HomePage;
import innerspaceAdmPnl.ui.pages.login.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static innerspaceAdmPnl.ui.config.Constants.INNERSPACE_ADMIN_PANEL_URL;

public class DarkModeSteps {

    private LogInPage loginPage;
    private HomePage homePage;

    public DarkModeSteps() {
        loginPage = new LogInPage(BrowserManager.getDriver());
        homePage = new HomePage(BrowserManager.getDriver());
    }

    @Given("I am logged into the Innerspace Admin Panel")
    public void i_am_logged_into_the_innerspace_admin_panel() {
        loginPage.login(INNERSPACE_ADMIN_PANEL_URL);
    }

    @When("I click on the dark mode button")
    public void i_click_on_the_dark_mode_button() {
        homePage.clickDarkModeButton();
    }

    @Then("the application should switch to dark mode")
    public void the_application_should_switch_to_dark_mode() {
        Assert.assertTrue(homePage.assertDarkMode());
    }
}
