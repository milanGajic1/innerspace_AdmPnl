package innerspaceAdmPnl.ui.pages.login;

import innerspaceAdmPnl.ui.config.Constants;
import innerspaceAdmPnl.ui.config.Waits;
import innerspaceAdmPnl.ui.config.Wrappers;
import innerspaceAdmPnl.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;


public class LogInPage extends BasePage {

    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");
    private By emailField = By.id("email_field_id");
    private By passwordField = By.id("password_field_id");
    private By loggedInUser = By.xpath("//span[@class='css-1y8io4']");
    private By existingMicrosoftUser = By.xpath("//div[@data-bind='text: ((session.isSignedIn || session.isSamsungSso) && session.unsafe_fullName) || session.unsafe_displayName']");
    private String originalWindowHandle;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void loginWithCredentials(String url, String email, String password) {
        navigateToPage(url);
        clickSignIn();
        enterMicrosoftCredentials(email, password);
    }

    public void login(String url) {
        navigateToPage(url);
        clickSignIn();
        clickOnExistingMicrosoftUser();
    }

    public void navigateToPage(String url) {
        driver.get(url);
        originalWindowHandle = driver.getWindowHandle();
    }

    public void clickSignIn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT); // wait for up to 10 seconds
            WebElement signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
            Wrappers.actionClick(signInBtn);
            handleNewWindowOrFrame();
        } catch (TimeoutException e) {
            System.out.println("Sign In button not visible after waiting.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private void handleNewWindowOrFrame() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindowHandle.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickOnExistingMicrosoftUser() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
        WebElement userElement = wait.until(ExpectedConditions.elementToBeClickable(existingMicrosoftUser));
        userElement.click();
        driver.switchTo().window(originalWindowHandle);
    }

    public void enterMicrosoftCredentials(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        WebElement passwordElement = driver.findElement(passwordField);
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordElement.submit();
        driver.switchTo().window(originalWindowHandle);
    }

    public boolean isUserLoggedIn() {
        try {
            WebElement badgeElement = Waits.waitToBeVisible(loggedInUser);
            if (badgeElement != null) {
                String colorValue = badgeElement.getCssValue("background-color");
                String rgbColor = Color.fromString(colorValue).asRgb();
                return rgbColor.equals("rgb(113, 221, 55)");
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error checking login status: " + e.getMessage());
            return false;
        }
    }
}
