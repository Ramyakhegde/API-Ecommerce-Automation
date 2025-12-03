package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetSingleProductTest extends BaseTest {

    @Test
    public void getProductById() {

        int productId = 1;  // product id to test

        Response res = RestAssured
                .given()
                .spec(reqSpec)
                .pathParam("id", productId)   // passing path parameter
                .when()
                .get("/products/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(productId))
                .body("title", not(emptyString()))
                .body("price", greaterThan(0))
                .extract().response();

        // Print product title
        System.out.println("Product Title: " + res.jsonPath().getString("title"));
    }
}