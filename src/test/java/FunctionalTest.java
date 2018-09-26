import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FunctionalTest {

    @org.junit.Test
    public void verifyTopLevelURLlink() {

        Response res = RestAssured.get("http://localhost:30200/patients");
        int code = res.statusCode();

        System.out.println(res.asString());

    }
}
