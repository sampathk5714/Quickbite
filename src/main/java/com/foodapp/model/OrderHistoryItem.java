package com.foodapp.model;

public class OrderHistoryItem {

    private int orderID;
    private String restaurantName;
    private String cuisineType;
    private String itemName;
    private int quantity;
    private double price;

    public OrderHistoryItem() {
    }

    public OrderHistoryItem(int orderID,
                            String restaurantName,
                            String cuisineType,
                            String itemName,
                            int quantity,
                            double price) {

        this.orderID = orderID;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getItemTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "OrderHistoryItem{" +
                "orderID=" + orderID +
                ", restaurantName='" + restaurantName + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
