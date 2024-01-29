package innerspaceAdmPnl.api.schemavalidation.suites;

import innerspaceAdmPnl.api.schemavalidation.asserts.ValidationSchemaAssert;
import innerspaceAdmPnl.api.calls.ModulesApi;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ModuleVersionTests {
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Module Version Response")
    public static void verifyGetModuleVersionResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(ModulesApi.validateModulesVersion());
    }
}

