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

<title>QuickBite | Checkout</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/checkout.css">

</head>

<body>

<header class="site-header">

<nav class="navbar container">

    <a class="brand"
       href="${pageContext.request.contextPath}/home">

        <span class="brand-mark">Q</span>

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

        <a class="cart-button active"
           href="${pageContext.request.contextPath}/cart">

            🛒

            <span>
                ${empty cart ? 0 : cart.size()}
            </span>

        </a>

    </div>

</nav>
```

</header>

<main>

<section class="checkout-section container">


    <div class="page-heading">

        <div>

            <p class="eyebrow">
                ALMOST THERE
            </p>

            <h1>
                Checkout
            </h1>

            <p class="subtitle">
                Complete your order and get your food delivered.
            </p>

        </div>


        <a class="back-link"
           href="${pageContext.request.contextPath}/cart">

            ← Back to cart

        </a>

    </div>


    <div class="checkout-layout">


        <div class="checkout-left">


            <div class="checkout-card">


                <div class="card-heading">

                    <div class="step-number">
                        1
                    </div>

                    <div>

                        <h2>
                            Delivery address
                        </h2>

                        <p>
                            Where should we deliver your order?
                        </p>

                    </div>

                </div>


                <form id="orderForm"
                      action="${pageContext.request.contextPath}/placeOrder"
                      method="post">


                    <div class="form-group">

                        <label for="deliveryAddress">
                            Delivery address
                        </label>

                        <textarea
                            id="deliveryAddress"
                            name="deliveryAddress"
                            rows="4"
                            placeholder="Enter your complete delivery address"
                            required>${user.address}</textarea>

                    </div>


                    <div class="card-heading payment-heading">

                        <div class="step-number">
                            2
                        </div>

                        <div>

                            <h2>
                                Payment method
                            </h2>

                            <p>
                                Choose how you want to pay.
                            </p>

                        </div>

                    </div>


                    <div class="payment-options">


                        <label class="payment-option">

                            <input
                                type="radio"
                                name="paymentMethod"
                                value="Cash on Delivery"
                                required>

                            <span class="payment-icon">
                                💵
                            </span>

                            <span class="payment-content">

                                <strong>
                                    Cash on Delivery
                                </strong>

                                <small>
                                    Pay when your order arrives
                                </small>

                            </span>

                        </label>


                        <label class="payment-option">

                            <input
                                type="radio"
                                name="paymentMethod"
                                value="UPI">

                            <span class="payment-icon">
                                📱
                            </span>

                            <span class="payment-content">

                                <strong>
                                    UPI
                                </strong>

                                <small>
                                    Pay using your UPI app
                                </small>

                            </span>

                        </label>


                        <label class="payment-option">

                            <input
                                type="radio"
                                name="paymentMethod"
                                value="Card">

                            <span class="payment-icon">
                                💳
                            </span>

                            <span class="payment-content">

                                <strong>
                                    Card
                                </strong>

                                <small>
                                    Credit or debit card
                                </small>

                            </span>

                        </label>


                    </div>


                </form>


            </div>


        </div>


        <div class="checkout-right">


            <div class="summary-card">


                <h2>
                    Order summary
                </h2>


                <div class="restaurant-info">

                    <div class="restaurant-icon">
                        🍽️
                    </div>

                    <div>

                        <strong>
                            ${restaurant.restaurantName}
                        </strong>

                        <span>
                            ${restaurant.cuisineType}
                        </span>

                    </div>

                </div>


                <div class="summary-items">


                    <%
                        Map<Integer, CartItem> cart =
                                (Map<Integer, CartItem>) session.getAttribute("cart");

                        if (cart != null && !cart.isEmpty()) {

                            for (CartItem item : cart.values()) {
                    %>

                        <div class="summary-item">

                            <div>

                                <strong>
                                    <%= item.getQuantity() %>
                                    ×
                                    <%= item.getItemName() %>
                                </strong>

                                <span>
                                    ₹<%= item.getPrice() %> each
                                </span>

                            </div>

                            <strong>
                                ₹<%= item.getTotalPrice() %>
                            </strong>

                        </div>

                    <%
                            }
                        }
                    %>


                </div>


                <div class="summary-divider"></div>


                <div class="summary-row">

                    <span>
                        Item total
                    </span>

                    <span>
                        ₹${itemTotal}
                    </span>

                </div>


                <div class="summary-row">

                    <span>
                        Delivery fee
                    </span>

                    <span>
                        ₹${deliveryFee}
                    </span>

                </div>


                <div class="summary-divider"></div>


                <div class="summary-total">

                    <span>
                        Total
                    </span>

                    <strong>
                        ₹${totalAmount}
                    </strong>

                </div>


                <button
                    class="place-order-button"
                    type="submit"
                    form="orderForm">

                    Place Order

                    <span>
                        →
                    </span>

                </button>


                <p class="secure-text">
                    🔒 Your order information is secure
                </p>


            </div>


        </div>


    </div>


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
