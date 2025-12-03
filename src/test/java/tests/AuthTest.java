package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;

public class AuthTest extends BaseTest {

    @Test
    public void loginAndGetToken() {

        HashMap<String, String> loginData = new HashMap<>();
        loginData.put("username", "admin");
        loginData.put("password", "password123");

        Response res =
                io.restassured.RestAssured
                        .given()
                        .body(loginData)
                        .when()
                        .post("https://restful-booker.herokuapp.com/auth")
                        .then()
                        .statusCode(200)
                        .body("token", notNullValue())
                        .extract().response();

        String token = res.jsonPath().getString("token");
        System.out.println("Token = " + token);
    }


    @Test
    public void updateBookingWithToken() {

        // Step 1: Login to get token
        HashMap<String, String> loginData = new HashMap<>();
        loginData.put("username", "admin");
        loginData.put("password", "password123");

        String token = io.restassured.RestAssured
                .given()
                .body(loginData)
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(200)
                .extract().path("token");

        // Step 2: Body for update
        HashMap<String, Object> updateBody = new HashMap<>();
        updateBody.put("firstname", "Ramya");
        updateBody.put("lastname", "QA");

        // Step 3: Send PUT request with token
        io.restassured.RestAssured
                .given()
                .cookie("token", token)
                .body(updateBody)
                .when()
                .put("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .statusCode(anyOf(is(200), is(201)));
    }
}
