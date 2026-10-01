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

<title>QuickBite - Good food. Great mood.</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/home.css">

</head>

<body>

<main id="top">

<!-- ================= NAVBAR ================= -->

<nav class="quickbite-navbar"
     aria-label="Main navigation">

    <div class="nav-inner">

        <a class="brand"
           href="${pageContext.request.contextPath}/home">

            <span class="brand-mark">⚡</span>

            <span>
                quick<span>bite</span>
            </span>

        </a>


        <div class="desktop-links">

            <a class="active"
               href="${pageContext.request.contextPath}/home">
                Home
            </a>

            <a href="${pageContext.request.contextPath}/restaurants">
                Restaurants
            </a>

            <a href="#offers">
                Offers
            </a>

        </div>


        <div class="nav-actions">

            <button class="location-pill"
                    aria-label="Choose location">

                ⌖

                <span>${user.address}</span>

                ⌄

            </button>


            <button class="icon-button"
                    aria-label="Search">

                ⌕

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


            <a class="bag-button"
               href="${pageContext.request.contextPath}/cart"
               aria-label="Shopping bag">

                ▱

                <span>
                    ${empty sessionScope.cart ? 0 : sessionScope.cart.size()}
                </span>

            </a>


            <button class="mobile-menu"
                    aria-label="Open menu">

                ☰

            </button>

        </div>

    </div>

</nav>


<!-- ================= HERO ================= -->

<section class="hero-section">

    <div class="hero-orb hero-orb-one"></div>

    <div class="hero-orb hero-orb-two"></div>

    <div class="hero-content">

        <div class="hero-copy">

            <p class="eyebrow">

                <span></span>

                Delivered with care

            </p>


            <h1>

                Good food.<br>

                <em>Great mood.</em>

            </h1>


            <p class="hero-description">

                Discover the best food and drinks from your
                favourite local spots, delivered fresh to your door.

            </p>


            <div class="search-box">

                <div class="search-location">

                    ⌖

                    <span>${user.address}</span>

                    ⌄

                </div>


                <div class="search-divider"></div>


                <label class="search-input">

                    ⌕

                    <input type="search"
                           placeholder="Search for restaurants or dishes"
                           aria-label="Search for restaurants or dishes">

                </label>


                <button class="search-button">

                    Search

                </button>

            </div>


            <div class="hero-note">

                <span class="avatar-stack">

                    <span>R</span>
                    <span>A</span>
                    <span>S</span>

                </span>


                <span>

                    <strong>50k+</strong>

                    happy foodies and counting

                </span>

            </div>

        </div>


        <!-- HERO IMAGE -->

        <div class="hero-visual">

            <div class="hero-card-main">

                <img
                    src="https://images.unsplash.com/photo-1601050690597-df0568f70950?w=1000&q=90"
                    alt="Colourful Indian samosas served with chutney">


                <div class="hero-food-caption">

                    <span class="caption-icon">
                        ▸
                    </span>


                    <span>

                        <strong>
                            Arriving in 25 mins
                        </strong>

                        <small>
                            Fresh from Samosa Party
                        </small>

                    </span>


                    <span class="caption-check">
                        ✓
                    </span>

                </div>

            </div>


            <div class="floating-rating">

                ★

                <strong>4.9</strong>

                <small>top rated</small>

            </div>


            <div class="floating-offer">

                ♧

                <span>

                    <strong>
                        Free delivery
                    </strong>

                    <small>
                        on your first 3 orders
                    </small>

                </span>

            </div>

        </div>

    </div>

</section>


<!-- ================= CATEGORIES ================= -->

<section class="content-section category-section">

    <div class="section-heading">

        <div>

            <p class="eyebrow">
                Explore the menu
            </p>

            <h2>
                What are you craving?
            </h2>

        </div>


        <a href="#categories">
            See all →
        </a>

    </div>


    <div class="category-scroll"
         id="categories">


        <a class="category-card"
           href="#restaurants">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1585937421612-70a008356fbe?w=500&q=85"
                    alt="Biryani">

            </div>

            <span>Biryani</span>

        </a>


        <a class="category-card"
           href="#dishes">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=500&q=85"
                    alt="Pizza">

            </div>

            <span>Pizza</span>

        </a>


        <a class="category-card"
           href="#dishes">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500&q=85"
                    alt="Burgers">

            </div>

            <span>Burgers</span>

        </a>


        <a class="category-card"
           href="#dishes">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1630383249896-424e482df921?w=500&q=85"
                    alt="South Indian">

            </div>

            <span>South Indian</span>

        </a>


        <a class="category-card"
           href="#dishes">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1585032226651-759b368d7246?w=500&q=85"
                    alt="Chinese">

            </div>

            <span>Chinese</span>

        </a>


        <a class="category-card"
           href="#dishes">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1551024506-0bccd828d307?w=500&q=85"
                    alt="Desserts">

            </div>

            <span>Desserts</span>

        </a>


        <a class="category-card"
           href="#dishes">

            <div class="category-image">

                <img
                    src="https://images.unsplash.com/photo-1544145945-f90425340c7e?w=500&q=85"
                    alt="Beverages">

            </div>

            <span>Beverages</span>

        </a>

    </div>

</section>


<!-- ================= RESTAURANTS ================= -->

