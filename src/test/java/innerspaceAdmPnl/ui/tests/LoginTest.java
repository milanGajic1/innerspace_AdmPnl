package innerspaceAdmPnl.ui.tests;

import innerspaceAdmPnl.ui.config.Constants;
import org.testng.annotations.Test;
import innerspaceAdmPnl.ui.pages.login.LogInPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginFunctionality() {
        driver.get(Constants.INNERSPACE_ADMIN_PANEL_URL);

        LogInPage loginPage = new LogInPage(driver);

        loginPage.logIn();

        // Add assertions or further actions to validate the login was successful
        // For example, checking if the URL or page title has changed,
        // or if certain elements are displayed after login

        // Sample assertion (update as per your application's post-login behavior)
        // Assert.assertEquals(driver.getTitle(), "Expected Title After Login");
    }

    // Other test methods if needed...
}
