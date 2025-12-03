package com.ecommerce.api.pojo;

public class Product {
    private int id;
    private String title;
    private double price;

    public Product() {}

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
}
