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
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjVCM25SeHRRN2ppOGVORGMzRnkwNUtmOTdaRSJ9.eyJhdWQiOiJmMjBkYzc5MC01MTNiLTQ3YjgtOWNkYy1lM2EyZWYxMDIwNDYiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDc0NDJkM2ItYjg1ZS00MmQwLWFkYzEtYWViZTk4MDQxMGY1L3YyLjAiLCJpYXQiOjE3MDY2MDA2NDYsIm5iZiI6MTcwNjYwMDY0NiwiZXhwIjoxNzA2NjA0NTQ2LCJhaW8iOiJBWFFBaS84VkFBQUF2S2hwdmZicnNyOEZFYWtHU1N1RXZIdzZhem43UzBwN01nTEJBVlo1VDk2RmJscCt2QXl1ZmdzSEFlaVZrVmF6R1hmNndpVkV1OUxoRXAyY09RTnR6QUlYTDJBTEFCdndENkhhWjB4RG9XUGpSYjFNeldCWlk2VnBpcmkyK0ZMZXhrSjV5ZWpzOXhJODhVRkthZUlQZWc9PSIsIm5hbWUiOiJNaWxhbiBHYWppYyIsIm5vbmNlIjoiYWFlNGM2ZmMtMDFmMC00OTA0LWI2YTYtNjYzNjY3OWRmNzNhIiwib2lkIjoiNTBlNWRhMzYtZmRkNS00ZTYzLTlmMGMtNWYxODg3MmFjZWUzIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibWlsYW4uZ2FqaWNAaW5uZXJzcGFjZS5ldSIsInJoIjoiMC5BUjhBT3kxRVIxNjQwRUt0d2E2LW1BUVE5WkRIRGZJN1ViaEhuTnpqb3U4UUlFWWNBUVEuIiwicm9sZXMiOlsiUE8iXSwic3ViIjoiODVJSHVGOHh3NFVKSlN5dGRwM2VSVGk0eVR4S0RNaVBlbV8zWk5HV3BsRSIsInRpZCI6IjQ3NDQyZDNiLWI4NWUtNDJkMC1hZGMxLWFlYmU5ODA0MTBmNSIsInV0aSI6ImtJUFBEMHhzMEVHaEV6WG40MTFtQUEiLCJ2ZXIiOiIyLjAifQ.EtAySS53AQI_pomp4meonovscwB4FDjvLXfRJm4vIOHhQB5VxlmIPWZ1ZWQLLBr06Y-xuyeF7xvWUidUgUQ3ux_fabTumWkSV0e7XMjdQnZ56HDYopn0Jg8B22HjRc7i7s5uYCPNBvStTsoep4PA7JuU4JPDHFFFHsv-UUVuRy08XxcPp7aOsYw318m83IHuR70V7kw5Cz_nDofYNEe4piEisSWKyAlZ_tYcG77_163sGWQHgJ1GaZ_7Ecwx7ewD7-5zAgxAgQY6h-Wnc5CdUQVaTs42RGHs7Xdk25otsX_5eP95KOkeSljzP7fKYJRAMj2o9oJoOAN7v2_RdzmI0A";

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
