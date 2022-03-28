package basicApiExercises;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequestHasItem {

    @Test
    public void getRequestHasItem(){
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("data.id",hasItem(21),
                        "data.employee_age",hasItems(23,61,63));


    }
}
