package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GettingHeaders {

    @Test
    void headers(){
        Response res = RestAssured.given().get("https://www.google.com/");

        Headers headers = res.headers();
        for (Header hd: headers){
            System.out.println(hd.getName()+" -> " + hd.getValue());
        }
    }
}
