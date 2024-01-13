package innerspaceAdmPnl.api.integration.suites;

import innerspaceAdmPnl.api.integration.asserts.ValidationSchemaAssert;
import innerspaceAdmPnl.api.calls.ModulesApi;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ModuleVersionTests {
    @Test(groups = {"integration"})
    @Description("Allure description for this test")
    public static void verifyGetUserByIdResponse() {
        new ValidationSchemaAssert().assertResponseStructure(ModulesApi.validateModulesVersion());
    }
}

