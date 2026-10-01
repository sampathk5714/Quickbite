<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/login.css">

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


        <a class="back-link"
           href="${pageContext.request.contextPath}/restaurants">

            ← Back to restaurants

        </a>


    </nav>

</header>


<main>


    <section class="login-section">


        <div class="login-card">


            <div class="login-heading">


                <div class="login-icon">
                    Q
                </div>


                <p class="eyebrow">
                    WELCOME BACK
                </p>


                <h1>
                    Login to QuickBite
                </h1>


                <p>
                    Login to continue ordering your favourite food.
                </p>


            </div>


           <%
    String loginError =
            (String) request.getAttribute("loginError");

    if (loginError != null && !loginError.isEmpty()) {
%>

    <div class="error-message">
        <%= loginError %>
    </div>

<%
    }
%>

            <form action="${pageContext.request.contextPath}/login"
                  method="post">


                <div class="form-group">


                    <label for="email">
                        Email
                    </label>


                    <input
                        type="email"
                        id="email"
                        name="email"
                        placeholder="Enter your email"
                        required>


                </div>


                <div class="form-group">


                    <label for="password">
                        Password
                    </label>


                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password"
                        required>


                </div>


                <button
                    type="submit"
                    class="login-button">

                    Login

                    <span>
                        →
                    </span>

                </button>


            </form>


            <p class="register-text">

                Don't have an account?


                <a href="${pageContext.request.contextPath}/pages/register.jsp">

                    Create an account

                </a>


            </p>


        </div>


    </section>


</main>


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


    </div>


    <div class="container copyright">

        © 2026 QuickBite. All rights reserved.

    </div>


</footer>


</body>

</html>
