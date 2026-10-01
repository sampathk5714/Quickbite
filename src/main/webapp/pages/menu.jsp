<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Menu" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | Menu</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/menu.css">

</head>

<body>


<!-- ================= HEADER ================= -->

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

            <a class="active"
               href="${pageContext.request.contextPath}/restaurants">

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
                       placeholder="Search dishes">

            </label>


            <button class="location"
                    type="button">

                <span>⌖</span>

                Bengaluru

                <span>⌄</span>

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


<!-- ================= MENU HERO ================= -->

<section class="menu-hero">

    <div class="container menu-hero-content">

        <div>

            <p class="eyebrow">

                FRESH FROM THE KITCHEN

            </p>


            <h1>

                Choose your<br>

                <em>favourites.</em>

            </h1>


            <p class="menu-hero-copy">

                Delicious food made fresh and delivered to your door.

            </p>

        </div>


        <div class="menu-hero-art"
             aria-hidden="true">

            🍽️

        </div>

    </div>

</section>


<!-- ================= MAIN ================= -->

<main>

    <section class="menu-section container">


        <!-- SECTION HEADING -->

        <div class="section-heading">

            <div>

                <p class="eyebrow">

                    OUR MENU

                </p>


                <h2>

                    What would you like to eat?

                </h2>


                <p class="subtitle">

                    Pick your favourite dishes and add them to your cart.

                </p>

            </div>


            <a class="back-link"
               href="${pageContext.request.contextPath}/restaurants">

                ← Back to restaurants

            </a>

        </div>


        <!-- ================= CATEGORIES ================= -->

        <div class="category-list">

            <a class="category active"
               href="#menu">

                All

            </a>

            <a class="category"
               href="#starters">

                Starters

            </a>

            <a class="category"
               href="#main-course">

                Main Course

            </a>

            <a class="category"
               href="#biryani">

                Biryani

            </a>

            <a class="category"
               href="#pizza">

                Pizza

            </a>

            <a class="category"
               href="#desserts">

                Desserts

            </a>

        </div>


        <!-- ================= MENU ITEMS ================= -->

        <%
            List<Menu> menus =
                    (List<Menu>) request.getAttribute("menus");

            if (menus != null && !menus.isEmpty()) {
        %>


            <div class="menu-grid">


                <%
                    for (Menu menu : menus) {
                %>


                    <article class="menu-card">


                        <div class="menu-image">


                            <%
                                if (menu.getImagePath() != null
                                        && !menu.getImagePath().isEmpty()) {
                            %>


                                <img
                                    src="${pageContext.request.contextPath}/images/<%= menu.getImagePath() %>"
                                    alt="<%= menu.getItemName() %>">


                            <%
                                } else {
                            %>


                                <div class="menu-placeholder">

                                    🍽️

                                </div>


                            <%
                                }
                            %>


                        </div>


                        <div class="menu-body">


                            <div class="menu-title-row">


                                <h3 class="menu-title">

                                    <%= menu.getItemName() %>

                                </h3>


                                <span class="menu-price">

                                    ₹<%= menu.getPrice() %>

                                </span>

                            </div>


                            <p class="menu-description">

                                <%= menu.getDescription() %>

                            </p>


                            <span class="menu-category">

                                <%= menu.getCategory() %>

                            </span>


                            <form class="add-cart-form"
                                  action="${pageContext.request.contextPath}/cart"
                                  method="post">


                                <input type="hidden"
                                       name="action"
                                       value="add">


                                <input type="hidden"
                                       name="menuID"
                                       value="<%= menu.getMenuID() %>">


                                <input type="hidden"
                                       name="quantity"
                                       value="1">


                                <button class="add-button"
                                        type="submit">

                                    Add to Cart

                                </button>

                            </form>


                        </div>

                    </article>


                <%
                    }
                %>


            </div>


        <%
            } else {
        %>


            <div class="empty-menu">


                <div class="empty-menu-icon">

                    🍽️

                </div>


                <h3>

                    No menu items available

                </h3>


                <p>

                    This restaurant hasn't added any available dishes yet.

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


        <!-- SOCIAL -->

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