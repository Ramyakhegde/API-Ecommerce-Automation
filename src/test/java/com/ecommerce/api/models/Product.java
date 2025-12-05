package com.ecommerce.api.models;

public class Product {

    private String title;
    private double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
