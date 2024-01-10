package innerspaceAdmPnl.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserManager {
    private static WebDriver driver;
    private BrowserManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the WebDriver instance here, for example using EdgeDriver
            driver = new EdgeDriver();
            // Perform any additional setup, like maximizing the window
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure driver is set to null after quitting
        }
    }
}
