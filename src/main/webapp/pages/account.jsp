<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | My Account</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/account.css">

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

            <a href="${pageContext.request.contextPath}/orderHistory">
                Orders
            </a>

        </div>

        <div class="nav-actions">

            <a class="cart-button"
               href="${pageContext.request.contextPath}/cart">

                🛒

            </a>

            <a class="logout-link"
               href="${pageContext.request.contextPath}/logout">

                Logout

            </a>

        </div>

    </nav>

</header>


<main>

    <section class="account-section container">

        <div class="page-heading">

            <p class="eyebrow">
                MY ACCOUNT
            </p>

            <h1>
                Welcome, ${user.name}
            </h1>

            <p class="subtitle">
                Manage and view your QuickBite account information.
            </p>

        </div>


        <div class="account-card">

            <div class="profile-header">

                <div class="profile-icon">
                    ${user.name.substring(0,1).toUpperCase()}
                </div>

                <div>

                    <h2>
                        ${user.name}
                    </h2>

                    <p>
                        QuickBite Customer
                    </p>

                </div>

            </div>


            <div class="account-details">

                <div class="detail">

                    <span class="detail-label">
                        FULL NAME
                    </span>

                    <strong>
                        ${user.name}
                    </strong>

                </div>


                <div class="detail">

                    <span class="detail-label">
                        EMAIL
                    </span>

                    <strong>
                        ${user.email}
                    </strong>

                </div>


                <div class="detail">

                    <span class="detail-label">
                        PHONE NUMBER
                    </span>

                    <strong>
                        ${user.phoneNumber}
                    </strong>

                </div>


                <div class="detail">

                    <span class="detail-label">
                        DELIVERY ADDRESS
                    </span>

                    <strong>
                        ${user.address}
                    </strong>

                </div>


                <div class="detail">

                    <span class="detail-label">
                        ACCOUNT CREATED
                    </span>

                    <strong>
                        ${user.createdAt}
                    </strong>

                </div>

            </div>


            <div class="account-actions">

                <a class="primary-button"
                   href="${pageContext.request.contextPath}/restaurants">

                    Order Food
                    <span>→</span>

                </a>

                <a class="secondary-button"
                   href="${pageContext.request.contextPath}/orderHistory">

                    View Order History

                </a>

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

            <a href="${pageContext.request.contextPath}/restaurants">
                Restaurants
            </a>

            <a href="${pageContext.request.contextPath}/restaurants#offers">
                Offers
            </a>

        </div>


        <div>

            <h4>
                Account
            </h4>

            <a href="${pageContext.request.contextPath}/orderHistory">
                My Orders
            </a>

            <a href="${pageContext.request.contextPath}/logout">
                Logout
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
