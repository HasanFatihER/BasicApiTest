package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class SimpleBookApiUri {
 protected RequestSpecification spec;
    @Before
    public void setup(){
        spec=new RequestSpecBuilder().
                setBaseUri("https://simple-books-api.glitch.me").
                build();

    }
}
