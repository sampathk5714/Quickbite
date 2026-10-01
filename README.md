# 🍔 QuickBite – Food Delivery Web Application

QuickBite is a Java-based food delivery web application inspired by modern food-ordering platforms.

The application allows customers to browse restaurants, explore menus, add food items to a cart, place orders, and view their order history.

---

## 📌 Project Overview

QuickBite is developed using **Java, JSP, Servlets, JDBC, MySQL, HTML, and CSS**.

The application follows a structured MVC-style approach with separate model, DAO, DAO implementation, and controller layers.

The project focuses on implementing a complete customer-side food ordering workflow.

---

## ✨ Features

### 👤 User Management

* User registration
* User login and logout
* Session-based authentication
* View profile information
* Edit profile information
* Update delivery address
* Password stored securely using BCrypt during registration

### 🍴 Restaurant & Menu

* Browse available restaurants
* View restaurant information
* View restaurant menu
* Display cuisine type, rating, delivery time, offers, and delivery fee
* Display menu item availability
* Restaurant-specific menu browsing

### 🛒 Shopping Cart

* Add food items to cart
* Update item quantity
* Remove items from cart
* Calculate item totals
* Calculate cart total
* Prevent mixing items from different restaurants
* Change-restaurant confirmation flow

### 💳 Checkout & Orders

* Checkout page
* Display saved delivery address
* Select payment method
* Calculate delivery fee
* Calculate final order amount
* Place orders using database transactions
* Store order and order-item details

### 📦 Order History

* View previous orders
* View restaurant information
* View ordered food items
* View quantities and prices
* View delivery address
* View payment method
* View delivery fee
* View total order amount

---

## 🛠️ Technologies Used

| Technology         | Purpose                           |
| ------------------ | --------------------------------- |
| Java               | Backend programming               |
| JSP                | Dynamic web pages                 |
| Servlets           | Request handling and controllers  |
| JDBC               | Database connectivity             |
| MySQL              | Data storage                      |
| HTML5              | Page structure                    |
| CSS3               | User interface and styling        |
| Maven              | Dependency and project management |
| Apache Tomcat 10.1 | Web server                        |
| Eclipse            | Development environment           |
| JDK 21             | Java development                  |

---

## 🏗️ Project Architecture

QuickBite follows an MVC-style architecture.

```text
QuickBite
│
├── src/main/java
│   │
│   └── com.foodapp
│       │
│       ├── controller
│       │   ├── LoginServlet
│       │   ├── RegisterServlet
│       │   ├── ProfileServlet
│       │   ├── EditProfileServlet
│       │   ├── RestaurantServlet
│       │   ├── MenuServlet
│       │   ├── CartServlet
│       │   ├── CheckoutServlet
│       │   ├── OrderServlet
│       │   └── OrderHistoryServlet
│       │
│       ├── model
│       │   ├── User
│       │   ├── Restaurant
│       │   ├── Menu
│       │   ├── CartItem
│       │   ├── Order
│       │   ├── OrderItem
│       │   └── OrderHistoryItem
│       │
│       ├── DAO
│       │   ├── UserDAO
│       │   ├── RestaurantDAO
│       │   ├── MenuDAO
│       │   ├── OrderDAO
│       │   └── OrderItemDAO
│       │
│       ├── daoimpl
│       │   ├── UserDAOImpl
│       │   ├── RestaurantDAOImpl
│       │   ├── MenuDAOImpl
│       │   ├── OrderDAOImpl
│       │   └── OrderItemDAOImpl
│       │
│       └── util
│           └── DBConnection
│
├── src/main/webapp
│   │
│   ├── pages
│   │   ├── home.jsp
│   │   ├── restaurant.jsp
│   │   ├── menu.jsp
│   │   ├── cart.jsp
│   │   ├── checkout.jsp
│   │   ├── order-history.jsp
│   │   ├── profile.jsp
│   │   ├── edit-profile.jsp
│   │   ├── login.jsp
│   │   ├── register.jsp
│   │   ├── account.jsp
│   │   └── change-restaurant.jsp
│   │
│   └── css
│       ├── home.css
│       ├── restaurant.css
│       ├── menu.css
│       ├── cart.css
│       ├── checkout.css
│       ├── profile.css
│       ├── login.css
│       └── register.css
│
├── database
│   └── database.sql
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🔄 Application Flow

```text
User
 │
 ▼
Register / Login
 │
 ▼
Browse Restaurants
 │
 ▼
Select Restaurant
 │
 ▼
View Menu
 │
 ▼
Add Items to Cart
 │
 ▼
Checkout
 │
 ▼
Select Payment Method
 │
 ▼
Place Order
 │
 ▼
Order Saved in MySQL
 │
 ▼
Order History
```

---

## 🗄️ Database

QuickBite uses **MySQL** for persistent data storage.

The application contains tables for:

* Users
* Restaurants
* Menu items
* Orders
* Order items

Order information and order-item information are stored separately so that an order can contain multiple food items.

---

## 🔐 Database Configuration

Database credentials are **not hardcoded** in the source code.

`DBConnection.java` reads the database configuration from environment variables:

```java
System.getenv("QUICKBITE_DB_URL");
System.getenv("QUICKBITE_DB_USERNAME");
System.getenv("QUICKBITE_DB_PASSWORD");
```

Set these environment variables before running the application:

```text
QUICKBITE_DB_URL=jdbc:mysql://localhost:3306/quickbite2
QUICKBITE_DB_USERNAME=root
QUICKBITE_DB_PASSWORD=your_password
```

> Replace `your_password` with your local MySQL password.

---

## ▶️ How to Run

### 1. Prerequisites

Install:

* JDK 21
* Eclipse IDE
* Apache Tomcat 10.1
* MySQL Server
* Maven

### 2. Clone the Repository

```bash
git clone <your-github-repository-url>
```

### 3. Create the Database

Create the QuickBite database in MySQL and execute the SQL script provided in the `database` folder.

### 4. Configure Environment Variables

Set:

```text
QUICKBITE_DB_URL
QUICKBITE_DB_USERNAME
QUICKBITE_DB_PASSWORD
```

according to your local MySQL configuration.

### 5. Configure Tomcat

Add the project to Apache Tomcat 10.1 and start the server.

### 6. Run the Application

Open the application through the Tomcat server and register a new account.

---

## 🔒 Security Practices

The project includes:

* PreparedStatement for database queries
* Environment variables for database credentials
* BCrypt password hashing during registration
* Session-based user authentication
* Database transactions for order placement
* Rollback handling when order insertion fails

---

## 📸 Screenshots

### Home Page

*Add screenshot here*

### Restaurant Page

*Add screenshot here*

### Menu Page

*Add screenshot here*

### Cart

*Add screenshot here*

### Checkout

*Add screenshot here*

### Order History

*Add screenshot here*

### Profile

*Add screenshot here*

---

## 🚀 Future Enhancements

Possible future improvements include:

* Admin dashboard
* Restaurant management
* Menu management
* Online payment gateway integration
* Order status tracking
* Live delivery tracking
* Customer reviews and ratings
* Search and filtering
* Restaurant-wise offers
* Improved responsive design

---

## 👨‍💻 Developer

**Sampath Bollepalli**

B.Tech – Computer Science and Engineering
Software Engineer | Java Full Stack Developer

---

## 📄 License

This project was developed for learning, portfolio, and interview demonstration purposes.
