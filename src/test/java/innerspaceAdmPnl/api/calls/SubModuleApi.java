package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.SubModules.SubModule;
import innerspaceAdmPnl.api.data.model.SubModules.SubModuleLabel;
import io.restassured.response.Response;

import java.util.List;

public class SubModuleApi {
    public static ResponseValidation validateSubModule() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.SUB_MODULE);
        List<SubModule> subModules = GsonFunctions.parseJsonArrayResponse(jsonResponse, SubModule[].class);
        assert subModules != null;
        if (subModules.isEmpty()) {
            throw new Exception("Sub-Modules list is empty");
        }
        return new ResponseValidation();
    }
    public static ResponseValidation validateSubModuleLabel() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.SUB_MODULE_LABEL);
        List<SubModuleLabel> subModuleLabels = GsonFunctions.parseJsonArrayResponse(jsonResponse, SubModuleLabel[].class);
        assert subModuleLabels != null;
        if (subModuleLabels.isEmpty()) {
            throw new Exception("Sub-Modules Labels list is empty");
        }
        return new ResponseValidation();
    }
}
