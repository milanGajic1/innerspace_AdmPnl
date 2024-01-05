package innerspaceAdmPnl.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import innerspaceAdmPnl.ui.browser.BrowserManager;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void tearDown() {
//        BrowserManager.closeDriver();
//    }

    // Common methods or utilities for tests can be added here
}
