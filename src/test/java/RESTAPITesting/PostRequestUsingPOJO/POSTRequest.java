package RESTAPITesting.PostRequestUsingPOJO;

import RESTAPITesting.APIKeyExtraction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POSTRequest {

    String id;
    @Test
    void postReq(){

        POJO data = new POJO();
        data.setName("Katrina");
        data.setJob("HR");

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://reqres.in/api/users");
        rs.header(APIKeyExtraction.key,APIKeyExtraction.getValue());
        rs.contentType(ContentType.JSON).body(data);

        Response response = rs.post();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.log().all();
        id = response.jsonPath().getString("id");
    }

    @Test
    void deleteReq(){
        RestAssured.given().baseUri("https://reqres.in/api/users/"+id)
                .header(APIKeyExtraction.key,APIKeyExtraction.getValue())
                .when().delete()
                .then().statusCode(204);
    }
}
