package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.moduleversion.ApplicationVersion;
import io.restassured.response.Response;

import java.util.List;

public class ApplicationVersionApi {
    public static ResponseValidation validateApplicationsVersions() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.APPLICATIONS_VERSIONS);
        List<ApplicationVersion> applicationVersions = GsonFunctions.parseJsonArrayResponse(jsonResponse, ApplicationVersion[].class);
        assert applicationVersions != null;
        if (applicationVersions.isEmpty()) {
            throw new Exception("Application Versions list is empty");
        }
        return new ResponseValidation();
    }
}
