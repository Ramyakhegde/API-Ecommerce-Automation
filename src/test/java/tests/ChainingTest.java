package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;

public class ChainingTest extends BaseTest {

    @Test
    public void postThenGetProduct() {

        // Step 1: POST create product
        HashMap<String, Object> data = new HashMap<>();
        data.put("title", "Chained Phone");
        data.put("price", 599);

        Response postRes = RestAssured
                .given()
                .spec(reqSpec)
                .body(data)
                .when()
                .post("/products")
                .then()
                .statusCode(201)
                .extract().response();

        int productId = postRes.jsonPath().getInt("id");
        System.out.println("Created product ID = " + productId);

        // Step 2: GET product by ID (FakeStoreAPI will not store it)
        RestAssured
                .given()
                .spec(reqSpec)
                .when()
                .get("/products/" + productId)
                .then()
                .statusCode(anyOf(is(200), is(404)));   // Accept both
    }
}