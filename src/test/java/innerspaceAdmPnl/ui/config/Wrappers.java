package innerspaceAdmPnl.ui.config;

import static innerspaceAdmPnl.ui.browser.BrowserManager.getDriver;
import static innerspaceAdmPnl.ui.config.Waits.waitToBeClickable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Wrappers {
    private static final JavascriptExecutor executor = (JavascriptExecutor) getDriver();

    // Types text into a web element after clearing any existing text
    public static void type(WebElement element, String text) {
        click(element); // Ensures the element is clickable before interaction
        clear(element); // Clears any existing text in the element
        element.sendKeys(text); // Sends the text to the element
    }

    // Clicks on a web element, uses JavaScript click as a fallback
    public static void click(WebElement element) {
        waitToBeClickable(element); // Waits until the element is clickable
        try {
            element.click(); // Tries to click the element normally
        } catch(Exception e) {
            clickJs(element); // Uses JavaScript click as a fallback
        }
    }

    // Clicks on a web element using JavaScript
    public static void clickJs(WebElement element) {
        waitToBeClickable(element); // Ensures the element is clickable
        executor.executeScript("arguments[0].click();", element); // Executes JavaScript click
    }

    // Clears text from a web element
    public static void clear(WebElement element) {
        waitToBeClickable(element); // Ensures the element is clickable
        element.clear(); // Clears the text in the element
    }

    public static void actionClick(WebElement element) {
        waitToBeClickable(element);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
    }
}
