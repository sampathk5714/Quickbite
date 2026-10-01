<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
   content="width=device-width, initial-scale=1.0">

<title>QuickBite | Edit Profile</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/profile.css">

</head>

<body>

<!-- ================= HEADER ================= -->

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

    <a class="login-link"
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

<section class="profile-hero">

<div class="container">

    <p class="eyebrow">
        ACCOUNT SETTINGS
    </p>

    <h1>
        Edit Profile
    </h1>

    <p>
        Keep your personal and delivery information up to date.
    </p>

</div>

</section>

<!-- ================= FORM ================= -->

<section class="profile-section container">

<div class="profile-card edit-profile-card">

    <div class="card-heading">

        <p class="card-label">
            PERSONAL INFORMATION
        </p>

        <h2>
            Update your details
        </h2>

    </div>


    <%
        String errorMessage =
                (String) request.getAttribute("errorMessage");

        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>

        <div class="error-message">
            <%= errorMessage %>
        </div>

    <%
        }
    %>


    <form action="${pageContext.request.contextPath}/profile/edit"
          method="post">


        <!-- NAME -->

        <div class="form-group">

            <label for="name">
                Full Name
            </label>

            <input type="text"
                   id="name"
                   name="name"
                   value="${user.name}"
                   required>

        </div>


        <!-- EMAIL -->

        <div class="form-group">

            <label for="email">
                Email Address
            </label>

            <input type="email"
                   id="email"
                   name="email"
                   value="${user.email}"
                   required>

        </div>


        <!-- PHONE -->

        <div class="form-group">

            <label for="phoneNumber">
                Phone Number
            </label>

            <input type="tel"
                   id="phoneNumber"
                   name="phoneNumber"
                   value="${user.phoneNumber}"
                   required>

        </div>


        <!-- ADDRESS -->

        <div class="form-group">

            <label for="address">
                Delivery Address
            </label>

            <textarea id="address"
                      name="address"
                      rows="4"
                      required>${user.address}</textarea>

        </div>


        <!-- BUTTONS -->

        <div class="form-actions">

            <a class="cancel-button"
               href="${pageContext.request.contextPath}/profile">

                Cancel

            </a>

            <button type="submit"
                    class="save-button">

                Save Changes

            </button>

        </div>


    </form>

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
