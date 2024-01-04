package innerspaceAdmPnl.ui.config;

import static innerspaceAdmPnl.ui.config.Constants.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import innerspaceAdmPnl.ui.browser.BrowserManager;
import org.openqa.selenium.WebElement;

public class Waits {
    protected static WebDriverWait wait = new WebDriverWait(BrowserManager.getDriver(), DEFAULT_WAIT_TIMEOUT);

    // Waits for an element to be visible on the web page
    public static void waitToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception exception) {
            System.out.println("Element " + element + " is not visible.");
        }
    }

    // Waits for an element to be clickable before performing any action
    public static void waitToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception exception) {
            System.out.println("Element " + element + " is not clickable.");
        }
    }
}
