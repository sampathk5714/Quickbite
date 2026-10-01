package com.foodapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.foodapp.dao.OrderDAO;
import com.foodapp.dao.OrderItemDAO;
import com.foodapp.dao.RestaurantDAO;
import com.foodapp.daoimpl.OrderDAOImpl;
import com.foodapp.daoimpl.OrderItemDAOImpl;
import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.Order;
import com.foodapp.model.OrderItem;
import com.foodapp.model.Restaurant;
import com.foodapp.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeOrder")
public class OrderServlet extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private RestaurantDAO restaurantDAO;

    @Override
    public void init() {

        restaurantDAO = new RestaurantDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {

            response.sendRedirect(
                    request.getContextPath() + "/cart");

            return;
        }

        Integer userID =
                (Integer) session.getAttribute("userID");

        if (userID == null) {

            session.setAttribute(
                    "returnTo",
                    "/checkout"
            );

            response.sendRedirect(
                    request.getContextPath() + "/login");

            return;
        }

        String deliveryAddress =
                request.getParameter("deliveryAddress");

        String paymentMethod =
                request.getParameter("paymentMethod");

        CartItem firstItem =
                cart.values().iterator().next();

        int restaurantID =
                firstItem.getRestaurantID();

        Restaurant restaurant =
                restaurantDAO.getRestaurantByID(restaurantID);

        if (restaurant == null) {

            throw new ServletException(
                    "Restaurant not found.");
        }

        double deliveryFee =
                restaurant.getDeliveryFee();

        double itemTotal = 0;

        for (CartItem item : cart.values()) {

            itemTotal += item.getTotalPrice();
        }

        double totalAmount =
                itemTotal + deliveryFee;

        Connection connection =
                DBConnection.getConnection();

        try {

            connection.setAutoCommit(false);

            orderDAO =
                    new OrderDAOImpl(connection);

            orderItemDAO =
                    new OrderItemDAOImpl(connection);

            Order order = new Order(
                    userID,
                    restaurantID,
                    deliveryFee,
                    totalAmount,
                    deliveryAddress,
                    paymentMethod,
                    "PLACED"
            );

            int orderID =
                    orderDAO.addOrder(order);

            if (orderID == 0) {

                throw new SQLException(
                        "Order could not be created.");
            }

            for (CartItem item : cart.values()) {

                OrderItem orderItem = new OrderItem(
                        orderID,
                        item.getMenuID(),
                        item.getQuantity(),
                        item.getPrice()
                );

                int result =
                        orderItemDAO.addOrderItem(orderItem);

                if (result == 0) {

                    throw new SQLException(
                            "Order item could not be created.");
                }
            }

            connection.commit();

            session.removeAttribute("cart");

            session.setAttribute(
                    "lastOrderID",
                    orderID);

            response.sendRedirect(
                    request.getContextPath()
                    + "/orderHistory");

        } catch (Exception e) {

            try {

                connection.rollback();

            } catch (SQLException rollbackException) {

                rollbackException.printStackTrace();
            }

            throw new ServletException(
                    "Order placement failed.",
                    e
            );

        } finally {

            try {

                connection.setAutoCommit(true);

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}