<section class="content-section restaurants-section"
         id="restaurants">

    <div class="section-heading">

        <div>

            <p class="eyebrow">
                Handpicked for you
            </p>

            <h2>
                Popular near you
            </h2>

        </div>


        <a href="${pageContext.request.contextPath}/restaurants">

            View all →

        </a>

    </div>


    <div class="restaurant-grid">

        <%
            List<Restaurant> restaurants =
                    (List<Restaurant>) request.getAttribute("restaurants");

            if (restaurants != null) {

                for (Restaurant restaurant : restaurants) {
        %>


            <a href="${pageContext.request.contextPath}/menu?restaurantID=<%= restaurant.getRestaurantID() %>"
               class="restaurant-card">


                <div class="restaurant-image">


                    <%
                        if (restaurant.getOffer() != null
                                && !restaurant.getOffer().isEmpty()) {
                    %>

                        <span class="offer-tag">

                            <%= restaurant.getOffer() %>

                        </span>

                    <%
                        }
                    %>


                    <span class="heart-button">

                        ♡

                    </span>


                    <img
                        src="${pageContext.request.contextPath}/images/<%= restaurant.getImagePath() %>"
                        alt="<%= restaurant.getRestaurantName() %>">

                </div>


                <div class="restaurant-details">


                    <div class="restaurant-title">

                        <h3>

                            <%= restaurant.getRestaurantName() %>

                        </h3>


                        <span class="rating">

                            ★ <%= restaurant.getRating() %>

                        </span>

                    </div>


                    <p>

                        <%= restaurant.getCuisineType() %>

                    </p>


                    <div class="restaurant-meta">

                        <span>

                            🕐 <%= restaurant.getDeliveryTime() %> min

                        </span>


                        <span>

                            🚴 ₹<%= restaurant.getDeliveryFee() %> delivery

                        </span>

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

<section class="content-section offers-section"
         id="offers">

    <div class="section-heading">

        <div>

            <p class="eyebrow">
                Save more, eat more
            </p>

            <h2>
                Offers made for you
            </h2>

        </div>

    </div>


    <div class="offers-grid">


        <article class="offer-card offer-orange">

            <div>

                <span class="offer-kicker">
                    LIMITED TIME
                </span>

                <h3>
                    20% off<br>
                    your first order
                </h3>

                <p>

                    Use code <strong>WELCOME20</strong>

                </p>

            </div>


            <span class="offer-art">

                20<small>%</small>

            </span>

        </article>


        <article class="offer-card offer-dark">

            <div>

                <span class="offer-kicker">
                    ON ORDERS ABOVE ₹499
                </span>

                <h3>
                    Free<br>
                    delivery
                </h3>

                <p>
                    Good food, no extra fees.
                </p>

            </div>


            <span class="offer-art">
                ▸
            </span>

        </article>


        <article class="offer-card offer-cream">

            <div>

                <span class="offer-kicker">
                    WEEKEND SPECIAL
                </span>

                <h3>
                    Flat ₹100<br>
                    off
                </h3>

                <p>
                    On your favourite local spots.
                </p>

            </div>


            <span class="offer-art">
                ₹
            </span>

        </article>

    </div>

</section>


<!-- ================= WHY QUICKBITE ================= -->

<section class="why-section">

    <div class="why-inner">


        <div class="why-intro">

            <p class="eyebrow">
                The QuickBite promise
            </p>

            <h2>

                Made for your<br>

                <em>everyday cravings.</em>

            </h2>

            <p>

                From the first click to the last bite,
                we make food ordering feel effortless.

            </p>

        </div>


        <div class="benefit-grid">


            <div class="benefit">

                <span>▸</span>

                <h3>
                    Fast delivery
                </h3>

                <p>
                    Hot and fresh, right on time.
                </p>

            </div>


            <div class="benefit">

                <span>♡</span>

                <h3>
                    Trusted restaurants
                </h3>

                <p>
                    Only the best make the cut.
                </p>

            </div>


            <div class="benefit">

                <span>▣</span>

                <h3>
                    Easy ordering
                </h3>

                <p>
                    A few taps to happy.
                </p>

            </div>


            <div class="benefit">

                <span>⌖</span>

                <h3>
                    Live tracking
                </h3>

                <p>
                    Know where your food is.
                </p>

            </div>

        </div>

    </div>

</section>


<!-- ================= FOOTER ================= -->

<footer class="footer">

    <div class="footer-top">


        <div class="footer-brand">

            <a class="brand"
               href="#top">

                <span class="brand-mark">
                    ⚡
                </span>

                <span>
                    quick<span>bite</span>
                </span>

            </a>


            <p>

                Good food, good days.<br>
                Delivered with care.

            </p>

        </div>


        <div class="footer-links">


            <div>

                <h3>
                    QuickBite
                </h3>

                <a href="#">
                    About us
                </a>

                <a href="#">
                    Careers
                </a>

                <a href="#offers">
                    Offers
                </a>

            </div>


            <div>

                <h3>
                    Support
                </h3>

                <a href="#">
                    Help centre
                </a>

                <a href="#">
                    Contact us
                </a>

                <a href="#">
                    Safety
                </a>

            </div>


            <div>

                <h3>
                    Legal
                </h3>

                <a href="#">
                    Terms
                </a>

                <a href="#">
                    Privacy
                </a>

                <a href="#">
                    Cookies
                </a>

            </div>

        </div>

    </div>


    <div class="footer-bottom">

        <span>

            © 2026 QuickBite Technologies Pvt. Ltd.

        </span>


        <span>

            Made for food lovers in India

        </span>

    </div>

</footer>

</main>

</body>

</html>
