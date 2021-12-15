package com.example.appsell;

public class Product {
    private int resourceID;
    private String name;
    private String description;
    private boolean isAddToCart;

    public Product(int resourceID, String name, String description) {
        this.resourceID = resourceID;
        this.name = name;
        this.description = description;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAddToCart() {
        return isAddToCart;
    }

    public void setAddToCart(boolean addToCart) {
        isAddToCart = addToCart;
    }
}
