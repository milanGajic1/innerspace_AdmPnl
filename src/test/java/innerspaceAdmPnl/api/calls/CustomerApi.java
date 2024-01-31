package innerspaceAdmPnl.api.calls;

import innerspaceAdmPnl.api.common.GsonFunctions;
import innerspaceAdmPnl.api.common.ResponseValidation;
import innerspaceAdmPnl.api.common.RestAssuredFunctions;
import innerspaceAdmPnl.api.constants.ApiEndpoints;
import innerspaceAdmPnl.api.data.model.common.Customer;
import io.restassured.response.Response;

import java.util.List;

public class CustomerApi {
    public static ResponseValidation validateCustomer() throws Exception {
        Response jsonResponse = RestAssuredFunctions.sendGetRequest(ApiEndpoints.CUSTOMER);
        List<Customer> customers = GsonFunctions.parseJsonArrayResponse(jsonResponse, Customer[].class);
        assert customers != null;
        if (customers.isEmpty()) {
            throw new Exception("Customer list is empty");
        }
        return new ResponseValidation();
    }
}
