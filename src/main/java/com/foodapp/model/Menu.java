package com.foodapp.model;

public class Menu {

    private int menuID;
    private int restaurantID;
    private String itemName;
    private String description;
    private String category;
    private double price;
    private String imagePath;
    private boolean isAvailable;

    public Menu() {
    }

    public Menu(int menuID, int restaurantID, String itemName,
                String description, String category, double price,
                String imagePath, boolean isAvailable) {

        this.menuID = menuID;
        this.restaurantID = restaurantID;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
        this.isAvailable = isAvailable;
    }

    public Menu(int restaurantID, String itemName,
                String description, String category, double price,
                String imagePath, boolean isAvailable) {

        this.restaurantID = restaurantID;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
        this.isAvailable = isAvailable;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuID=" + menuID +
                ", restaurantID=" + restaurantID +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}