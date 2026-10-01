package com.foodapp.test;

import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;

public class TestRestaurantDAO {

    public static void main(String[] args) {

        RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

        // Test: Get all restaurants
        List<Restaurant> restaurants =
                restaurantDAO.getAllRestaurants();

        for (Restaurant restaurant : restaurants) {

            System.out.println(restaurant);
        }
    }
}