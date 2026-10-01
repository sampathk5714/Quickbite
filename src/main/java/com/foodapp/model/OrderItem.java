package com.foodapp.model;

public class OrderItem {

    private int orderitemID;
    private int orderID;
    private int menuID;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(int orderitemID, int orderID,
                     int menuID, int quantity, double price) {

        this.orderitemID = orderitemID;
        this.orderID = orderID;
        this.menuID = menuID;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(int orderID, int menuID,
                     int quantity, double price) {

        this.orderID = orderID;
        this.menuID = menuID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderitemID() {
        return orderitemID;
    }

    public void setOrderitemID(int orderitemID) {
        this.orderitemID = orderitemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderitemID=" + orderitemID +
                ", orderID=" + orderID +
                ", menuID=" + menuID +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}