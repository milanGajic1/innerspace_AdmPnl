package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.moduleversion.ModuleVersion;
import io.restassured.response.Response;

import java.util.List;

public class ModulesApi {

    public static ResponseValidation validateModulesVersion() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.MODULE_VERSION);
        List<ModuleVersion> moduleVersions = GsonFunctions.parseJsonArrayResponse(jsonResponse, ModuleVersion[].class);
        assert moduleVersions != null;
        if (moduleVersions.isEmpty()) {
            throw new Exception("Module Versions list is empty");
        }
        return new ResponseValidation();
    }

}