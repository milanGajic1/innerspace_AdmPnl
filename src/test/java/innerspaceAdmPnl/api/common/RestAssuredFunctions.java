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
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjVCM25SeHRRN2ppOGVORGMzRnkwNUtmOTdaRSJ9.eyJhdWQiOiJmMjBkYzc5MC01MTNiLTQ3YjgtOWNkYy1lM2EyZWYxMDIwNDYiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDc0NDJkM2ItYjg1ZS00MmQwLWFkYzEtYWViZTk4MDQxMGY1L3YyLjAiLCJpYXQiOjE3MDY3MDk0MDAsIm5iZiI6MTcwNjcwOTQwMCwiZXhwIjoxNzA2NzEzMzAwLCJhaW8iOiJBVlFBcS84VkFBQUFBdzRpcC83azhwWitudDI3Y3IrdUMzckJXd1BMTk9KSGQxS3BCRlhGdzNCY28vSi9tZXFBdU1CN2xGbkRXTFM0bU5rZ1RXWTg3ZE0vTjBHbE1tdnVOdnVtUjVaSXVIYkxpeW82bDlSemVWRT0iLCJuYW1lIjoiVGVzdCBVc2VyIiwibm9uY2UiOiIyNzdiNjc5Yi0yOWE5LTQ3YWUtYmE4MS05Y2JjODdjOWVhYTciLCJvaWQiOiJlMzMwMWNmOS1hYzRhLTQxNmUtYmYxMC05ZTg4YTg5NmQ1N2UiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ0ZXN0LnVzZXJAaW5uZXJzcGFjZS5ldSIsInJoIjoiMC5BUjhBT3kxRVIxNjQwRUt0d2E2LW1BUVE5WkRIRGZJN1ViaEhuTnpqb3U4UUlFWWNBYXcuIiwicm9sZXMiOlsiQWRtaW4iXSwic3ViIjoiMVpiVzRVVXpiODNCdnNYbzNQbDdvVkhfZ3Q2T3FLUmQxYzRrV2hmWTdOUSIsInRpZCI6IjQ3NDQyZDNiLWI4NWUtNDJkMC1hZGMxLWFlYmU5ODA0MTBmNSIsInV0aSI6IlItX3VVQ0dUOFVlVzFfWjN2Y2FwQUEiLCJ2ZXIiOiIyLjAifQ.PGqfA5p8mGDJAnGJNg9BaUJcnyw0w66gArNvzuq9F_JwiMsFGgE4rbQn6NLGPKF9ZhzNjHvEGlJ7wy6h4x64FYEZ0cdRS9jnqudHXeiNEjgGnSD9S2ZMNXTFUkGiTciqlL5ENr2-DKY7f1QEzjaEr1GaUONrLDJA0_5gyYZrgCXTbJZ0C-h166QHTBgurW6XCkMKgbGckKh0Oa_NRqoweh8fZZxjJKmTv0OD4qgMmXNEBBgb6YDrkEJcCKYrSMeA_24EhqO037Me4q808AhEbpU3PL01t0uncphO4M0YOo1neZwarTzjIRW2MtHv1Xx5ANw-mNCw8V5iqDfzMS_4aw";

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
