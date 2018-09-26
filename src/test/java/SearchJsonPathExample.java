import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static final String APIKEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
    }

    @Test
    public void test01() {
        int numItems =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("numItems");

        System.out.println(numItems);
    }

    @Test
    public void test02() {
        String query =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("query");

        System.out.println(query);
    }

    @Test
    public void test03() {
        String productName =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items[0].name");

        System.out.println(productName);
    }

    @Test
    public void test04() {
        HashMap<String,String> giftOptions =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items[0].giftOptions");

        System.out.println(giftOptions);
    }

    @Test
    public void test05() {
        int size =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.size()");

        System.out.println(size);
    }

    @Test
    public void test06() {
        List<String> name =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.name");

        System.out.println(name);
    }

    @Test
    public void findAllNamesWhereNameAsApple() {
        List<HashMap<String,Object>> nameIPODlist =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.findAll{it.name=='Apple iPod touch'}");

        System.out.println(nameIPODlist);
    }
}
