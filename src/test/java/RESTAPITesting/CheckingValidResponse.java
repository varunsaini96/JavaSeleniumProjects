package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingValidResponse {

    //Non-BDD style

    @Test
    void usingReqSpec(){

        RestAssured.baseURI = "https://reqres.in/api/users/2";

        RequestSpecification reqSpec = RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue());

        Response response = reqSpec.get();

        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode,200,"Status code is mismatched.");

        String statusLine = response.statusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","Status line is mismatched.");
    }

    @Test
    void usingValRes(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification reqSpec = RestAssured.given().header(APIKeyExtraction.key,APIKeyExtraction.getValue());
        Response response = reqSpec.get();
        ValidatableResponse valRes = response.then();
        valRes.statusCode(200);
        valRes.statusLine("HTTP/1.1 200 OK");
    }
}
