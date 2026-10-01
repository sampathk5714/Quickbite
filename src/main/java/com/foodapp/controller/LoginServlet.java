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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null &&
            session.getAttribute("userID") != null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/account");

            return;
        }

        request.getRequestDispatcher(
                "/pages/login.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        User user =
                userDAO.getUserByEmail(email);

        if (user != null &&
            BCrypt.checkpw(password, user.getPassword())) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "userID",
                    user.getUserID());

            session.setAttribute(
                    "userName",
                    user.getName());

            session.setAttribute(
                    "userEmail",
                    user.getEmail());

            String returnTo =
                    (String) session.getAttribute("returnTo");

            session.removeAttribute("returnTo");

            if (returnTo != null) {

                response.sendRedirect(
                        request.getContextPath()
                        + returnTo);

            } else {

                response.sendRedirect(
                        request.getContextPath()
                        + "/restaurants");
            }

        } else {

            request.setAttribute(
                    "loginError",
                    "Invalid email or password.");

            request.getRequestDispatcher(
                    "/pages/login.jsp")
                   .forward(request, response);
        }
    }
}
