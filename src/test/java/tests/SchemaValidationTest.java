package tests;

import com.ecommerce.api.Base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest extends BaseTest {

    @Test
    public void validateProductSchema() {

        RestAssured
                .given()
                .spec(reqSpec)
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/product-schema.json"));
    }
}
