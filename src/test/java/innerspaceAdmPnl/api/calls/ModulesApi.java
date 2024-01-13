package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredNoAuthFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.moduleversion.ModuleVersion;
import io.restassured.response.Response;

public class ModulesApi {

    public static ResponseValidation validateModulesVersion() {
        Response jsonResponse = RestAssuredNoAuthFunctions.get(ApiEndpoints.MODULE_VERSION);
        return GsonFunctions.verifyResponse(jsonResponse, ModuleVersion.class);
    }

}
