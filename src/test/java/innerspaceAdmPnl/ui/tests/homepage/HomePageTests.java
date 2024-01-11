package innerspaceAdmPnl.ui.tests.homepage;

import innerspaceAdmPnl.ui.browser.BrowserManager;
import innerspaceAdmPnl.ui.pages.login.LogInPage;
import innerspaceAdmPnl.ui.pages.login.HomePage;
import innerspaceAdmPnl.ui.tests.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static innerspaceAdmPnl.ui.config.Constants.INNERSPACE_ADMIN_PANEL_URL;

public class HomePageTests extends BaseTest {
    @Test
    public void testDarkMode() {
        LogInPage loginPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);
        // Step 1: Log in
        loginPage.login(INNERSPACE_ADMIN_PANEL_URL);

        // Step 3: Click on the dark mode button (you need to implement this step)
        homePage.clickDarkModeButton();

        // Step 4: Verify the page is in dark mode
        homePage.assertDarkMode();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        BrowserManager.closeDriver();
    }
}
