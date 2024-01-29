package innerspaceAdmPnl.api.schemavalidation.suites;

import innerspaceAdmPnl.api.schemavalidation.asserts.ValidationSchemaAssert;
import innerspaceAdmPnl.api.calls.ModulesApi;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class ModuleVersionTests {

    private static final Logger logger = LogManager.getLogger(ModuleVersionTests.class);

    @BeforeMethod
    public void logStart(Method method) {
        logger.info("Starting test: " + method.getName());
    }

    @Test(groups = {"SchemaValidation"})
    @Description("Validate Module Version Response")
    public static void verifyGetModuleVersionResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(ModulesApi.validateModulesVersion());
    }

    @AfterMethod
    public void logEnd(Method method) {
        logger.info("Finished test: " + method.getName());
    }
}

