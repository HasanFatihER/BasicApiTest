import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
/* Check pom.xml.
* */
import static io.restassured.RestAssured.given;

public class Get {
    @Test
    public void getTest(){
       String url="https://restful-booker.herokuapp.com/booking/2";
        Response response=given().when().get(url);
        System.out.println(response);  // Check this.
        response.prettyPrint(); // Give us body
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.time());
        Assert.assertEquals(200,response.statusCode());
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8");
        System.out.println(response.prettyPeek()); //Give us all information

    }
}
