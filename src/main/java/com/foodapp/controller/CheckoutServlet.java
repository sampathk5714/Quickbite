package com.foodapp.controller;

import java.io.IOException;
import java.util.Map;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.dao.UserDAO;
import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.daoimpl.UserDAOImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.Restaurant;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private RestaurantDAO restaurantDAO;
    private UserDAO userDAO;

    @Override
    public void init() {

        restaurantDAO = new RestaurantDAOImpl();
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
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

        /*
         * Get logged-in user's ID from session
         */
        Integer userID =
                (Integer) session.getAttribute("userID");

        if (userID == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login");

            return;
        }

        /*
         * Get user's saved profile information
         */
        User user =
                userDAO.getUserByID(userID);

        if (user == null) {

            session.invalidate();

            response.sendRedirect(
                    request.getContextPath() + "/login");

            return;
        }

        int restaurantID =
                cart.values().iterator().next().getRestaurantID();

        Restaurant restaurant =
                restaurantDAO.getRestaurantByID(restaurantID);

        double itemTotal = 0;

        for (CartItem item : cart.values()) {

            itemTotal += item.getTotalPrice();
        }

        double deliveryFee =
                restaurant.getDeliveryFee();

        double totalAmount =
                itemTotal + deliveryFee;

        request.setAttribute("cart", cart);
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("itemTotal", itemTotal);
        request.setAttribute("deliveryFee", deliveryFee);
        request.setAttribute("totalAmount", totalAmount);

        /*
         * Send user information to checkout.jsp
         */
        request.setAttribute("user", user);

        request.getRequestDispatcher(
                "/pages/checkout.jsp")
               .forward(request, response);
    }
}