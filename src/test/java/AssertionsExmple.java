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

    @Ignore
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

    @Ignore
    @Test
    public void hamcrestMatchersEqualToQuery() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("query", equalToIgnoringCase("ipod"));

    }

    @Test
    public void hamcrestMatchersHasItem() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("items.name", hasItem("Apple iPod Nano 7th Generation 16GB Pink, Like New in Retail Packaging"));

    }

    @Test
    public void hamcrestMatchersHasItems() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("items.name", hasItems("Apple iPod touch 32GB", "Apple iPod touch 128GB", "Apple iPod Touch 6th Generation 32GB Refurbished", "Apple iPod nano 16GB", "Apple iPod touch 16GB", "Apple iPod shuffle 2GB", "Apple iPod touch 32GB (6th Generation - Latest Model)", "Assorted Colors + Bluetooth Speaker + Clear Case + Screen Protector + Stand + Stylus Pen + Cloth", "iPod Touch 6th Generation Case", "iPod Touch 5th Generation Case","ULAK Waterproof Dustproof Sweatproof Cover Built-in Touch Screen with Kickstand for Apple iPod Touch 5th Gen/6th Gen", "7th Generation 16GB iPod Nano Purple-Excellent Condition!", "Apple iPod Touch 5th Generation 16GB Black/Silver Pre-owned Very Good", "ME643LL/A"));

    }

}
