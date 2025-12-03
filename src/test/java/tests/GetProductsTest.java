package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.ecommerce.api.Base.BaseTest.reqSpec;
import static org.hamcrest.Matchers.*;

public class GetProductsTest extends BaseTest {

    @Test
    public void getAllProducts() {
        Response res = RestAssured
                .given()
                .spec(reqSpec)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products", not(empty()))
                .extract().response();

        System.out.println("Total products: " + res.jsonPath().getList("products").size());
    }
}

