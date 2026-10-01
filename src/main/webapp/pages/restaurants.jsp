<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Restaurant" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | Restaurants</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/restaurants.css">

</head>

<body>


<!-- ================= HEADER ================= -->

<header class="site-header">

    <nav class="navbar container"
         aria-label="Primary navigation">


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

            <a class="active"
               href="${pageContext.request.contextPath}/restaurants">

                Restaurants

            </a>

            <a href="#offers">
                Offers
            </a>

        </div>


        <div class="nav-actions">


            <label class="search-box">

                <span aria-hidden="true">⌕</span>

                <input type="search"
                       placeholder="Search restaurants or dishes"
                       aria-label="Search restaurants or dishes">

            </label>


            <button class="location"
                    type="button">

                <span aria-hidden="true">⌖</span>

                Bengaluru

                <span aria-hidden="true">⌄</span>

            </button>


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


            <a class="cart-button"
               href="${pageContext.request.contextPath}/cart"
               aria-label="Cart">

                🛒

                <span>
                    ${empty sessionScope.cart ? 0 : sessionScope.cart.size()}
                </span>

            </a>

        </div>

    </nav>

</header>


<!-- ================= MAIN ================= -->

<main>


    <!-- ================= HERO ================= -->

    <section class="hero">

        <div class="container hero-content">


            <div>

                <p class="eyebrow">

                    DELIVERED FRESH TO YOUR DOOR

                </p>


                <h1>

                    Good food.<br>

                    <em>Good mood.</em>

                </h1>


                <p class="hero-copy">

                    Discover the best restaurants and local favourites near you.

                </p>

            </div>


            <div class="hero-art"
                 aria-hidden="true">

                <span>🍜</span>
                <span>🥗</span>
                <span>🍕</span>

            </div>

        </div>

    </section>


    <!-- ================= RESTAURANTS ================= -->

    <section class="restaurant-section container"
             id="restaurants">


        <div class="section-heading">


            <div>

                <p class="eyebrow">

                    HANDPICKED FOR YOU

                </p>


                <h2>

                    Restaurants near you

                </h2>


                <p class="subtitle">

                    The best flavours, just around the corner.

                </p>

            </div>


            <a class="view-all"
               href="#all-restaurants">

                View all

                <span>→</span>

            </a>

        </div>


        <!-- ================= FILTERS ================= -->

        <div class="filters"
             aria-label="Food categories">


            <a class="filter active"
               href="#restaurants">

                All

            </a>


            <a class="filter"
               href="#indian">

                Indian

            </a>


            <a class="filter"
               href="#chinese">

                Chinese

            </a>


            <a class="filter"
               href="#pizza">

                Pizza

            </a>


            <a class="filter"
               href="#burgers">

                Burgers

            </a>


            <a class="filter"
               href="#healthy">

                Healthy

            </a>


            <a class="filter"
               href="#desserts">

                Desserts

            </a>

        </div>


        <!-- ================= DATABASE RESTAURANTS ================= -->

        <div class="restaurant-grid">


            <%
                List<Restaurant> restaurants =
                        (List<Restaurant>) request.getAttribute("restaurants");

                if (restaurants != null) {

                    for (Restaurant restaurant : restaurants) {
            %>


                <!--
                    Entire restaurant card is clickable.
                    Clicking anywhere opens the restaurant menu.
                -->


                <a class="restaurant-card"
                   href="${pageContext.request.contextPath}/menu?restaurantID=<%= restaurant.getRestaurantID() %>">


                    <!-- ================= IMAGE ================= -->

                    <div class="card-image">


                        <%
                            if (restaurant.getImagePath() != null
                                    && !restaurant.getImagePath().isEmpty()) {
                        %>


                            <img
                                src="${pageContext.request.contextPath}/images/<%= restaurant.getImagePath() %>"
                                alt="<%= restaurant.getRestaurantName() %>">


                        <%
                            } else {
                        %>


                            <div style="
                                height: 100%;
                                display: flex;
                                align-items: center;
                                justify-content: center;
                                font-size: 50px;
                                background: #f8e9dc;
                            ">

                                🍽️

                            </div>


                        <%
                            }
                        %>


                        <!-- OFFER -->

                        <%
                            if (restaurant.getOffer() != null
                                    && !restaurant.getOffer().isEmpty()) {
                        %>

                            <span class="offer-badge">

                                <%= restaurant.getOffer() %>

                            </span>

                        <%
                            }
                        %>


                        <!-- HEART -->

                        <span class="heart"
                              aria-hidden="true">

                            ♡

                        </span>

                    </div>


                    <!-- ================= RESTAURANT DETAILS ================= -->

                    <div class="card-body">


                        <div class="card-title">


                            <h3>

                                <%= restaurant.getRestaurantName() %>

                            </h3>


                            <span class="rating">

                                ★ <%= restaurant.getRating() %>

                            </span>

                        </div>


                        <p class="cuisine">

                            <%= restaurant.getCuisineType() %>

                        </p>


                        <div class="meta">


                            <span>

                                ● <%= restaurant.getDeliveryTime() %> min

                            </span>


                            <span>

                                <%
                                    if (restaurant.getDeliveryFee() == 0) {
                                %>

                                    Free delivery

                                <%
                                    } else {
                                %>

                                    ₹<%= restaurant.getDeliveryFee() %> delivery

                                <%
                                    }
                                %>

                            </span>

                        </div>


                        <p class="location-text">

                            <%= restaurant.getAddress() %>

                        </p>


                        <!-- Visual menu button -->

                        <div class="menu-button">

                            View Menu

                            <span>→</span>

                        </div>

                    </div>

                </a>


            <%
                    }

                }
            %>


        </div>

    </section>


    <!-- ================= OFFERS ================= -->

    <section class="offers-section"
             id="offers">


        <div class="container">


            <div class="section-heading">


                <div>

                    <p class="eyebrow">

                        SAVE MORE ON EVERY ORDER

                    </p>


                    <h2>

                        Offers for you

                    </h2>


                    <p class="subtitle">

                        Good food tastes even better with a great deal.

                    </p>

                </div>


                <a class="view-all"
                   href="#all-offers">

                    View all

                    <span>→</span>

                </a>

            </div>


            <div class="offer-grid">


                <!-- OFFER 1 -->

                <div class="offer-card orange">


                    <div>

                        <span class="offer-label">

                            WELCOME OFFER

                        </span>


                        <h3>

                            20% off your first order

                        </h3>


                        <p>

                            Use code

                            <strong>

                                WELCOME20

                            </strong>

                        </p>

                    </div>


                    <span class="offer-icon">

                        %

                    </span>

                </div>


                <!-- OFFER 2 -->

                <div class="offer-card dark">


                    <div>

                        <span class="offer-label">

                            FREE DELIVERY

                        </span>


                        <h3>

                            On orders above ₹499

                        </h3>


                        <p>

                            Every day, all your favourites.

                        </p>

                    </div>


                    <span class="offer-icon">

                        ⌁

                    </span>

                </div>


            </div>

        </div>

    </section>

</main>


<!-- ================= FOOTER ================= -->

<footer class="site-footer">


    <div class="container footer-grid">


        <!-- BRAND -->

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


        <!-- QUICKBITE -->

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


        <!-- FOR YOU -->

        <div>


            <h4>

                For you

            </h4>


            <a href="#offers">

                Offers

            </a>


            <a href="#help">

                Help centre

            </a>


            <a href="#terms">

                Terms

            </a>

        </div>


        <!-- SOCIAL -->

        <div>


            <h4>

                Follow us

            </h4>


            <div class="socials">


                <a href="#instagram"
                   aria-label="Instagram">

                    ig

                </a>


                <a href="#facebook"
                   aria-label="Facebook">

                    f

                </a>


                <a href="#twitter"
                   aria-label="Twitter">

                    𝕏

                </a>

            </div>

        </div>

    </div>


    <!-- COPYRIGHT -->

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