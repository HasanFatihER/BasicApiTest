package basicApiExercises;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest {
    /* Api Test Url : https://restful-booker.herokuapp.com/booking/2
    Check
    -- Status code : 200
    -- Content type : Json
    -- Status Line  : HTTP/1.1  200 OK

////////////////////////////////////////////
All Api Testing Stps
-----------------------------
    1. End Point
    2. Create Expected Result
    3. Send Request
    4. Create Actual Result
    5. Assertion

--------------------------------
    */
    @Test
    public void getRequest() {
        //End Point
        String url = "https://restful-booker.herokuapp.com/booking/3";
        //Create Expected Result
        //Send Request
       Response response=given().
               accept("application/json").
               when().
               get(url);
        //Create Actual Result
        response.prettyPrint();
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Status Content Type : "+response.getContentType());
        System.out.println("Status Line : "+response.getStatusLine());
        System.out.println("response.getHeaders() =\n "+ response.getHeaders());
        //Assertion//
        Assert.assertEquals("Status Code Not Appropriate",200,response.getStatusCode());
        Assert.assertEquals("Contetnt Type Not Appropriate","application/json; charset=utf-8",response.getContentType());
   ////////////////////////////*********************************/////////////////////
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");



    }

}
