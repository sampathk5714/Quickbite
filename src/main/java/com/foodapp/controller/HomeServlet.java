package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.MenuDAO;
import com.foodapp.dao.RestaurantDAO;
import com.foodapp.dao.UserDAO;
import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.daoimpl.UserDAOImpl;
import com.foodapp.model.Menu;
import com.foodapp.model.Restaurant;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private RestaurantDAO restaurantDAO;
    private UserDAO userDAO;
    private MenuDAO menuDAO;

    @Override
    public void init() {

        restaurantDAO = new RestaurantDAOImpl();
        userDAO = new UserDAOImpl();
        menuDAO = new MenuDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        List<Restaurant> restaurants =
                restaurantDAO.getActiveRestaurants();

        request.setAttribute(
                "restaurants",
                restaurants);

        List<Menu> menus =
                menuDAO.getAllMenus();

        request.setAttribute(
                "menus",
                menus);

        HttpSession session =
                request.getSession(false);

        if (session != null &&
            session.getAttribute("userID") != null) {

            int userID =
                    (Integer) session.getAttribute("userID");

            User user =
                    userDAO.getUserByID(userID);

            request.setAttribute(
                    "user",
                    user);
        }

        request.getRequestDispatcher(
                "/pages/home.jsp")
               .forward(request, response);
    }
}