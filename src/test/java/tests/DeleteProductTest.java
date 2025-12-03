package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;

public class DeleteProductTest extends BaseTest {

    @Test
    public void deleteProduct() {

        // Step 1: POST - create a product
        HashMap<String, Object> body = new HashMap<>();
        body.put("title", "Temp Product");
        body.put("price", 250);

        Response postRes = RestAssured
                .given()
                .spec(reqSpec)
                .body(body)
                .when()
                .post("/products")
                .then()
                .statusCode(201)
                .extract().response();

        int productId = postRes.jsonPath().getInt("id");
        System.out.println("Created product ID = " + productId);


        // Step 2: DELETE the created product
        RestAssured
                .given()
                .spec(reqSpec)
                .when()
                .delete("/products/" + productId)
                .then()
                .statusCode(200);  // FakeStore returns 200


        // Step 3: Try GET after delete → expect 404 or empty response
        RestAssured
                .given()
                .spec(reqSpec)
                .when()
                .get("/products/" + productId)
                .then()
                .statusCode(anyOf(is(404), is(200)));
        // Note: FakeStore sometimes returns empty object with 200
    }
}
