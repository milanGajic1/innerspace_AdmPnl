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
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjVCM25SeHRRN2ppOGVORGMzRnkwNUtmOTdaRSJ9.eyJhdWQiOiJmMjBkYzc5MC01MTNiLTQ3YjgtOWNkYy1lM2EyZWYxMDIwNDYiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDc0NDJkM2ItYjg1ZS00MmQwLWFkYzEtYWViZTk4MDQxMGY1L3YyLjAiLCJpYXQiOjE3MDY1MzAzNTIsIm5iZiI6MTcwNjUzMDM1MiwiZXhwIjoxNzA2NTM0MjUyLCJhaW8iOiJBWFFBaS84VkFBQUE5NDZpV2QxVmYzNjd0Qi93R1ZEWmIxTndRbVI5bWZMaldoM0xPNmVuK1NKUFo5OVoxbXZLRURQSGFuelE5a2Y3YmRaWjQyZENiV2p2K1dKNDdCa09UZHhJVUdBWjlBUm1SbHlaZTlCMTM1TWpqdC9nSzlIdmtjdk5uVmNadStjak01VzdvaDJJVnRuOXkwUkZyT1VhelE9PSIsIm5hbWUiOiJNaWxhbiBHYWppYyIsIm5vbmNlIjoiODBiNWE5ZjctZTdlZC00OWNjLThhMGYtYjU4NjY5NTU0ODYxIiwib2lkIjoiNTBlNWRhMzYtZmRkNS00ZTYzLTlmMGMtNWYxODg3MmFjZWUzIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibWlsYW4uZ2FqaWNAaW5uZXJzcGFjZS5ldSIsInJoIjoiMC5BUjhBT3kxRVIxNjQwRUt0d2E2LW1BUVE5WkRIRGZJN1ViaEhuTnpqb3U4UUlFWWNBUVEuIiwicm9sZXMiOlsiUE8iXSwic3ViIjoiODVJSHVGOHh3NFVKSlN5dGRwM2VSVGk0eVR4S0RNaVBlbV8zWk5HV3BsRSIsInRpZCI6IjQ3NDQyZDNiLWI4NWUtNDJkMC1hZGMxLWFlYmU5ODA0MTBmNSIsInV0aSI6IjRpSjd5c3lBbDA2VmY1WWx1emREQUEiLCJ2ZXIiOiIyLjAifQ.KKzfEPx48BMLule4GEOrM5GFhvQhIXx0lYcrh4GRKEgjNZOi4J7X9ZjK6W_IEt0_5uD0XfHq83wMKOmNI6ME78x2wsfwI13x0ARZla_lEf3VAgv2thPwNZbpJbIgmr8Mi7GhAGw-EK4EjyZyk0Xd8ZbAFs0XBwk4GTpZ9n9YqSYC4aRnbdiyJDpoujiFUgWhEPTekqjb1sgOFfG1TCkHLUA9q8Hf-fcH_-GWIGrC4eRrguk5ef2iA52odO7aECPyiQcwmAHfQjpBwJeYuXE4poY_UTsRvh0Q_MmWpZBfDN3z5_02tdn-O2b6Vxa2RmclV14w_B1paT_XkskMPMghpg";

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
