import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

    @Ignore
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

    @Ignore
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

    @Ignore
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

    @Ignore
    @Test
    public void test04() {
        HashMap<String, String> giftOptions =
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

    @Ignore
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

    @Ignore
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

    @Ignore
    @Test
    public void findAllNamesWhereNameAsApple() {
        List<HashMap<String, Object>> nameIPODlist =
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

    @Ignore
    @Test
    public void findAllNamesWithSalePrice() {
        List<Float> nameIPODlistSalePrice =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");

        System.out.println(nameIPODlistSalePrice);

    }

    @Ignore
    @Test
    public void findAllSalePricGreaterThan150() {
        List<String> SalePriceGreaterThan150 =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.findAll{it.salePrice>150}.name");

        System.out.println(SalePriceGreaterThan150);

    }

    @Ignore
    @Test
    public void findAllMsrpValueForNameStartWithApp() {
        List<String> findAllMsrpValueForNameStartWith =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.findAll{it.name==~/App.*/}.msrp");

        System.out.println(findAllMsrpValueForNameStartWith);

    }

    @Test
    public void findAllMsrpValueForNameEndWithGB() {
        List<String> findAllMsrpValueForNameEndWithEd =
                given()
                        .queryParam("query", "ipod")
                        .queryParam("apiKey", APIKEY)
                        .queryParam("format", "json")
                        .when()
                        .get("/search")
                        .then()
                        .extract()
                        .path("items.findAll{it.name==~/.*GB/}.msrp");

        System.out.println(findAllMsrpValueForNameEndWithEd);

    }
}
