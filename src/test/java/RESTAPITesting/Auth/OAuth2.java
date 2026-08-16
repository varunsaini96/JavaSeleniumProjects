package RESTAPITesting.Auth;

import RESTAPITesting.APIKeyExtraction;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OAuth2 {

    static String accessToken;
    @Test
    void GetAccessToken(){
        String clientID = APIKeyExtraction.getOAuth2ClientID();
        String clientSecret = APIKeyExtraction.getOAuth2SecretID();

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.baseUri("https://api-m.sandbox.paypal.com");
        reqSpec.basePath("/v1/oauth2/token");

        //Basic authorization
        Response response = reqSpec.auth().preemptive().basic(clientID,clientSecret).param("grant_type","client_credentials").post();

        response.prettyPrint();
        //print status code & status line
        System.out.println("Response code:" + response.statusCode() );
        System.out.println("status line:" + response.statusLine() );

        //validate repsonse code
        Assert.assertEquals(response.statusCode(), 200,"check for response code");

        //get access token from response body.
        accessToken= response.getBody().path("access_token");
        System.out.println("access token:" + accessToken);
    }

    @Test(dependsOnMethods ="GetAccessToken")
    public void ListInvoice()
    {
        //page=3&page_size=4&total_count_required=true
        Response res= RestAssured.given().auth().oauth2(accessToken).queryParam("page", "3")
                .queryParam("page_size", "4")
                .queryParam("total_count_required", "true")
                .get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");

        System.out.println("------------------LIST INVOICE------------------------");

        res.prettyPrint();
        //print status code & status line
        System.out.println("Response code:" + res.statusCode() );
        System.out.println("status line:" + res.statusLine() );

        //validate repsonse code
        Assert.assertEquals(res.statusCode(), 200,"check for response code");


    }
}
