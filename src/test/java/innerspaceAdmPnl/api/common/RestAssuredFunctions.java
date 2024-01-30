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
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjVCM25SeHRRN2ppOGVORGMzRnkwNUtmOTdaRSJ9.eyJhdWQiOiJmMjBkYzc5MC01MTNiLTQ3YjgtOWNkYy1lM2EyZWYxMDIwNDYiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDc0NDJkM2ItYjg1ZS00MmQwLWFkYzEtYWViZTk4MDQxMGY1L3YyLjAiLCJpYXQiOjE3MDY2MTgzOTQsIm5iZiI6MTcwNjYxODM5NCwiZXhwIjoxNzA2NjIyMjk0LCJhaW8iOiJBWFFBaS84VkFBQUFiaHd5dTdNS3NFc3pTd0pHeVN6QjU4cVJhVjkxUmtVMUhPWFZsTmQvYUVjYS8wenB2OFdVUU0wZjFKWlZWbEQ0dU9MU2E5MVlZMlVQd1dvZ3VVTWJOa3Vud0dvNXgvTEw0QmM3MTU2Y1d4VE9xUUhYT3MxUHlFRnN2NHV2dWRLd04xNkFsL09NeUNiT3pPRCt3c2J3MUE9PSIsIm5hbWUiOiJNaWxhbiBHYWppYyIsIm5vbmNlIjoiODY4ODhhMGYtOWIxOC00MWZkLTgxNWQtYWMwZDRiN2RmMGUxIiwib2lkIjoiNTBlNWRhMzYtZmRkNS00ZTYzLTlmMGMtNWYxODg3MmFjZWUzIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibWlsYW4uZ2FqaWNAaW5uZXJzcGFjZS5ldSIsInJoIjoiMC5BUjhBT3kxRVIxNjQwRUt0d2E2LW1BUVE5WkRIRGZJN1ViaEhuTnpqb3U4UUlFWWNBUVEuIiwicm9sZXMiOlsiUE8iXSwic3ViIjoiODVJSHVGOHh3NFVKSlN5dGRwM2VSVGk0eVR4S0RNaVBlbV8zWk5HV3BsRSIsInRpZCI6IjQ3NDQyZDNiLWI4NWUtNDJkMC1hZGMxLWFlYmU5ODA0MTBmNSIsInV0aSI6Im4zRW5PMUNDY1VlbkVYcVkyc2Q2QUEiLCJ2ZXIiOiIyLjAifQ.2DH2qzGwnkVkHEeIWBsj3cv4kVOUqwF3wNzjSN7RbgdOd9N9HsJZ7g4w1x9R8LIge6MXKrlq-eG_6UFBu2I8mGjW5Wn547HzFF1-zdNt7b5Wlc5r5LyWbT49qA5a17nIu2Pkzs-8oJQtjHEnI0sQ9PrHoj8pLFDty3BeT9qYiy-ufrT7pblCCBa83rdQaLKDcx3kAi2OJt6QifE5-COA-VeVxZSdCnfWpnXh7MUyy-as5MpJ6MD1QF-uSA2VAXnFtdI--H8k1WyGcVphdl_WK1rjF1mGfi7CmQgtEMu9AX8wpgUPjadcfJQT9Dh_-1rZnnFNBjl6L9ioBbQs8F0iMA";

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
