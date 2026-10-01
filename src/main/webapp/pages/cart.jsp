<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.Map" %>
<%@ page import="com.foodapp.model.CartItem" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | Cart</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/cart.css">

</head>

<body>


<header class="site-header">

    <nav class="navbar container">

        <a class="brand"
           href="${pageContext.request.contextPath}/home">

            <span class="brand-mark">
                Q
            </span>

            <span>
                Quick<span>Bite</span>
            </span>

        </a>


        <div class="nav-links">

            <a href="${pageContext.request.contextPath}/home">
                Home
            </a>

            <a href="${pageContext.request.contextPath}/restaurants">
                Restaurants
            </a>

            <a href="${pageContext.request.contextPath}/restaurants#offers">
                Offers
            </a>

        </div>


        <div class="nav-actions">

            <label class="search-box">

                <span>⌕</span>

                <input type="search"
                       placeholder="Search restaurants or dishes">

            </label>


            <button class="location"
                    type="button">

                <span>⌖</span>

                Bengaluru

                <span>⌄</span>

            </button>


            <!-- Profile / Login -->

            <%
                Integer loggedInUserID =
                        (Integer) session.getAttribute("userID");

                if (loggedInUserID != null) {
            %>

                <a class="icon-button"
                   href="${pageContext.request.contextPath}/profile"
                   aria-label="Profile">

                    👤

                </a>

            <%
                } else {
            %>

                <a class="login-link"
                   href="${pageContext.request.contextPath}/login">

                    Login

                </a>

            <%
                }
            %>


            <!-- Cart -->

            <a class="cart-button active"
               href="${pageContext.request.contextPath}/cart">

                🛒

                <span>
                    ${empty sessionScope.cart ? 0 : sessionScope.cart.size()}
                </span>

            </a>

        </div>

    </nav>

</header>


<main>

    <section class="cart-section container">


        <div class="page-heading">

            <div>

                <p class="eyebrow">

                    YOUR ORDER

                </p>


                <h1>

                    Your cart

                </h1>


                <p class="subtitle">

                    Review your items before checkout.

                </p>

            </div>


            <a class="back-link"
               href="${pageContext.request.contextPath}/restaurants">

                ← Continue shopping

            </a>

        </div>


        <%
            Map<Integer, CartItem> cart =
                    (Map<Integer, CartItem>) session.getAttribute("cart");

            if (cart != null && !cart.isEmpty()) {

                double itemTotal = 0;

                for (CartItem item : cart.values()) {

                    itemTotal += item.getTotalPrice();

                }
        %>


            <div class="cart-layout">


                <div class="cart-items">


                    <div class="cart-card">


                        <div class="cart-card-header">

                            <h2>

                                Your items

                            </h2>

                            <span>

                                <%= cart.size() %> item(s)

                            </span>

                        </div>


                        <%
                            for (CartItem item : cart.values()) {
                        %>


                            <div class="cart-item">


                                <div class="item-image">

                                    🍽️

                                </div>


                                <div class="item-details">

                                    <h3>

                                        <%= item.getItemName() %>

                                    </h3>


                                    <p>

                                        ₹<%= item.getPrice() %> per item

                                    </p>

                                </div>


                                <div class="item-price">

                                    ₹<%= item.getTotalPrice() %>

                                </div>


                                <form class="quantity-form"
                                      action="${pageContext.request.contextPath}/cart"
                                      method="post">


                                    <input type="hidden"
                                           name="action"
                                           value="update">


                                    <input type="hidden"
                                           name="menuID"
                                           value="<%= item.getMenuID() %>">


                                    <input type="number"
                                           name="quantity"
                                           value="<%= item.getQuantity() %>"
                                           min="1">


                                    <button type="submit">

                                        Update

                                    </button>

                                </form>


                                <form class="remove-form"
                                      action="${pageContext.request.contextPath}/cart"
                                      method="post">


                                    <input type="hidden"
                                           name="action"
                                           value="remove">


                                    <input type="hidden"
                                           name="menuID"
                                           value="<%= item.getMenuID() %>">


                                    <button type="submit"
                                            class="remove-button">

                                        Remove

                                    </button>

                                </form>


                            </div>


                        <%
                            }
                        %>


                    </div>


                    <a class="continue-button"
                       href="${pageContext.request.contextPath}/restaurants">

                        ← Add more items

                    </a>


                </div>


                <div class="summary-card">


                    <h2>

                        Order summary

                    </h2>


                    <div class="summary-row">

                        <span>

                            Items

                        </span>

                        <span>

                            <%= cart.size() %>

                        </span>

                    </div>


                    <div class="summary-row">

                        <span>

                            Item total

                        </span>

                        <span>

                            ₹<%= itemTotal %>

                        </span>

                    </div>


                    <div class="summary-row">

                        <span>

                            Delivery fee

                        </span>

                        <span>

                            Calculated at checkout

                        </span>

                    </div>


                    <div class="summary-divider">

                    </div>


                    <div class="summary-total">

                        <span>

                            Total

                        </span>


                        <strong>

                            ₹<%= itemTotal %>

                        </strong>

                    </div>


                    <a class="checkout-button"
                       href="${pageContext.request.contextPath}/checkout">

                        Proceed to Checkout

                        <span>

                            →

                        </span>

                    </a>


                    <p class="secure-text">

                        🔒 Safe and secure checkout

                    </p>


                </div>

            </div>


        <%
            } else {
        %>


            <div class="empty-cart">


                <div class="empty-cart-icon">

                    🛒

                </div>


                <h2>

                    Your cart is empty

                </h2>


                <p>

                    Looks like you haven't added anything yet.

                </p>


                <a href="${pageContext.request.contextPath}/restaurants">

                    Browse Restaurants

                </a>


            </div>


        <%
            }
        %>


    </section>

</main>


<footer class="site-footer">


    <div class="container footer-grid">


        <div>

            <a class="brand footer-brand"
               href="${pageContext.request.contextPath}/home">

                <span class="brand-mark">

                    Q

                </span>


                <span>

                    Quick<span>Bite</span>

                </span>

            </a>


            <p>

                Good food, delivered quickly.

            </p>

        </div>


        <div>

            <h4>

                QuickBite

            </h4>


            <a href="#about">

                About us

            </a>


            <a href="#careers">

                Careers

            </a>


            <a href="#contact">

                Contact

            </a>

        </div>


        <div>

            <h4>

                For you

            </h4>


            <a href="${pageContext.request.contextPath}/restaurants#offers">

                Offers

            </a>


            <a href="#help">

                Help centre

            </a>


            <a href="#terms">

                Terms

            </a>

        </div>


        <div>

            <h4>

                Follow us

            </h4>


            <div class="socials">


                <a href="#instagram">

                    ig

                </a>


                <a href="#facebook">

                    f

                </a>


                <a href="#twitter">

                    𝕏

                </a>

            </div>

        </div>

    </div>


    <div class="container copyright">

        <span>

            © 2026 QuickBite. All rights reserved.

        </span>


        <span>

            Made for food lovers.

        </span>

    </div>

</footer>


</body>

</html>