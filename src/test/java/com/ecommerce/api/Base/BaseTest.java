package com.ecommerce.api.Base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.LogDetail;


public class BaseTest {

    public static RequestSpecification reqSpec;

    static {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://fakestoreapi.com")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .log(LogDetail.ALL)         // FIX: For RestAssured 5.x
                .build();
    }
}
