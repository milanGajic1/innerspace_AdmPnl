package innerspaceAdmPnl.ui.stepdefinitions;

import innerspaceAdmPnl.ui.browser.BrowserManager;
import innerspaceAdmPnl.ui.pages.login.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import static innerspaceAdmPnl.ui.config.Constants.INNERSPACE_ADMIN_PANEL_URL;

public class SignInSteps {

    private final LogInPage loginPage;

    public SignInSteps(BrowserManager browserManager) {
        this.loginPage = new LogInPage(BrowserManager.getDriver());
    }

    @Given("^I am on the Innerspace Admin Panel login page$")
    public void i_am_on_the_admin_panel_login_page() {
        loginPage.navigateToPage(INNERSPACE_ADMIN_PANEL_URL);
    }

    @When("^I click on the sign-in button$")
    public void i_click_on_the_sign_in_button() {
        loginPage.clickSignIn();
    }

    @When("^I select an existing Microsoft user account$")
    public void i_select_an_existing_microsoft_user_account() {
        loginPage.clickOnExistingMicrosoftUser();
    }

    @Then("^I should be logged into the Admin Panel$")
    public void i_should_be_logged_into_the_admin_panel() {
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }
}
