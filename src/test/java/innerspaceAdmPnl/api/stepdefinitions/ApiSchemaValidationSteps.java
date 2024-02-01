package innerspaceAdmPnl.api.stepdefinitions;

import innerspaceAdmPnl.api.calls.*;
import innerspaceAdmPnl.api.common.ResponseValidation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ApiSchemaValidationSteps {

    private ResponseValidation responseValidation;
    private String apiEndpoint;

    @Given("the {string} API is queried")
    public void the_api_is_queried(String apiName) {
        this.apiEndpoint = apiName;
        System.out.println(apiName + " API test started");
    }

    @When("the response is received")
    public void the_response_is_received() throws Exception {
        switch (apiEndpoint) {
            case "Access Permission":
                responseValidation = AccessPermissionApi.validateAccessPermission();
                break;
            case "Module Version":
                responseValidation = ModulesApi.validateModulesVersion();
                break;
            case "Applications":
                responseValidation = ApplicationApi.validateApplications();
                break;
            case "Applications Versions":
                responseValidation = ApplicationVersionApi.validateApplicationsVersions();
                break;
            case "Customers":
                responseValidation = CustomerApi.validateCustomer();
                break;
            case "Module":
                responseValidation = ModuleApi.validateModule();
                break;
            case "Role":
                responseValidation = RoleApi.validateRole();
                break;
            case "Sub-Modules":
                responseValidation = SubModuleApi.validateSubModule();
                break;
            case "Sub-Modules Labels":
                responseValidation = SubModuleApi.validateSubModuleLabel();
                break;
            case "User":
                responseValidation = UserApi.validateUser();
                break;
            default:
                throw new Exception("API endpoint not recognized: " + apiEndpoint);
        }
    }

    @Then("the response conforms to the expected {string} schema")
    public void the_response_conforms_to_the_expected_schema(String apiName) {
        Assert.assertTrue(responseValidation.getUnknownFields().isEmpty(), "Unknown fields present in " + apiName + " response");
        Assert.assertTrue(responseValidation.getWrongTypeFields().isEmpty(), "Fields with wrong type detected in " + apiName + " response");
        Assert.assertTrue(responseValidation.getClassRequiredFields().isEmpty(), "Missing required fields in " + apiName + " response");
        Assert.assertTrue(responseValidation.getRequiredFieldMissingValue().isEmpty(), "Required fields missing values in " + apiName + " response");
    }
}
