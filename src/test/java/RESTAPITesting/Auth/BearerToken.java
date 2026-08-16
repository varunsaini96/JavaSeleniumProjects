package RESTAPITesting.Auth;

import RESTAPITesting.APIKeyExtraction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BearerToken {

    @Test
    void BearerTokenTesting(){
        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.baseUri("https://gorest.co.in");
        reqSpec.basePath("/public/v2/users");

        JSONObject payload = new JSONObject();
        payload.put("name","Tony S");
        payload.put("email", "tony@example.com");
        payload.put("gender", "male");
        payload.put("status","active");

        reqSpec.header("Authorization", APIKeyExtraction.getTokenID())
                .contentType(ContentType.JSON).body(payload.toJSONString());

        Response response = reqSpec.post();

        Assert.assertEquals(response.getStatusCode(),201);
        System.out.println("Status line: "+response.statusLine());
        System.out.println("Body: "+response.asString());
    }
}
