package RESTAPITesting.Auth;

import RESTAPITesting.APIKeyExtraction;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIKeyAuth {
    @Test
    void APIKeyAuthenticationTesting(){

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.baseUri("https://api.openweathermap.org");
        reqSpec.basePath("/data/2.5/weather");
        reqSpec.queryParam("q", "delhi").queryParam("appid", APIKeyExtraction.getAPIAuthKey());

        Response response = reqSpec.get();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
