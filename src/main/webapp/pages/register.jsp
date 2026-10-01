<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | Register</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/register.css">

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
           href="${pageContext.request.contextPath}/login">

            ← Back to Login

        </a>


    </nav>

</header>


<main>


    <section class="register-section">


        <div class="register-card">


            <div class="register-heading">


                <div class="register-icon">
                    Q
                </div>


                <p class="eyebrow">
                    JOIN QUICKBITE
                </p>


                <h1>
                    Create Your Account
                </h1>


                <p>
                    Register to order your favourite food.
                </p>


            </div>


           <%
    String registerError =
            (String) request.getAttribute("registerError");

    if (registerError != null && !registerError.isEmpty()) {
%>

    <div class="error-message">
        <%= registerError %>
    </div>

<%
    }
%>


            <form action="${pageContext.request.contextPath}/register"
                  method="post">


                <div class="form-row">


                    <div class="form-group">


                        <label for="name">
                            Full Name
                        </label>


                        <input
                            type="text"
                            id="name"
                            name="name"
                            placeholder="Enter your name"
                            required>


                    </div>


                    <div class="form-group">


                        <label for="phoneNumber">
                            Phone Number
                        </label>


                        <input
                            type="tel"
                            id="phoneNumber"
                            name="phoneNumber"
                            placeholder="Enter your phone number"
                            required>


                    </div>


                </div>


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
                        placeholder="Create a password"
                        required>


                </div>


                <div class="form-group">


                    <label for="address">
                        Delivery Address
                    </label>


                    <textarea
                        id="address"
                        name="address"
                        placeholder="Enter your delivery address"
                        rows="3"
                        required></textarea>


                </div>


                <button
                    type="submit"
                    class="register-button">

                    Create Account

                    <span>
                        →
                    </span>

                </button>


            </form>


            <p class="login-text">

                Already have an account?


                <a href="${pageContext.request.contextPath}/login">

                    Login

                </a>


            </p>


        </div>


    </section>


</main>


<footer class="site-footer">


    <p>
        © 2026 QuickBite. All rights reserved.
    </p>


</footer>


</body>

</html>
