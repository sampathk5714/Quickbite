package com.foodapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            System.getenv("QUICKBITE_DB_URL");

    private static final String USERNAME =
            System.getenv("QUICKBITE_DB_USERNAME");

    private static final String PASSWORD =
            System.getenv("QUICKBITE_DB_PASSWORD");

    private static Connection connection;

    // Private constructor to prevent object creation
    private DBConnection() {

    }

    // Returns database connection
    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                
             
                connection = DriverManager.getConnection(
                        URL,
                        USERNAME,
                        PASSWORD
                );

                System.out.println(
                        "Database Connected Successfully"
                );
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        return connection;
    }
}