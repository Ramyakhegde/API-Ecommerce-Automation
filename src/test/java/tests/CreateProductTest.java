package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;

import static org.hamcrest.Matchers.*;

public class CreateProductTest extends BaseTest {

    @Test
    public void createNewProduct() {

        // ----- 1. Create JSON Body using HashMap -----
        HashMap<String, Object> data = new HashMap<>();
        data.put("title", "New Phone");
        data.put("price", 499);
        data.put("description", "Latest smartphone");
        data.put("categoryId", 1);
        data.put("images", new String[]{"https://example.com/img1.png"});

        // ----- 2. Send POST request -----
        Response res = RestAssured
                .given()
                .spec(reqSpec)
                .body(data) // automatically converts HashMap → JSON
                .when()
                .post("/products")
                .then()
                .statusCode(200)  // fakestoreapi returns 200 for creation
                .body("title", equalTo("New Phone"))
                .body("price", equalTo(499))
                .body("id", notNullValue())       // verify id is generated
                .extract().response();

        // ----- 3. Extract generated id -----
        int newId = res.jsonPath().getInt("id");
        System.out.println("Created product ID = " + newId);
    }
}

