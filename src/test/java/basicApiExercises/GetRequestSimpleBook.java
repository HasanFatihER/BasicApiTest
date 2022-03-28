package basicApiExercises;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetRequestSimpleBook {

    @Test
    public void getReqest() {
        String url = "https://simple-books-api.glitch.me/books";
        Response response = given().
                accept(ContentType.JSON).
                when().get(url);
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json");

    }

    @Test
    public void getRequest404() {
        String url = "https://simple-books-api.glitch.me/books/101";
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(404);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        Assert.assertTrue(response.asString().contains("No book with id 101"));
        Assert.assertFalse(response.asString().contains("Api"));
        //asString() method is used to covert toString response data to string

    }

    @Test
    public void getRequestWithMatcherClass() {
        // Data might be changed when you try. Before test you should control the URI
        String url = "https://restful-booker.herokuapp.com/booking/5";
        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Sally")).
                body("lastname", Matchers.equalTo("Ericsson")).
                body("totalprice", Matchers.equalTo(383)).
                body("depositpaid", Matchers.equalTo(false)).
                body("bookingdates.checkin", Matchers.equalTo("2018-06-01")).
                body("bookingdates.checkout", Matchers.equalTo("2020-07-02")).
                body("additionalneeds", Matchers.equalTo("Breakfast"));
    }

    @Test
    public void getRequestWithEqualToClass() {
// Data might be changed when you try. Before test you should control the URI
        /////////////////////////****************///////////////////////////////////////
        // import static org.hamcrest.Matchers.*;  With * and static all  Matchers class are accepted.
        String url = "https://restful-booker.herokuapp.com/booking/5";
        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Brown"),
                        "totalprice", equalTo(789),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2015-10-12"),
                        "bookingdates.checkout", equalTo("2021-03-23"),
                        "additionalneeds", equalTo("Breakfast"));
    }
}
