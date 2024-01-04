package innerspaceAdmPnl.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class BrowserMethods {
    private final WebDriver driver;
    private final Actions action;

    // Constructor to initialize the WebDriver and Actions
    public BrowserMethods(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    // Get the title of the current page
    public String getTitle() {
        return driver.getTitle();
    }

    // Navigate to a specified URL
    public void goTo(String url) {
        driver.navigate().to(url);
    }

    // Maximize the browser window
    public void maximize() {
        driver.manage().window().maximize();
    }

    // Refresh the current page
    public void refresh() {
        driver.navigate().refresh();
    }

    // Press the Escape key
    public void clickEscape() {
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    // Move to a specific WebElement on the page
    public void moveToElement(WebElement element) {
        action.moveToElement(element).perform();
    }
}
