package innerspaceAdmPnl.ui.config;

import static innerspaceAdmPnl.ui.config.Constants.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import innerspaceAdmPnl.ui.browser.BrowserManager;

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

    // Waits for the entire web page to load completely
    public static void waitForPageLoadComplete() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception exception) {
            System.out.println("Page did not load completely.");
        }
    }
    // Waits for an element, identified by its locator, to be clickable before performing any action
    public static WebElement waitToBeClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception exception) {
            System.out.println("Element with locator " + locator + " is not clickable.");
            return null;
        }
    }
    // Waits for an element to be visible on the web page, identified by its locator
    public static WebElement waitToBeVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception exception) {
            System.out.println("Element with locator " + locator + " is not visible.");
            return null;
        }
    }
}
