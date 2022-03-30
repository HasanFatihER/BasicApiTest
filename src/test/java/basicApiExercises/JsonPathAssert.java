package basicApiExercises;

import baseURLs.SimpleBookApiUri;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;


public class JsonPathAssert extends SimpleBookApiUri {
    //url ="https://simple-books-api.glitch.me/books/1"
    @Test
    public void jsonPathAssert() {
        spec.pathParams("param1","books","param2",1);

        Response response = given().
                accept("application/json").
                spec(spec).
                when().get("/{param1}/{param2}/");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        // We can use jsonPath only body area.
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals("The Russian",jsonPath.getString("name"));
        Assert.assertEquals("James Patterson and James O. Born",jsonPath.getString("author"));





    }

}
