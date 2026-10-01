<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>QuickBite | Change Restaurant</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/cart.css">

</head>

<body>


<header class="site-header">

    <nav class="navbar container">

        <a class="brand"
           href="${pageContext.request.contextPath}/">

            <span class="brand-mark">Q</span>

            <span>
                Quick<span>Bite</span>
            </span>

        </a>

    </nav>

</header>


<main>

    <section class="conflict-section container">


        <div class="conflict-card">


            <div class="conflict-icon">
                🛒
            </div>


            <p class="eyebrow">
                DIFFERENT RESTAURANT
            </p>


            <h1>
                Your cart has items from another restaurant
            </h1>


            <p class="conflict-message">

                You can only order from one restaurant at a time.

                Would you like to clear your current cart
                and add this item?

            </p>


            <div class="conflict-actions">


                <a class="stay-button"
                   href="${pageContext.request.contextPath}/restaurants">

                    No, Keep My Cart

                </a>


                <form action="${pageContext.request.contextPath}/cart"
                      method="post">

                    <input type="hidden"
                           name="action"
                           value="confirmChange">


                    <button class="change-button"
                            type="submit">

                        Clear Cart & Add Item

                    </button>

                </form>


            </div>


        </div>

    </section>

</main>


<footer class="site-footer">

    <div class="container footer-grid">


        <div>

            <a class="brand footer-brand"
               href="${pageContext.request.contextPath}/">

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