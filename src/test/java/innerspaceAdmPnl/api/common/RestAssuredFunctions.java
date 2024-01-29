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
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjVCM25SeHRRN2ppOGVORGMzRnkwNUtmOTdaRSJ9.eyJhdWQiOiJmMjBkYzc5MC01MTNiLTQ3YjgtOWNkYy1lM2EyZWYxMDIwNDYiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDc0NDJkM2ItYjg1ZS00MmQwLWFkYzEtYWViZTk4MDQxMGY1L3YyLjAiLCJpYXQiOjE3MDY1MTUyMTAsIm5iZiI6MTcwNjUxNTIxMCwiZXhwIjoxNzA2NTE5MTEwLCJhaW8iOiJBWFFBaS84VkFBQUF3cG95WXNGTWlpSlZaTHUrSDBLQVFWaUt1MWdneHhtMHFzZTMvdklTM01oVFNLK0xlY3U5WU5yekJBeHJmSXNORWhrL2ZwdHZRMXJiQUt3cTluT1U1c2p4NnZ5RW81T1NNbFM0cTU1alBxaVg4TFlVaHN1K0NGbTlYQ2hRbWhlaVpnM3U1NGE1czlGb2tERTN4TGI2SEE9PSIsIm5hbWUiOiJNaWxhbiBHYWppYyIsIm5vbmNlIjoiOGIwZjM5ZjMtMWU4Yy00Y2I4LWEyZDYtYjZkZjM0ZmZmYzRiIiwib2lkIjoiNTBlNWRhMzYtZmRkNS00ZTYzLTlmMGMtNWYxODg3MmFjZWUzIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibWlsYW4uZ2FqaWNAaW5uZXJzcGFjZS5ldSIsInJoIjoiMC5BUjhBT3kxRVIxNjQwRUt0d2E2LW1BUVE5WkRIRGZJN1ViaEhuTnpqb3U4UUlFWWNBUVEuIiwicm9sZXMiOlsiRGV2ZWxvcGVyIl0sInN1YiI6Ijg1SUh1Rjh4dzRVSkpTeXRkcDNlUlRpNHlUeEtETWlQZW1fM1pOR1dwbEUiLCJ0aWQiOiI0NzQ0MmQzYi1iODVlLTQyZDAtYWRjMS1hZWJlOTgwNDEwZjUiLCJ1dGkiOiJ6a0UzaDZsS1BrU2l3czBTUUw4MUFBIiwidmVyIjoiMi4wIn0.VinwRlx-N5LkTc6_DGEsdvmxYgS0oAF_9D8ae2lazIq0Qn5goicI_z2ax_OEr7p7Yn_T7EXdfjG3hVc3KC1WDKRyPkrSpIp2P5QbU_SVRHKo3iTyqA2CID6bbktIBRU-HvdF3-DhVeyuMijHWfUNm_YOx3-fl5MW7z2OAhy6Nf-wM73R4w21JaJb-XH_YKHtDXrn_2YxbLBU6PuaH662_U32J3UUqsVUAtswlGWhNgrZ2lyIOUCxs5RymGfRvBhv49mK0ZNaXBQ-aMIvTLeDpieE3jombd3dB5C-l7aCN3m6WQPzYhnAaPc9lIlJ8TquLWC2fAglHpM88msnoZnzIg";

        return given()
                .header("Authorization", "Bearer " + token)
                .log().all() // Logs the request details
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
