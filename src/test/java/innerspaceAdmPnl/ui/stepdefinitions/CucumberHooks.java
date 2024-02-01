package innerspaceAdmPnl.ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import innerspaceAdmPnl.ui.browser.BrowserManager;

public class CucumberHooks {

    private WebDriver driver;

    @Before("@UITest")
    public void setUpCucumber() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
    }

    @After("@UITest")
    public void tearDownCucumber() {
        if (driver != null) {
            BrowserManager.closeDriver();
        }
    }
}
