package RESTAPITesting.PostReqUsingJSONFile;

import RESTAPITesting.APIKeyExtraction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PostRequest {

    @Test
    void PostReq() throws FileNotFoundException {

        File file = new File("C:\\Users\\saini\\Documents\\Projects\\Java\\JavaSelenium\\src\\test\\java\\RESTAPITesting\\PostReqUsingJSONFile\\body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject jsonObject = new JSONObject(jsonTokener);

        RestAssured.given().baseUri("https://reqres.in/api/users")
                .header(APIKeyExtraction.key,APIKeyExtraction.getValue())
                .contentType(ContentType.JSON).body(jsonObject.toString())
                .when().post()
                .then().statusCode(201).log().all();
    }
}
