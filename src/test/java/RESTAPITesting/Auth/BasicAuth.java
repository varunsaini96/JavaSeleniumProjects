package RESTAPITesting.Auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BasicAuth {

    @Test
    void BasicAuthenticationTesting(){

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.baseUri("http://postman-echo.com");
        reqSpec.basePath("/basic-auth");

        //perform get request (by defult it is non-preemtive)
        Response res = reqSpec.auth().basic("postman","password").get();

        //perform get request using pre-emtive
//        Response res = reqSpec.auth().preemptive().basic("postman","password").get();

        //print status line
        System.out.println(res.statusLine());
        System.out.println(res.getBody().asString());
    }
}
