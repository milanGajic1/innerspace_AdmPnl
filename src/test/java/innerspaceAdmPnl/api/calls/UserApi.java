package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.common.User;
import io.restassured.response.Response;

import java.util.List;

public class UserApi {
    public static ResponseValidation validateUser() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.USER);
        List<User> users = GsonFunctions.parseJsonArrayResponse(jsonResponse, User[].class);
        assert users != null;
        if (users.isEmpty()) {
            throw new Exception("Users list is empty");
        }
        return new ResponseValidation();
    }
}
