package com.foodapp.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.foodapp.dao.MenuDAO;
import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private MenuDAO menuDAO;

    @Override
    public void init() {

        menuDAO = new MenuDAOImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null) {

            cart = new LinkedHashMap<>();

            session.setAttribute("cart", cart);
        }

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("/pages/cart.jsp")
               .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");


        if ("add".equals(action)) {

            addToCart(request, response);

            return;
        }


        if ("confirmChange".equals(action)) {

            confirmRestaurantChange(request);

            response.sendRedirect(
                    request.getContextPath() + "/cart");

            return;
        }


        if ("update".equals(action)) {

            updateCart(request);

        }


        else if ("remove".equals(action)) {

            removeFromCart(request);

        }


        response.sendRedirect(
                request.getContextPath() + "/cart");
    }


    private void addToCart(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {

        int menuID =
                Integer.parseInt(
                        request.getParameter("menuID"));


        int quantity =
                Integer.parseInt(
                        request.getParameter("quantity"));


        Menu menu =
                menuDAO.getMenuByID(menuID);


        if (menu == null) {

            response.sendRedirect(
                    request.getContextPath() + "/restaurants");

            return;
        }


        HttpSession session =
                request.getSession();


        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>)
                        session.getAttribute("cart");


        if (cart == null) {

            cart = new LinkedHashMap<>();

            session.setAttribute("cart", cart);
        }


        /*
         * Check whether the cart already contains
         * items from another restaurant.
         */

        if (!cart.isEmpty()) {

            CartItem firstItem =
                    cart.values().iterator().next();


            int existingRestaurantID =
                    firstItem.getRestaurantID();


            int newRestaurantID =
                    menu.getRestaurantID();


            if (existingRestaurantID != newRestaurantID) {

                session.setAttribute(
                        "pendingMenuID",
                        menuID);


                session.setAttribute(
                        "pendingQuantity",
                        quantity);


                session.setAttribute(
                        "existingRestaurantID",
                        existingRestaurantID);


                session.setAttribute(
                        "newRestaurantID",
                        newRestaurantID);


                response.sendRedirect(
                        request.getContextPath()
                        + "/pages/cart-conflict.jsp");

                return;
            }
        }


        /*
         * Same restaurant or empty cart.
         * Add the item normally.
         */

        CartItem existingItem =
                cart.get(menuID);


        if (existingItem != null) {

            existingItem.setQuantity(
                    existingItem.getQuantity()
                    + quantity);

        }

        else {

            CartItem cartItem =
                    new CartItem(
                            menu.getMenuID(),
                            menu.getItemName(),
                            menu.getPrice(),
                            quantity,
                            menu.getRestaurantID()
                    );


            cart.put(menuID, cartItem);
        }


        response.sendRedirect(
                request.getContextPath()
                + "/cart");
    }


    private void confirmRestaurantChange(
            HttpServletRequest request) {

        HttpSession session =
                request.getSession();


        Integer pendingMenuID =
                (Integer) session.getAttribute(
                        "pendingMenuID");


        Integer pendingQuantity =
                (Integer) session.getAttribute(
                        "pendingQuantity");


        if (pendingMenuID == null ||
            pendingQuantity == null) {

            return;
        }


        Menu menu =
                menuDAO.getMenuByID(
                        pendingMenuID);


        if (menu == null) {

            return;
        }


        /*
         * Clear the old restaurant cart.
         */

        Map<Integer, CartItem> cart =
                new LinkedHashMap<>();


        /*
         * Add the new restaurant item.
         */

        CartItem cartItem =
                new CartItem(
                        menu.getMenuID(),
                        menu.getItemName(),
                        menu.getPrice(),
                        pendingQuantity,
                        menu.getRestaurantID()
                );


        cart.put(
                menu.getMenuID(),
                cartItem);


        session.setAttribute(
                "cart",
                cart);


        /*
         * Remove temporary conflict data.
         */

        session.removeAttribute("pendingMenuID");

        session.removeAttribute("pendingQuantity");

        session.removeAttribute("existingRestaurantID");

        session.removeAttribute("newRestaurantID");
    }


    private void updateCart(HttpServletRequest request) {

        int menuID =
                Integer.parseInt(
                        request.getParameter("menuID"));


        int quantity =
                Integer.parseInt(
                        request.getParameter("quantity"));


        HttpSession session =
                request.getSession();


        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>)
                        session.getAttribute("cart");


        if (cart != null &&
            cart.containsKey(menuID)) {

            if (quantity > 0) {

                cart.get(menuID)
                    .setQuantity(quantity);

            }

            else {

                cart.remove(menuID);
            }
        }
    }


    private void removeFromCart(
            HttpServletRequest request) {

        int menuID =
                Integer.parseInt(
                        request.getParameter("menuID"));


        HttpSession session =
                request.getSession();


        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>)
                        session.getAttribute("cart");


        if (cart != null) {

            cart.remove(menuID);
        }
    }
}