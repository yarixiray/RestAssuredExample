import io.restassured.RestAssured;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AssertionsExmple {

    static final String APIKEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
    }

    @Test
    public void hamcrestMatchersEqualTo() {
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .body("numItems", equalTo(10));

    }

}
