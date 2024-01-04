package innerspaceAdmPnl.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import innerspaceAdmPnl.ui.browser.BrowserManager;
import innerspaceAdmPnl.ui.config.Constants;

public class TitleTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
        driver.get(Constants.INNERSPACE_ADMIN_PANEL_URL);
    }

    @Test
    public void testAdminPanelTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, Constants.INNERSPACE_ADMIN_PANEL_TITLE);
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
