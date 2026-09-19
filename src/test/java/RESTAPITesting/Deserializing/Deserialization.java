package RESTAPITesting.Deserializing;

import RESTAPITesting.APIKeyExtraction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deserialization {

    @Test
    void DeserializationTesting(){

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.baseUri("https://reqres.in");
        reqSpec.basePath("/api/users");
        reqSpec.header(APIKeyExtraction.key,APIKeyExtraction.getValue());

        //creating JSON data
        JSONObject payload = new JSONObject();
        payload.put("name","Tony");
        payload.put("job","Architect");

        //Post the data
        Response response = reqSpec.contentType(ContentType.JSON)
                .body(payload.toJSONString()).post();

        //getting the response body
        ResponseBody responseBody = response.getBody();

        //Deserializing
        JSONPostReqestResponse responseClass = responseBody.as(JSONPostReqestResponse.class);
        System.out.println(responseClass.name);

        Assert.assertEquals(responseClass.name, "Tony","check for name.");
        Assert.assertEquals(responseClass.job, "Architect","check for job.");
    }
}
