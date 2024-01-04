package innerspaceAdmPnl.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import innerspaceAdmPnl.ui.browser.BrowserMethods;
import innerspaceAdmPnl.ui.browser.BrowserManager;

public class ExampleTest {
    private BrowserMethods browserMethods;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = BrowserManager.getDriver();
        browserMethods = new BrowserMethods(driver);
        browserMethods.maximize();
    }

    @Test
    public void testExample() {
        browserMethods.goTo("https://adminpanel-staging.innerspace.at/home/");
        Assert.assertEquals(browserMethods.getTitle(), "Innerspace AdminPanel");
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
