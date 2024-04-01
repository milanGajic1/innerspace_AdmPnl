package innerspaceAdmPnl.api.common;

import innerspaceAdmPnl.ui.util.CredentialsUtil;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class RestAssuredFunctions {

    private static final String authority = "https://login.microsoftonline.com/" + CredentialsUtil.getTenant() + "/oauth2/v2.0/token";
    private static final String clientId = CredentialsUtil.getClientId();
    private static final String clientSecret = CredentialsUtil.getClientSecret();
    private static final String scope = CredentialsUtil.getScope();

    public static String getAccessToken() {
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                .formParam("client_id", clientId)
                .formParam("scope", scope)
                .formParam("grant_type", "client_credentials")
                .formParam("client_secret", clientSecret)
                .when()
                .post(authority);

        String accessToken = response.jsonPath().getString("access_token");

        if (accessToken == null || accessToken.isEmpty()) {
            throw new RuntimeException("Failed to retrieve access token");
        }

        return accessToken;
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
