package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Menu;

public interface MenuDAO {

    int addMenu(Menu menu);

    int updateMenu(Menu menu);

    int deleteMenu(int menuID);

    Menu getMenuByID(int menuID);

    List<Menu> getAllMenus();

    List<Menu> getMenusByRestaurantID(int restaurantID);

    List<Menu> getAvailableMenusByRestaurantID(int restaurantID);
}