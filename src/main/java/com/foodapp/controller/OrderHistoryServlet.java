package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foodapp.dao.MenuDAO;
import com.foodapp.dao.OrderDAO;
import com.foodapp.dao.OrderItemDAO;
import com.foodapp.dao.RestaurantDAO;

import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.daoimpl.OrderDAOImpl;
import com.foodapp.daoimpl.OrderItemDAOImpl;
import com.foodapp.daoimpl.RestaurantDAOImpl;

import com.foodapp.model.Menu;
import com.foodapp.model.Order;
import com.foodapp.model.OrderHistoryItem;
import com.foodapp.model.OrderItem;
import com.foodapp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {

    private OrderDAO orderDAO;
    private RestaurantDAO restaurantDAO;
    private OrderItemDAO orderItemDAO;
    private MenuDAO menuDAO;

    @Override
    public void init() {

        orderDAO = new OrderDAOImpl();
        restaurantDAO = new RestaurantDAOImpl();
        orderItemDAO = new OrderItemDAOImpl();
        menuDAO = new MenuDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer userID =
                (Integer) session.getAttribute("userID");

        if (userID == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login");

            return;
        }

        List<Order> orders =
                orderDAO.getOrdersByUserID(userID);


        Map<Integer, Restaurant> restaurantMap =
                new HashMap<>();

        Map<Integer, List<OrderHistoryItem>> orderItemsMap =
                new HashMap<>();


        for (Order order : orders) {

            int restaurantID =
                    order.getRestaurantID();


            Restaurant restaurant =
                    restaurantMap.get(restaurantID);


            if (restaurant == null) {

                restaurant =
                        restaurantDAO.getRestaurantByID(
                                restaurantID);

                restaurantMap.put(
                        restaurantID,
                        restaurant);
            }


            List<OrderItem> orderItems =
                    orderItemDAO.getOrderItemsByOrderID(
                            order.getOrderID());


            List<OrderHistoryItem> historyItems =
                    new ArrayList<>();


            for (OrderItem orderItem : orderItems) {

                Menu menu =
                        menuDAO.getMenuByID(
                                orderItem.getMenuID());


                if (menu != null) {

                    OrderHistoryItem historyItem =
                            new OrderHistoryItem(
                                    order.getOrderID(),
                                    restaurant.getRestaurantName(),
                                    restaurant.getCuisineType(),
                                    menu.getItemName(),
                                    orderItem.getQuantity(),
                                    orderItem.getPrice()
                            );


                    historyItems.add(historyItem);
                }
            }


            orderItemsMap.put(
                    order.getOrderID(),
                    historyItems);
        }


        request.setAttribute(
                "orders",
                orders);

        request.setAttribute(
                "restaurantMap",
                restaurantMap);

        request.setAttribute(
                "orderItemsMap",
                orderItemsMap);


        request.getRequestDispatcher(
                "/pages/order-history.jsp")
               .forward(request, response);
    }
}
