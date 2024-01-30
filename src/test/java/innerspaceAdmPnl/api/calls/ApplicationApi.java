package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.moduleversion.Application;
import io.restassured.response.Response;

import java.util.List;

public class ApplicationApi {
    public static ResponseValidation validateApplications() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.APPLICATIONS);
        List<Application> applications = GsonFunctions.parseJsonArrayResponse(jsonResponse, Application[].class);
        assert applications != null;
        if (applications.isEmpty()) {
            throw new Exception("Application list is empty");
        }
        return new ResponseValidation();
    }
}
