package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.accesspermission.AccessPermission;
import io.restassured.response.Response;

import java.util.List;

public class AccessPermissionApi {

    public static ResponseValidation validateAccessPermission() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.ACCESS_PERMISSION);
        List<AccessPermission> accessPermissions = GsonFunctions.parseJsonArrayResponse(jsonResponse, AccessPermission[].class);
        assert accessPermissions != null;
        if (accessPermissions.isEmpty()) {
            throw new Exception("Access Permissions list is empty");
        }
        return new ResponseValidation();
    }
}

