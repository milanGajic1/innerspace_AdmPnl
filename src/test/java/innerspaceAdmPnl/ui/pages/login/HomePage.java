package innerspaceAdmPnl.ui.pages.login;

import innerspaceAdmPnl.ui.config.Waits;
import innerspaceAdmPnl.ui.config.Wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private By darkModeButton =By.className("MuiIconButton-root");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isPageInDarkMode() {
        WebElement mainContent = driver.findElement(By.cssSelector(".layout-page-content.css-zyg32b"));
        WebElement headerTitle = driver.findElement(By.cssSelector(".MuiCardHeader-title"));
        WebElement pageContent = driver.findElement(By.cssSelector(".MuiTypography-body1"));

        // Check for elements, styles, or classes that indicate dark mode
        boolean isMainContentVisible = mainContent.isDisplayed();
        boolean isHeaderTitleVisible = headerTitle.isDisplayed();
        boolean isPageContentVisible = pageContent.isDisplayed();

        // You may add additional checks specific to your dark mode elements

        // Example: Check for a dark mode class or style on an element
        boolean isDarkModeClassPresent = mainContent.getAttribute("class").contains("dark-mode");

        return isMainContentVisible && isHeaderTitleVisible && isPageContentVisible && isDarkModeClassPresent;
    }

    public void clickDarkModeButton() {
        WebElement darkModeBtn = Waits.waitToBeClickable(darkModeButton);
        if (darkModeBtn != null) {
            Wrappers.actionClick(darkModeBtn);
        } else {
            System.out.println("Dark Mode button not clickable.");
        }
    }

}
