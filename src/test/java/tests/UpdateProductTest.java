package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;

public class UpdateProductTest extends BaseTest {

    @Test
    public void updateProduct() {

        // Step 1: First create a product (POST)
        HashMap<String, Object> body = new HashMap<>();
        body.put("title", "Old Phone");
        body.put("price", 499);

        Response postRes = RestAssured
                .given()
                .spec(reqSpec)
                .body(body)
                .when()
                .post("/products")
                .then()
                .statusCode(201)
                .extract()
                .response();

        int productId = postRes.jsonPath().getInt("id");
        System.out.println("Created product ID = " + productId);


        // Step 2: Prepare updated data (PUT)
        HashMap<String, Object> updateBody = new HashMap<>();
        updateBody.put("title", "Updated Phone");
        updateBody.put("price", 799);

        // Step 3: Send PUT request
        RestAssured
                .given()
                .spec(reqSpec)
                .body(updateBody)
                .when()
                .put("/products/" + productId)
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Phone"))
                .body("price", equalTo(799));
    }
}
