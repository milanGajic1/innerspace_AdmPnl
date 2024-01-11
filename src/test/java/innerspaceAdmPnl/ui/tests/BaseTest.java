package innerspaceAdmPnl.ui.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import innerspaceAdmPnl.ui.browser.BrowserManager;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown(ITestResult result) {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            try {
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                File source = ts.getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
//                logger.info("Screenshot taken for failed test: " + result.getName());
//            } catch (Exception e) {
//                logger.error("Exception while taking screenshot: ", e);
//            }
//        }
//        BrowserManager.closeDriver();
//    }
@AfterMethod(alwaysRun = true)
public void tearDownMethod() {
    // Common teardown logic (you might leave this empty)
}

}
