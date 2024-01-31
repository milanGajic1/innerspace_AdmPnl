package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.common.Role;
import io.restassured.response.Response;

import java.util.List;

public class RoleApi {
    public static ResponseValidation validateRole() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.ROLE);
        List<Role> roles = GsonFunctions.parseJsonArrayResponse(jsonResponse, Role[].class);
        assert roles != null;
        if (roles.isEmpty()) {
            throw new Exception("Roles list is empty");
        }
        return new ResponseValidation();
    }
}
