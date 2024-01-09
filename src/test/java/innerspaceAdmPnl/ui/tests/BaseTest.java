package innerspaceAdmPnl.ui.tests;

import org.openqa.selenium.WebDriver;
import innerspaceAdmPnl.ui.browser.BrowserManager;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        BrowserManager.closeDriver();
//    }
}
