package innerspaceAdmPnl.ui.pages.login;

import innerspaceAdmPnl.ui.config.Constants;
import innerspaceAdmPnl.ui.config.Waits;
import innerspaceAdmPnl.ui.config.Wrappers;
import innerspaceAdmPnl.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasePage {

    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");
    private By emailField = By.xpath("//*[@id=\"i0116\"]");
    private By passwordField = By.xpath("//*[@id=\"i0118\"]");
    private By loggedInElementSelector = By.xpath("//img[@alt='innerspace-logo']");
    private By existingMicrosoftUser = By.xpath("//div[@data-bind='text: ((session.isSignedIn || session.isSamsungSso) && session.unsafe_fullName) || session.unsafe_displayName']");


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void clickSignIn() {
        Waits.waitForPageLoadComplete();
        Wrappers.click(driver.findElement(signInButton));
        handleNewWindowOrFrame();
    }

    private void handleNewWindowOrFrame() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public void clickOnExistingMicrosoftUser() {
        WebDriverWait wait = new WebDriverWait(driver,Constants.DEFAULT_WAIT_TIMEOUT);
        WebElement userElement = wait.until(ExpectedConditions.elementToBeClickable(existingMicrosoftUser));
        userElement.click();
        driver.switchTo().window(driver.getWindowHandle()); // Switch back to the original window
    }
    public void enterMicrosoftCredentials(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(this.emailField));
        WebElement passwordField = driver.findElement(this.passwordField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordField.submit();
        driver.switchTo().window(driver.getWindowHandle()); // Switch back to the original window
    }

    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
        WebElement loggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInElementSelector));
        return loggedInElement.isDisplayed();
    }

}
