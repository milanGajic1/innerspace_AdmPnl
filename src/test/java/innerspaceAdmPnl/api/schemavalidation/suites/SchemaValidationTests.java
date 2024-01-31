package innerspaceAdmPnl.api.schemavalidation.suites;

import innerspaceAdmPnl.api.calls.*;
import innerspaceAdmPnl.api.schemavalidation.asserts.ValidationSchemaAssert;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class SchemaValidationTests {

    private static final Logger logger = LogManager.getLogger(SchemaValidationTests.class);

    @BeforeMethod
    public void logStart(Method method) {
        logger.info("Starting test: " + method.getName());
    }

    @Test(groups = {"SchemaValidation"})
    @Description("Validate Module Version Response")
    public static void verifyGetModuleVersionResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(ModulesApi.validateModulesVersion());
    }

    @Test(groups = {"SchemaValidation"})
    @Description("Validate Access Permission Response")
    public static void verifyGetAccessPermissionResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(AccessPermissionApi.validateAccessPermission());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Applications Response")
    public static void verifyGetApplicationsResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(ApplicationApi.validateApplications());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Applications Versions Response")
    public static void verifyGetApplicationsVersionsResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(ApplicationVersionApi.validateApplicationsVersions());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Customers Response")
    public static void verifyGetCustomerResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(CustomerApi.validateCustomer());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Module Response")
    public static void verifyGetModuleResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(ModuleApi.validateModule());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Role Response")
    public static void verifyGetRoleResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(RoleApi.validateRole());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Sub-Modules Response")
    public static void verifyGetSubModulesResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(SubModuleApi.validateSubModule());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate Sub-Modules Labels Response")
    public static void verifyGetSubModulesLabelResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(SubModuleApi.validateSubModuleLabel());
    }
    @Test(groups = {"SchemaValidation"})
    @Description("Validate User Response")
    public static void verifyGetUserResponse() throws Exception {
        new ValidationSchemaAssert().assertResponseStructure(UserApi.validateUser());
    }

    @AfterMethod
    public void logEnd(Method method) {
        logger.info("Finished test: " + method.getName());
        logger.info("Test '" + method.getName() + "' was successful.");
    }
}

