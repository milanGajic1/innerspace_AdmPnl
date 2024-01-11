package innerspaceAdmPnl.ui.tests.homepage;

import innerspaceAdmPnl.ui.config.Waits;
import innerspaceAdmPnl.ui.pages.login.LogInPage;
import innerspaceAdmPnl.ui.pages.login.HomePage;
import innerspaceAdmPnl.ui.tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;

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
        Waits.waitForPageLoadComplete();
        boolean isDarkMode = homePage.isPageInDarkMode();
        Assert.assertTrue(isDarkMode, "The page is not in dark mode after clicking the dark mode button.");
    }
}
