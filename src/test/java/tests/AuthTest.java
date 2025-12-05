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
                .statusCode(201)                               // ✔ Correct status
                .header("Content-Type", containsString("json"))
                .time(lessThan(2000L))
                .body("token", notNullValue())
                .body("token", instanceOf(String.class))
                .extract().response();

        String token = response.jsonPath().getString("token");
        System.out.println("Generated Token = " + token);
    }
}