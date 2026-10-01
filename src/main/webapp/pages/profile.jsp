<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>QuickBite | My Profile</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/profile.css">

</head>

<body>

<!-- ================= HEADER ================= -->

<header class="site-header">

<nav class="navbar container">

    <!-- BRAND -->

    <a class="brand"
       href="${pageContext.request.contextPath}/home">

        <span class="brand-mark">Q</span>

        <span>
            Quick<span>Bite</span>
        </span>

    </a>


    <!-- NAVIGATION -->

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


    <!-- ACTIONS -->

    <div class="nav-actions">

        <a class="login-link active"
           href="${pageContext.request.contextPath}/profile">

            ${user.name}

        </a>

        <a class="icon-button active"
           href="${pageContext.request.contextPath}/profile"
           aria-label="Profile">

            👤

        </a>

        <a class="cart-button"
           href="${pageContext.request.contextPath}/cart"
           aria-label="Cart">

            🛒

            <span>0</span>

        </a>

    </div>

</nav>

</header>

<!-- ================= MAIN ================= -->

<main>

<!-- PROFILE HERO -->

<section class="profile-hero">

    <div class="container">

        <p class="eyebrow">
            MY ACCOUNT
        </p>

        <h1>
            My Profile
        </h1>

        <p>
            Manage your personal information and delivery details.
        </p>

    </div>

</section>


<!-- ================= PROFILE CONTENT ================= -->

<section class="profile-section container">


    <!-- PROFILE HEADER CARD -->

    <div class="profile-card profile-header-card">

        <div class="profile-avatar">

            👤

        </div>

        <div class="profile-header-info">

            <h2>
                ${user.name}
            </h2>

            <p>
                ${user.email}
            </p>

        </div>

        <a class="edit-button"
           href="${pageContext.request.contextPath}/profile/edit">

            Edit Profile

        </a>

    </div>


    <!-- PERSONAL INFORMATION -->

    <div class="profile-card">

        <div class="card-heading">

            <div>

                <p class="card-label">
                    ACCOUNT
                </p>

                <h2>
                    Personal Information
                </h2>

            </div>

        </div>


        <div class="information-grid">

            <div class="information-item">

                <span class="information-label">
                    Full Name
                </span>

                <span class="information-value">
                    ${user.name}
                </span>

            </div>


            <div class="information-item">

                <span class="information-label">
                    Email Address
                </span>

                <span class="information-value">
                    ${user.email}
                </span>

            </div>


            <div class="information-item">

                <span class="information-label">
                    Phone Number
                </span>

                <span class="information-value">
                    ${user.phoneNumber}
                </span>

            </div>


            <div class="information-item">

                <span class="information-label">
                    Customer ID
                </span>

                <span class="information-value">
                    #${user.userID}
                </span>

            </div>

        </div>

    </div>


    <!-- DELIVERY ADDRESS -->

    <div class="profile-card">

        <div class="card-heading">

            <div>

                <p class="card-label">
                    DELIVERY
                </p>

                <h2>
                    Delivery Address
                </h2>

            </div>

        </div>


        <div class="address-box">

            <span class="address-icon">
                📍
            </span>

            <div>

                <h3>
                    Your Address
                </h3>

                <p>
                    ${user.address}
                </p>

            </div>

        </div>

    </div>


    <!-- MY ORDERS -->

    <!-- MY ORDERS -->

<a class="action-card"
   href="${pageContext.request.contextPath}/orderHistory">

    <div class="action-icon">
        📦
    </div>

    <div class="action-content">

        <h2>
            My Orders
        </h2>

        <p>
            View your previous orders and order details.
        </p>

    </div>

    <span class="action-arrow">
        →
    </span>

</a>

    <!-- LOGOUT -->

    <div class="logout-section">

        <a class="logout-button"
           href="${pageContext.request.contextPath}/logout">

            Logout

        </a>

    </div>

</section>

</main>

<!-- ================= FOOTER ================= -->

<footer class="site-footer">

<div class="container footer-content">

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


    <div class="footer-links">

        <a href="${pageContext.request.contextPath}/restaurants">
            Restaurants
        </a>

        <a href="${pageContext.request.contextPath}/restaurants#offers">
            Offers
        </a>

        <a href="${pageContext.request.contextPath}/cart">
            Cart
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
