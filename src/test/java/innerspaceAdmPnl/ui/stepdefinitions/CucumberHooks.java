package innerspaceAdmPnl.ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import innerspaceAdmPnl.ui.browser.BrowserManager;

public class CucumberHooks {

    private WebDriver driver;

    @Before
    public void setUpCucumber() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDownCucumber() {
        if (driver != null) {
            BrowserManager.closeDriver();
        }
    }
}