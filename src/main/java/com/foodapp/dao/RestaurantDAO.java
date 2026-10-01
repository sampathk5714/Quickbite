package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Restaurant;

public interface RestaurantDAO {

    int addRestaurant(Restaurant restaurant);

    int updateRestaurant(Restaurant restaurant);

    int deleteRestaurant(int restaurantID);

    Restaurant getRestaurantByID(int restaurantID);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getActiveRestaurants();
}