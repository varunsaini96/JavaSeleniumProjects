package RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ValidateResponseHeader {
    @Test
    void headerResponse(){
        //RequestSpecification->It is basically a common setup/configuration for an API request.
        RequestSpecification reqSpec = RestAssured.given();

        reqSpec.baseUri("https://reqres.in");
        reqSpec.basePath("/api/users");
        reqSpec.header(APIKeyExtraction.key,APIKeyExtraction.getValue());

        //Create GET request
        Response response = reqSpec.get();

        //get a single header
        String contentType = response.header("Content-Type");
        System.out.println("Value for Key \"content type\": " + contentType);

        //get all the headers
        Headers headersList = response.getHeaders();
        System.out.println("Key"+"      "+"Value");
        for(Header h:headersList){
            System.out.println(h.getName()+"    :   " + h.getValue());
        }

    }
}
