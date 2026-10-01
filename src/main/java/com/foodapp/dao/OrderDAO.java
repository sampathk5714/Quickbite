package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Order;

public interface OrderDAO {

    int addOrder(Order order);

    int updateOrderStatus(int orderID, String orderStatus);

    Order getOrderByID(int orderID);

    List<Order> getAllOrders();

    List<Order> getOrdersByUserID(int userID);

    List<Order> getOrdersByRestaurantID(int restaurantID);
}