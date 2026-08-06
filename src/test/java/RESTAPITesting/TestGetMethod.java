package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetMethod {
    @Test
    public void test1(){
        Response response = RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue()).queryParam("page","2")
                .get("https://reqres.in/api/users");
        System.out.println("Body: " + response.asString());
        System.out.println("Time taken: " + response.time());
        System.out.println("Status code: " + response.getStatusCode());
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;

        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }

    @Test
    public void test2(){
        RestAssured.baseURI="https://reqres.in/api/users";
        RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue())
                .queryParam("page","2")
                .when().get()
                .then().statusCode(200);
    }
}