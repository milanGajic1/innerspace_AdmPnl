package innerspaceAdmPnl.api.common;

import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import io.restassured.response.Response;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class RestAssuredFunctions {

    private static String authority = "https://login.microsoftonline.com/{tenant}/";
    private static String clientId = "your_client_id";
    private static String clientSecret = "your_client_secret";
    private static String scope = "your_scope";

    private static String getAccessToken() throws Exception {
        ConfidentialClientApplication app = ConfidentialClientApplication.builder(
                        clientId,
                        ClientCredentialFactory.createFromSecret(clientSecret))
                .authority(authority)
                .build();

        ClientCredentialParameters clientCredentialParam = ClientCredentialParameters.builder(
                        Collections.singleton(scope))
                .build();

        IAuthenticationResult result = app.acquireToken(clientCredentialParam).join();
        return result.accessToken();
    }

    public static Response sendGetRequest(String endpoint) throws Exception {
        String token = getAccessToken();

        return given()
                .header("Authorization", "Bearer " + token)
//                .log().all() // Logs the request details
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response sendPostRequest(String endpoint, String body) throws Exception {
        String token = getAccessToken();

        return given()
            .header("Authorization", "Bearer " + token)
            .body(body)
            .when()
            .post(endpoint)
            .then()
            .extract()
            .response();
    }

}
