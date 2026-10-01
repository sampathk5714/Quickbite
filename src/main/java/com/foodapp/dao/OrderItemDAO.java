package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.OrderItem;

public interface OrderItemDAO {

    int addOrderItem(OrderItem orderItem);

    int updateOrderItem(OrderItem orderItem);

    int deleteOrderItem(int orderitemID);

    OrderItem getOrderItemByID(int orderitemID);

    List<OrderItem> getAllOrderItems();

    List<OrderItem> getOrderItemsByOrderID(int orderID);
}  