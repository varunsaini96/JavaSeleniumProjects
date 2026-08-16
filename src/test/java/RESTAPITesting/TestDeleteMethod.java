package RESTAPITesting;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestDeleteMethod {
    @Test
    void test07(){
        RestAssured.baseURI = "https://reqres.in/api/users/999";
        RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue())
                .when().delete()
                .then().statusCode(204);
    }
}
