package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.OrderDAO;
import com.foodapp.model.Order;
import com.foodapp.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    private static final String ADD_ORDER =
            "INSERT INTO orders " +
            "(userID, restaurantID, deliveryFee, totalAmount, deliveryAddress, paymentMethod, orderStatus) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_ORDER_STATUS =
            "UPDATE orders SET orderStatus=? WHERE orderID=?";

    private static final String GET_ORDER_BY_ID =
            "SELECT * FROM orders WHERE orderID=?";

    private static final String GET_ALL_ORDERS =
            "SELECT * FROM orders";

    private static final String GET_ORDERS_BY_USER_ID =
            "SELECT * FROM orders WHERE userID=?";

    private static final String GET_ORDERS_BY_RESTAURANT_ID =
            "SELECT * FROM orders WHERE restaurantID=?";

    private Connection connection;

    public OrderDAOImpl() {
        connection = DBConnection.getConnection();
    }
    
    public OrderDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addOrder(Order order) {

        try (PreparedStatement ps =
                     connection.prepareStatement(
                             ADD_ORDER,
                             Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserID());
            ps.setInt(2, order.getRestaurantID());
            ps.setDouble(3, order.getDeliveryFee());
            ps.setDouble(4, order.getTotalAmount());
            ps.setString(5, order.getDeliveryAddress());
            ps.setString(6, order.getPaymentMethod());
            ps.setString(7, order.getOrderStatus());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {

                    return rs.getInt(1);
                }
            }

            return 0;

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Error while adding order", e);
        }
    }
    @Override
    public int updateOrderStatus(int orderID, String orderStatus) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(UPDATE_ORDER_STATUS)) {

            pstmt.setString(1, orderStatus);
            pstmt.setInt(2, orderID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to update order status.", e);
        }
    }

    @Override
    public Order getOrderByID(int orderID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ORDER_BY_ID)) {

            pstmt.setInt(1, orderID);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return extractOrder(rs);
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException("Failed to fetch order.", e);
        }

        return null;
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orderList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ALL_ORDERS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                orderList.add(extractOrder(rs));
            }

        } catch (SQLException e) {

            throw new RuntimeException("Failed to fetch orders.", e);
        }

        return orderList;
    }

    @Override
    public List<Order> getOrdersByUserID(int userID) {

        List<Order> orderList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(
                             GET_ORDERS_BY_USER_ID)) {

            pstmt.setInt(1, userID);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    orderList.add(extractOrder(rs));
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch user orders.", e);
        }

        return orderList;
    }

    @Override
    public List<Order> getOrdersByRestaurantID(int restaurantID) {

        List<Order> orderList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(
                             GET_ORDERS_BY_RESTAURANT_ID)) {

            pstmt.setInt(1, restaurantID);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    orderList.add(extractOrder(rs));
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch restaurant orders.", e);
        }

        return orderList;
    }

    private Order extractOrder(ResultSet rs)
            throws SQLException {

        Order order = new Order();

        order.setOrderID(
                rs.getInt("orderID"));

        order.setUserID(
                rs.getInt("userID"));

        order.setRestaurantID(
                rs.getInt("restaurantID"));

        order.setOrderDate(
                rs.getTimestamp("orderDate"));

        order.setDeliveryFee(
                rs.getDouble("deliveryFee"));

        order.setTotalAmount(
                rs.getDouble("totalAmount"));

        order.setDeliveryAddress(
                rs.getString("deliveryAddress"));

        order.setPaymentMethod(
                rs.getString("paymentMethod"));

        order.setOrderStatus(
                rs.getString("orderStatus"));

        return order;
    }
}