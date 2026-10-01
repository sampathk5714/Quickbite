<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.foodapp.model.Order" %>
<%@ page import="com.foodapp.model.Restaurant" %>
<%@ page import="com.foodapp.model.OrderHistoryItem" %>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>QuickBite | Order History</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/order-history.css">

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


        <a class="cart-button"
           href="${pageContext.request.contextPath}/cart">

            🛒

            <span>
                ${empty cart ? 0 : cart.size()}
            </span>

        </a>


        <a class="logout-link"
           href="${pageContext.request.contextPath}/logout">

            Logout

        </a>


    </div>

</nav>

</header>

<main>

<section class="history-section container">


    <div class="page-heading">


        <div>

            <p class="eyebrow">
                YOUR ORDERS
            </p>

            <h1>
                Order History
            </h1>

            <p class="subtitle">
                View your previous QuickBite orders.
            </p>

        </div>


        <a class="browse-button"
           href="${pageContext.request.contextPath}/restaurants">

            Browse Restaurants

            <span>
                →
            </span>

        </a>


    </div>


    <%
        List<Order> orders =
                (List<Order>) request.getAttribute("orders");

        Map<Integer, Restaurant> restaurantMap =
                (Map<Integer, Restaurant>)
                request.getAttribute("restaurantMap");

        Map<Integer, List<OrderHistoryItem>> orderItemsMap =
                (Map<Integer, List<OrderHistoryItem>>)
                request.getAttribute("orderItemsMap");


        if (orders != null && !orders.isEmpty()) {
    %>


        <div class="orders-list">


            <%
                for (Order order : orders) {

                    Restaurant restaurant =
                            restaurantMap.get(order.getRestaurantID());

                    List<OrderHistoryItem> historyItems =
                            orderItemsMap.get(order.getOrderID());
            %>


                <article class="order-card">


                    <div class="order-top">


                        <div>

                            <span class="order-label">
                                ORDER ID
                            </span>

                            <h2>
                                #<%= order.getOrderID() %>
                            </h2>

                        </div>


                        <span class="status">
                            <%= order.getOrderStatus() %>
                        </span>


                    </div>


                    <div class="restaurant-heading">


                        <div class="restaurant-icon">
                            🍽️
                        </div>


                        <div>

                            <h3>
                                <%= restaurant.getRestaurantName() %>
                            </h3>

                            <p>
                                <%= restaurant.getCuisineType() %>
                            </p>

                        </div>


                    </div>


                    <div class="ordered-items">


                        <div class="section-label">
                            ORDERED ITEMS
                        </div>


                        <%
                            if (historyItems != null) {

                                for (OrderHistoryItem item :
                                        historyItems) {
                        %>


                                    <div class="ordered-item">


                                        <div class="item-info">

                                            <strong>

                                                <%= item.getQuantity() %>
                                                ×
                                                <%= item.getItemName() %>

                                            </strong>

                                            <span>

                                                ₹<%= item.getPrice() %>
                                                each

                                            </span>

                                        </div>


                                        <strong>

                                            ₹<%= item.getItemTotal() %>

                                        </strong>


                                    </div>


                        <%
                                }
                            }
                        %>


                    </div>


                    <div class="order-details">


                        <div class="detail">

                            <span class="detail-label">
                                Order Date
                            </span>

                            <strong>
                                <%= order.getOrderDate() %>
                            </strong>

                        </div>


                        <div class="detail">

                            <span class="detail-label">
                                Payment
                            </span>

                            <strong>
                                <%= order.getPaymentMethod() %>
                            </strong>

                        </div>


                        <div class="detail">

                            <span class="detail-label">
                                Delivery Address
                            </span>

                            <strong>
                                <%= order.getDeliveryAddress() %>
                            </strong>

                        </div>


                    </div>


                    <div class="order-bottom">


                        <div>

                            <span class="detail-label">
                                Delivery Fee
                            </span>

                            <strong>
                                ₹<%= order.getDeliveryFee() %>
                            </strong>

                        </div>


                        <div class="total-box">

                            <span>
                                Total Amount
                            </span>

                            <strong>
                                ₹<%= order.getTotalAmount() %>
                            </strong>

                        </div>


                    </div>


                </article>


            <%
                }
            %>


        </div>


    <%
        } else {
    %>


        <div class="empty-orders">


            <div class="empty-icon">
                🧾
            </div>


            <h2>
                No orders yet
            </h2>


            <p>
                You haven't placed any orders yet.
                Explore restaurants and order your favourite food.
            </p>


            <a class="browse-button"
               href="${pageContext.request.contextPath}/restaurants">

                Explore Restaurants

                <span>
                    →
                </span>

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
