package innerspaceAdmPnl.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Use WebDriverManager to manage the Edge driver
            WebDriverManager.edgedriver().setup();

            // Initialize the EdgeDriver
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
