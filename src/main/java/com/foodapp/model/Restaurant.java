package com.foodapp.model;

public class Restaurant {

    private int restaurantID;
    private String restaurantName;
    private String cuisineType;
    private String address;
    private double rating;
    private int deliveryTime;
    private String imagePath;
    private boolean isActive;
    private String offer;
    private double deliveryFee;

    public Restaurant() {
    }

    public Restaurant(int restaurantID, String restaurantName, String cuisineType,
                      String address, double rating, int deliveryTime,
                      String imagePath, boolean isActive, String offer,
                      double deliveryFee) {

        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.address = address;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.imagePath = imagePath;
        this.isActive = isActive;
        this.offer = offer;
        this.deliveryFee = deliveryFee;
    }

    public Restaurant(String restaurantName, String cuisineType,
                      String address, double rating, int deliveryTime,
                      String imagePath, boolean isActive, String offer,
                      double deliveryFee) {

        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.address = address;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.imagePath = imagePath;
        this.isActive = isActive;
        this.offer = offer;
        this.deliveryFee = deliveryFee;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantID +
                ", restaurantName='" + restaurantName + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", deliveryTime=" + deliveryTime +
                ", imagePath='" + imagePath + '\'' +
                ", isActive=" + isActive +
                ", offer='" + offer + '\'' +
                ", deliveryFee=" + deliveryFee +
                '}';
    }
}