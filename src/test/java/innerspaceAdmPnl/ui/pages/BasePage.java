package innerspaceAdmPnl.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import innerspaceAdmPnl.ui.config.Constants;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }
}
