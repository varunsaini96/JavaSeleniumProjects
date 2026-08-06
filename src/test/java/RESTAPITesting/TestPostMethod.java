package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPostMethod {
    @Test
    void test03(){
        JSONObject jsonObject = new JSONObject(); //To create JSON data in Java.
        jsonObject.put("name","Varun");
        jsonObject.put("job","QE");

        RestAssured.baseURI="https://reqres.in/api/users"; //This tells Rest Assured Whenever I make a request, send it to this URL
        RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue())//given->What we have
                .contentType(ContentType.JSON)//Telling server content type that I am sending JSON
                .body(jsonObject.toJSONString())
                .when().post()
                .then().statusCode(201).log().all();//Verify response
    }

    @Test
    void test04(){
        JSONObject jsonObject = new JSONObject(); //To create JSON data in Java.
        jsonObject.put("name","Varun S");
        jsonObject.put("job","QE");

        RestAssured.baseURI="https://reqres.in/api/users";
        Response response = RestAssured.given()
                .header(APIKeyExtraction.key, APIKeyExtraction.getValue())
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when().post();

        response.then().statusCode(201);

        System.out.println("Status Code : " + response.statusCode());
        System.out.println("Response Time : " + response.time());
        System.out.println("Response Body:" + response.prettyPrint());

        System.out.println("Name : " + response.jsonPath().getString("name"));
        System.out.println("Job : " + response.jsonPath().getString("job"));
        System.out.println("ID : " + response.jsonPath().getString("id"));
        System.out.println("Created At : " + response.jsonPath().getString("createdAt"));
    }
}
