package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;
import com.foodapp.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {

    private static final String ADD_MENU =
            "INSERT INTO menu " +
            "(restaurantID, itemName, description, category, price, imagePath, isAvailable) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_MENU =
            "UPDATE menu SET restaurantID=?, itemName=?, description=?, " +
            "category=?, price=?, imagePath=?, isAvailable=? " +
            "WHERE menuID=?";

    private static final String DELETE_MENU =
            "DELETE FROM menu WHERE menuID=?";

    private static final String GET_MENU_BY_ID =
            "SELECT * FROM menu WHERE menuID=?";

    private static final String GET_ALL_MENUS =
            "SELECT * FROM menu";

    private static final String GET_MENUS_BY_RESTAURANT_ID =
            "SELECT * FROM menu WHERE restaurantID=?";

    private static final String GET_AVAILABLE_MENUS_BY_RESTAURANT_ID =
            "SELECT * FROM menu WHERE restaurantID=? AND isAvailable=true";

    private Connection connection;

    public MenuDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public int addMenu(Menu menu) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(ADD_MENU)) {

            pstmt.setInt(1, menu.getRestaurantID());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setString(4, menu.getCategory());
            pstmt.setDouble(5, menu.getPrice());
            pstmt.setString(6, menu.getImagePath());
            pstmt.setBoolean(7, menu.isAvailable());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException("Failed to add menu.", e);
        }
    }

    @Override
    public int updateMenu(Menu menu) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(UPDATE_MENU)) {

            pstmt.setInt(1, menu.getRestaurantID());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setString(4, menu.getCategory());
            pstmt.setDouble(5, menu.getPrice());
            pstmt.setString(6, menu.getImagePath());
            pstmt.setBoolean(7, menu.isAvailable());
            pstmt.setInt(8, menu.getMenuID());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException("Failed to update menu.", e);
        }
    }

    @Override
    public int deleteMenu(int menuID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(DELETE_MENU)) {

            pstmt.setInt(1, menuID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException("Failed to delete menu.", e);
        }
    }

    @Override
    public Menu getMenuByID(int menuID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_MENU_BY_ID)) {

            pstmt.setInt(1, menuID);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return extractMenu(rs);
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException("Failed to fetch menu.", e);
        }

        return null;
    }

    @Override
    public List<Menu> getAllMenus() {

        List<Menu> menuList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ALL_MENUS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                menuList.add(extractMenu(rs));
            }

        } catch (SQLException e) {

            throw new RuntimeException("Failed to fetch menus.", e);
        }

        return menuList;
    }

    @Override
    public List<Menu> getMenusByRestaurantID(int restaurantID) {

        List<Menu> menuList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(
                             GET_MENUS_BY_RESTAURANT_ID)) {

            pstmt.setInt(1, restaurantID);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    menuList.add(extractMenu(rs));
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch restaurant menus.", e);
        }

        return menuList;
    }

    @Override
    public List<Menu> getAvailableMenusByRestaurantID(int restaurantID) {

        List<Menu> menuList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(
                             GET_AVAILABLE_MENUS_BY_RESTAURANT_ID)) {

            pstmt.setInt(1, restaurantID);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    menuList.add(extractMenu(rs));
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to fetch available menus.", e);
        }

        return menuList;
    }

    private Menu extractMenu(ResultSet rs)
            throws SQLException {

        Menu menu = new Menu();

        menu.setMenuID(
                rs.getInt("menuID"));

        menu.setRestaurantID(
                rs.getInt("restaurantID"));

        menu.setItemName(
                rs.getString("itemName"));

        menu.setDescription(
                rs.getString("description"));

        menu.setCategory(
                rs.getString("category"));

        menu.setPrice(
                rs.getDouble("price"));

        menu.setImagePath(
                rs.getString("imagePath"));

        menu.setAvailable(
                rs.getBoolean("isAvailable"));

        return menu;
    }
}