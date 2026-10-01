package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.OrderItemDAO;
import com.foodapp.model.OrderItem;
import com.foodapp.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String ADD_ORDER_ITEM =
            "INSERT INTO orderitems " +
            "(orderID, menuID, quantity, price) " +
            "VALUES (?, ?, ?, ?)";

    private static final String UPDATE_ORDER_ITEM =
            "UPDATE orderitems SET orderID=?, menuID=?, " +
            "quantity=?, price=? WHERE orderitemID=?";

    private static final String DELETE_ORDER_ITEM =
            "DELETE FROM orderitems WHERE orderitemID=?";

    private static final String GET_ORDER_ITEM_BY_ID =
            "SELECT * FROM orderitems WHERE orderitemID=?";

    private static final String GET_ALL_ORDER_ITEMS =
            "SELECT * FROM orderitems";

    private static final String GET_ORDER_ITEMS_BY_ORDER_ID =
            "SELECT * FROM orderitems WHERE orderID=?";

    private Connection connection;

    public OrderItemDAOImpl() {
        connection = DBConnection.getConnection();
    }
    
    public OrderItemDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addOrderItem(OrderItem orderItem) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(ADD_ORDER_ITEM)) {

            pstmt.setInt(1, orderItem.getOrderID());
            pstmt.setInt(2, orderItem.getMenuID());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getPrice());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to add order item.", e);
        }
    }

    @Override
    public int updateOrderItem(OrderItem orderItem) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(UPDATE_ORDER_ITEM)) {

            pstmt.setInt(1, orderItem.getOrderID());
            pstmt.setInt(2, orderItem.getMenuID());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getPrice());
            pstmt.setInt(5, orderItem.getOrderitemID());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to update order item.", e);
        }
    }

    @Override
    public int deleteOrderItem(int orderitemID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(DELETE_ORDER_ITEM)) {

            pstmt.setInt(1, orderitemID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to delete order item.", e);
        }
    }

    @Override
    public OrderItem getOrderItemByID(int orderitemID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ORDER_ITEM_BY_ID)) {

            pstmt.setInt(1, orderitemID);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return extractOrderItem(rs);
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch order item.", e);
        }

        return null;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> orderItemList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ALL_ORDER_ITEMS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                orderItemList.add(extractOrderItem(rs));
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch order items.", e);
        }

        return orderItemList;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderID(int orderID) {

        List<OrderItem> orderItemList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(
                             GET_ORDER_ITEMS_BY_ORDER_ID)) {

            pstmt.setInt(1, orderID);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    orderItemList.add(extractOrderItem(rs));
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch order items by order ID.", e);
        }

        return orderItemList;
    }

    private OrderItem extractOrderItem(ResultSet rs)
            throws SQLException {

        OrderItem orderItem = new OrderItem();

        orderItem.setOrderitemID(
                rs.getInt("orderitemID"));

        orderItem.setOrderID(
                rs.getInt("orderID"));

        orderItem.setMenuID(
                rs.getInt("menuID"));

        orderItem.setQuantity(
                rs.getInt("quantity"));

        orderItem.setPrice(
                rs.getDouble("price"));

        return orderItem;
    }
}