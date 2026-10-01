package com.foodapp.model;

import java.sql.Timestamp;

public class Order {

    private int orderID;
    private int userID;
    private int restaurantID;
    private Timestamp orderDate;
    private double deliveryFee;
    private double totalAmount;
    private String deliveryAddress;
    private String paymentMethod;
    private String orderStatus;

    public Order() {
    }

    public Order(int orderID, int userID, int restaurantID,
                 Timestamp orderDate, double deliveryFee,
                 double totalAmount, String deliveryAddress,
                 String paymentMethod, String orderStatus) {

        this.orderID = orderID;
        this.userID = userID;
        this.restaurantID = restaurantID;
        this.orderDate = orderDate;
        this.deliveryFee = deliveryFee;
        this.totalAmount = totalAmount;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
    }

    public Order(int userID, int restaurantID,
                 double deliveryFee, double totalAmount,
                 String deliveryAddress, String paymentMethod,
                 String orderStatus) {

        this.userID = userID;
        this.restaurantID = restaurantID;
        this.deliveryFee = deliveryFee;
        this.totalAmount = totalAmount;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", restaurantID=" + restaurantID +
                ", orderDate=" + orderDate +
                ", deliveryFee=" + deliveryFee +
                ", totalAmount=" + totalAmount +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}