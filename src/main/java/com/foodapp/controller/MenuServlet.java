package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.MenuDAO;
import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private MenuDAO menuDAO;

    @Override
    public void init() {

        menuDAO = new MenuDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String restaurantID = request.getParameter("restaurantID");

        int id = Integer.parseInt(restaurantID);

        List<Menu> menus =
                menuDAO.getAvailableMenusByRestaurantID(id);

        request.setAttribute("menus", menus);

        request.setAttribute("restaurantID", id);

        request.getRequestDispatcher(
                "/pages/menu.jsp")
               .forward(request, response);
    }
}