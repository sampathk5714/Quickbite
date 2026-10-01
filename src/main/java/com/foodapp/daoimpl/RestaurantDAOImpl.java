package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.model.Restaurant;
import com.foodapp.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    private static final String ADD_RESTAURANT =
            "INSERT INTO restaurants " +
            "(restaurantName, cuisineType, address, rating, deliveryTime, imagePath, isActive, offer, deliveryFee) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_RESTAURANT =
            "UPDATE restaurants SET restaurantName=?, cuisineType=?, address=?, " +
            "rating=?, deliveryTime=?, imagePath=?, isActive=?, offer=?, deliveryFee=? " +
            "WHERE restaurantID=?";

    private static final String DELETE_RESTAURANT =
            "DELETE FROM restaurants WHERE restaurantID=?";

    private static final String GET_RESTAURANT_BY_ID =
            "SELECT * FROM restaurants WHERE restaurantID=?";

    private static final String GET_ALL_RESTAURANTS =
            "SELECT * FROM restaurants";

    private static final String GET_ACTIVE_RESTAURANTS =
            "SELECT * FROM restaurants WHERE isActive=true";

    private Connection connection;

    public RestaurantDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public int addRestaurant(Restaurant restaurant) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(ADD_RESTAURANT)) {

            pstmt.setString(1, restaurant.getRestaurantName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setDouble(4, restaurant.getRating());
            pstmt.setInt(5, restaurant.getDeliveryTime());
            pstmt.setString(6, restaurant.getImagePath());
            pstmt.setBoolean(7, restaurant.isActive());
            pstmt.setString(8, restaurant.getOffer());
            pstmt.setDouble(9, restaurant.getDeliveryFee());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException("Failed to add restaurant.", e);
        }
    }

    @Override
    public int updateRestaurant(Restaurant restaurant) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(UPDATE_RESTAURANT)) {

            pstmt.setString(1, restaurant.getRestaurantName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setDouble(4, restaurant.getRating());
            pstmt.setInt(5, restaurant.getDeliveryTime());
            pstmt.setString(6, restaurant.getImagePath());
            pstmt.setBoolean(7, restaurant.isActive());
            pstmt.setString(8, restaurant.getOffer());
            pstmt.setDouble(9, restaurant.getDeliveryFee());
            pstmt.setInt(10, restaurant.getRestaurantID());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException("Failed to update restaurant.", e);
        }
    }

    @Override
    public int deleteRestaurant(int restaurantID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(DELETE_RESTAURANT)) {

            pstmt.setInt(1, restaurantID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException("Failed to delete restaurant.", e);
        }
    }

    @Override
    public Restaurant getRestaurantByID(int restaurantID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_RESTAURANT_BY_ID)) {

            pstmt.setInt(1, restaurantID);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return extractRestaurant(rs);
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException("Failed to fetch restaurant.", e);
        }

        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> restaurantList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ALL_RESTAURANTS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                restaurantList.add(extractRestaurant(rs));
            }

        } catch (SQLException e) {

            throw new RuntimeException("Failed to fetch restaurants.", e);
        }

        return restaurantList;
    }

    @Override
    public List<Restaurant> getActiveRestaurants() {

        List<Restaurant> restaurantList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ACTIVE_RESTAURANTS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                restaurantList.add(extractRestaurant(rs));
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch active restaurants.", e);
        }

        return restaurantList;
    }

    private Restaurant extractRestaurant(ResultSet rs)
            throws SQLException {

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantID(
                rs.getInt("restaurantID"));

        restaurant.setRestaurantName(
                rs.getString("restaurantName"));

        restaurant.setCuisineType(
                rs.getString("cuisineType"));

        restaurant.setAddress(
                rs.getString("address"));

        restaurant.setRating(
                rs.getDouble("rating"));

        restaurant.setDeliveryTime(
                rs.getInt("deliveryTime"));

        restaurant.setImagePath(
                rs.getString("imagePath"));

        restaurant.setActive(
                rs.getBoolean("isActive"));

        restaurant.setOffer(
                rs.getString("offer"));

        restaurant.setDeliveryFee(
                rs.getDouble("deliveryFee"));

        return restaurant;
    }
}