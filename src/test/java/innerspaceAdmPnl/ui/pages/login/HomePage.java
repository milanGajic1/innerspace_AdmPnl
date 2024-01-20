package innerspaceAdmPnl.ui.pages.login;

import innerspaceAdmPnl.ui.config.Constants;
import innerspaceAdmPnl.ui.config.Waits;
import innerspaceAdmPnl.ui.config.Wrappers;
import innerspaceAdmPnl.ui.util.CredentialsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static innerspaceAdmPnl.ui.config.Wrappers.*;

public class HomePage {
    private final WebDriver driver;
    private final By darkModeButton = By.xpath("*//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-11p00x5']");
    private final By profileAvatar = By.xpath("*//span[@class='css-1y8io4']");
    private final By profileButton = By.xpath("*//div[@class='MuiBox-root css-9vqxyq']");
    private final By mainContent = By.cssSelector("body");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean assertDarkMode() {
        WebElement mainContentElement = driver.findElement(mainContent);
        Waits.waitToBeVisible(mainContentElement);

        // Retrieve CSS values
        String backgroundColor = mainContentElement.getCssValue("background-color");
        String textColor = mainContentElement.getCssValue("color");

        // Define expected values for dark mode
        String expectedBackgroundColor = "rgba(35, 35, 51, 1)";
        String expectedTextColor = "rgba(219, 219, 235, 0.87)";

        // Assert the background color and text color
        Assert.assertEquals(backgroundColor, expectedBackgroundColor, "Background color does not match the expected value for dark mode.");
        Assert.assertEquals(textColor, expectedTextColor, "Text color does not match the expected value for dark mode.");
        return true;
    }

    public void clickDarkModeButton() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
//            WebElement darkModeBtn = wait.until(ExpectedConditions.elementToBeClickable(darkModeButton));
//            Wrappers.actionClick(darkModeBtn);
//        } catch (TimeoutException e) {
//            System.out.println("Dark Mode button not clickable after waiting.");
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
        clickWithWait(darkModeButton);
    }

    public void openUserProfilePage() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
//            WebElement profileAvtr = wait.until(ExpectedConditions.elementToBeClickable(profileAvatar));
//            Wrappers.actionClick(profileAvtr);
//        } catch (TimeoutException e) {
//            System.out.println("Profile Avatar button not clickable after waiting.");
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
//            WebElement profileBtn = wait.until(ExpectedConditions.elementToBeClickable(profileButton));
//            Wrappers.actionClick(profileBtn);
//        } catch (TimeoutException e) {
//            System.out.println("Profile button button not clickable after waiting.");
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
        clickWithWait(profileAvatar);
        clickWithWait(profileButton);
        System.out.println("----------------------------------");
    }

    public void assertProfilePage(String email) {
        Assert.assertEquals(CredentialsUtil.getEmail(),email);
    }

}
