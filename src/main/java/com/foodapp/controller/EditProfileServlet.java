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

@WebServlet("/profile/edit")
public class EditProfileServlet extends HttpServlet {

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

		// Check login
		if (session == null ||
				session.getAttribute("userID") == null) {

			response.sendRedirect(
					request.getContextPath() + "/login");

			return;
		}

		// Get logged-in user ID
		Integer userID =
				(Integer) session.getAttribute("userID");

		// Get latest user details from database
		User user = userDAO.getUserByID(userID);

		if (user == null) {

			session.invalidate();

			response.sendRedirect(
					request.getContextPath() + "/login");

			return;
		}

		// Send user to JSP
		request.setAttribute("user", user);

		request.getRequestDispatcher(
				"/pages/edit-profile.jsp")
		.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		// Check login
		if (session == null ||
				session.getAttribute("userID") == null) {

			response.sendRedirect(
					request.getContextPath() + "/login");

			return;
		}

		Integer userID =
				(Integer) session.getAttribute("userID");

		// Get form values
		String name =
				request.getParameter("name");

		String email =
				request.getParameter("email");

		String phoneNumber =
				request.getParameter("phoneNumber");

		String address =
				request.getParameter("address");

		// Create User object
		User user = new User();

		user.setUserID(userID);
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);

		// Update database
		int result = userDAO.updateUser(user);

		if (result == -1) {

		    request.setAttribute(
		            "errorMessage",
		            "This phone number is already registered with another account.");

		    request.setAttribute("user", user);

		    request.getRequestDispatcher(
		            "/pages/edit-profile.jsp")
		           .forward(request, response);

		    return;
		}

		// Update session values
		session.setAttribute("userName", name);
		session.setAttribute("userEmail", email);

		// Go back to profile
		response.sendRedirect(
		        request.getContextPath() + "/profile");
	}

}
