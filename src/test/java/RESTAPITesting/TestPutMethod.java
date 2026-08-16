package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPutMethod {

    @Test
    void test05(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Varun Singh");
        jsonObject.put("job", "QA");

        RestAssured.baseURI = "https://reqres.in/api/users/999";
        RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue())
                .contentType(ContentType.JSON).body(jsonObject.toJSONString())
                .when().put()
                .then().statusCode(200).log().all();
    }
}
