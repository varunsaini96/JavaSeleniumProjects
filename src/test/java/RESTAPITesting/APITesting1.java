package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITesting1 {
    @Test
    public void testing(){
        Response res = RestAssured
                .given()
                .header(APIKeyExtraction.key, APIKeyExtraction.getValue())
                .when()
                .get("https://reqres.in/api/users/2");
        System.out.println(res.asPrettyString());
        System.out.println("Status code: "+res.getStatusCode());
    }
}
