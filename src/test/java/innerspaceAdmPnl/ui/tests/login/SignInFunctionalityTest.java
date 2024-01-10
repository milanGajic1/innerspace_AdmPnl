package innerspaceAdmPnl.ui.tests.login;

import innerspaceAdmPnl.ui.pages.login.LogInPage;
import innerspaceAdmPnl.ui.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static innerspaceAdmPnl.ui.config.Constants.INNERSPACE_ADMIN_PANEL_URL;


public class SignInFunctionalityTest extends BaseTest {

    @Test
    @Description("Test Description: Login test with valid credentials.")
    @Epic("Authentication")
    @Feature("Login")
    public void testSignInFunctionality() {
        LogInPage loginPage = new LogInPage(driver);

        // Step 1: Navigate to your page
        loginPage.navigateToPage(INNERSPACE_ADMIN_PANEL_URL);

        // Step 2: Click on signIn button
        loginPage.clickSignIn();

        // Step 3 & 4: Enter credentials and submit
//        loginPage.enterMicrosoftCredentials(CredentialsUtil.getEmail(), CredentialsUtil.getPassword());

        // Step 3 & 4: Select existing user and submit
        loginPage.clickOnExistingMicrosoftUser();

        // Step 5: Assert user is logged in
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }
}
