package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class AuthTest extends BaseTest {

    @Test
    public void loginTest() {

        String jsonBody = """
        {
            "username": "mor_2314",
            "password": "83r5^_"
        }
        """;

        Response response = RestAssured
                .given()
                .spec(reqSpec)
                .body(jsonBody)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)                               // 1) status check
                .header("Content-Type", containsString("json")) // 2) header check
                .time(lessThan(2000L))                          // 3) performance < 2 sec
                .body("token", notNullValue())                  // 4) key exists
                .body("token", instanceOf(String.class))        // 5) type check
                .extract().response();

        String token = response.jsonPath().getString("token");
        System.out.println("Generated Token = " + token);
    }
}
