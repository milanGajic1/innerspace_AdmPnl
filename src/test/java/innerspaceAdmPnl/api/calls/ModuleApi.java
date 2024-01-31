package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.moduleversion.Module;
import io.restassured.response.Response;

import java.util.List;

public class ModuleApi {
    public static ResponseValidation validateModule() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.MODULE);
        List<Module> modules = GsonFunctions.parseJsonArrayResponse(jsonResponse, Module[].class);
        assert modules != null;
        if (modules.isEmpty()) {
            throw new Exception("Modules list is empty");
        }
        return new ResponseValidation();
    }
}
