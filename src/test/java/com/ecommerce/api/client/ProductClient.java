package com.ecommerce.api.client;

import com.ecommerce.api.pojo.Product;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.ecommerce.api.Base.BaseTest;

public class ProductClient extends BaseTest {

    public Response getAllProducts() {
        return given()
                .spec(reqSpec)
                .when()
                .get("/products");
    }

    public Response getProductById(int id) {
        return given()
                .spec(reqSpec)
                .when()
                .get("/products/" + id);
    }

    public Response createProduct(Product product) {
        return given()
                .spec(reqSpec)
                .body(product)
                .when()
                .post("/products");
    }
}
