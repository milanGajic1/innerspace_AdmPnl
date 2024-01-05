package innerspaceAdmPnl.ui.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import innerspaceAdmPnl.ui.config.Constants;

public class TitleTest extends BaseTest {

    @Test
    public void testAdminPanelTitle() {
        driver.get(Constants.INNERSPACE_ADMIN_PANEL_URL);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, Constants.INNERSPACE_ADMIN_PANEL_TITLE);
    }

}
