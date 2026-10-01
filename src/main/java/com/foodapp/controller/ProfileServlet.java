package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.UserDAO;
import com.foodapp.daoimpl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get existing session
        HttpSession session = request.getSession(false);

        // Check whether user is logged in
        if (session == null ||
            session.getAttribute("userID") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login");

            return;
        }

        // Get logged-in user's ID
        Integer userID =
                (Integer) session.getAttribute("userID");

        // Get user details from database
        User user = userDAO.getUserByID(userID);

        // If user does not exist
        if (user == null) {

            session.invalidate();

            response.sendRedirect(
                    request.getContextPath() + "/login");

            return;
        }

        // Send User object to JSP
        request.setAttribute("user", user);

        // Open profile page
        request.getRequestDispatcher(
                "/pages/profile.jsp")
               .forward(request, response);
    }
}