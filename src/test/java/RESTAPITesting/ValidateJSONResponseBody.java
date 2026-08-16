package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ValidateJSONResponseBody {

    @Test
    void responseBody(){
        RequestSpecification reqSpec =  RestAssured.given();
        reqSpec.baseUri("https://reqres.in");
        reqSpec.basePath("/api/users");
        reqSpec.header(APIKeyExtraction.key,APIKeyExtraction.getValue());

        Response response = reqSpec.get();

        String body = response.getBody().asPrettyString();
        System.out.println(body);
        System.out.println();
        JsonPath jsonPathView = response.getBody().jsonPath();

        System.out.println("---------------------------------------------");
        System.out.println();
        String firstName = jsonPathView.get("data[0].first_name");
        System.out.println("First Name: " + firstName);

    }
}
