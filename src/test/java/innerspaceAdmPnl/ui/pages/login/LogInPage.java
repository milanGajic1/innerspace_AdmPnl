package innerspaceAdmPnl.ui.pages.login;

import innerspaceAdmPnl.ui.config.Wrappers;
import innerspaceAdmPnl.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {
    WebElement signInButton = driver.findElement(By.xpath("//button[@tabindex='0']"));

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(){
        Wrappers.clickJs(signInButton);
    }

}
