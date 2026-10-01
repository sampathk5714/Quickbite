package com.foodapp.model;

public class CartItem {

    private int menuID;
    private String itemName;
    private double price;
    private int quantity;
    private int restaurantID;

    public CartItem() {
    }

    public CartItem(int menuID, String itemName,
                    double price, int quantity,
                    int restaurantID) {

        this.menuID = menuID;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.restaurantID = restaurantID;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "menuID=" + menuID +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", restaurantID=" + restaurantID +
                '}';
    }
}