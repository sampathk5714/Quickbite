package com.foodapp.controller;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.foodapp.dao.UserDAO;
import com.foodapp.daoimpl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {

        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/pages/register.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String phoneNumber =
                request.getParameter("phoneNumber");

        String password =
                request.getParameter("password");

        String address =
                request.getParameter("address");

        // Check whether email already exists
        User existingUser =
                userDAO.getUserByEmail(email);

        if (existingUser != null) {

            request.setAttribute(
                    "registerError",
                    "Email already registered.");

            request.getRequestDispatcher(
                    "/pages/register.jsp")
                   .forward(request, response);

            return;
        }

        // Hash password using BCrypt
        String hashedPassword =
                BCrypt.hashpw(
                        password,
                        BCrypt.gensalt()
                );

        // Create User object
        User user =
                new User(
                        name,
                        email,
                        phoneNumber,
                        hashedPassword,
                        address
                );

        // Insert user into database
        int result =
                userDAO.addUser(user);

        if (result > 0) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");

        } else {

            request.setAttribute(
                    "registerError",
                    "Registration failed. Please try again.");

            request.getRequestDispatcher(
                    "/pages/register.jsp")
                   .forward(request, response);
        }
    }
}