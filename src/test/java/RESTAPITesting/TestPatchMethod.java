package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPatchMethod {

    @Test
    void test06(){
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("job", "QE");

            RestAssured.baseURI = "https://reqres.in/api/users/999";
            RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue())
                    .contentType(ContentType.JSON).body(jsonObject.toJSONString())
                    .when().patch()
                    .then().statusCode(200).log().all();
        }
    }

}
