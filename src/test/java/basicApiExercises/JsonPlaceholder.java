package basicApiExercises;

import baseURLs.basicApiExercisesUrls;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonPlaceholder extends basicApiExercisesUrls {
    @Test
    public void getRequest() {
        // String url="https://jsonplaceholder.typicode.com/todos/123"

        spec.pathParams("param1","todos","param2",123);

        Response response=given().
                accept("application/json").
                spec(spec).
                when().
                get("/{param1}/{param2}");
        response.prettyPrint();
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                header("Server", equalTo("cloudflare")).
                body("userId",equalTo(7),
                        "title",equalTo("esse et quis iste est earum aut impedit"),
                        "completed",equalTo( false));







    }


}
