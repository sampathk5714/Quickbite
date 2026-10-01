package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;
import com.foodapp.util.DBConnection;

public class UserDAOImpl implements UserDAO {
	
	private static final String ADD_USER =
	        "INSERT INTO users " +
	        "(name, email, phoneNumber, password, address) " +
	        "VALUES (?, ?, ?, ?, ?)";

	private static final String UPDATE_USER =
	        "UPDATE users SET name=?, email=?, phoneNumber=?, address=? WHERE userID=?";
    private static final String DELETE_USER =
            "DELETE FROM users WHERE userID=?";

    private static final String GET_USER_BY_ID =
            "SELECT * FROM users WHERE userID=?";

    private static final String GET_ALL_USERS =
            "SELECT * FROM users";

    private static final String GET_USER_BY_EMAIL =
            "SELECT * FROM users WHERE email=?";

    private Connection connection;

    public UserDAOImpl() {
        connection = DBConnection.getConnection();
    }
    
    @Override
    public int addUser(User user) {

        try (PreparedStatement ps =
                     connection.prepareStatement(ADD_USER)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhoneNumber());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAddress());

            return ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Error while adding user", e);
        }
    }

    @Override
    public int updateUser(User user) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(UPDATE_USER)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(4, user.getAddress());
            pstmt.setInt(5, user.getUserID());

            return pstmt.executeUpdate();

        } catch (SQLException e) {

            if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
                return -1;
            }

            throw new RuntimeException(
                    "Failed to update user.", e);
        }
    }

    @Override
    public int deleteUser(int userID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(DELETE_USER)) {

            pstmt.setInt(1, userID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete user.", e);
        }
    }

    @Override
    public User getUserByID(int userID) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_USER_BY_ID)) {

            pstmt.setInt(1, userID);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return extractUser(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch user.", e);
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_ALL_USERS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                userList.add(extractUser(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch users.", e);
        }

        return userList;
    }

    @Override
    public User getUserByEmail(String email) {

        try (PreparedStatement pstmt =
                     connection.prepareStatement(GET_USER_BY_EMAIL)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    return extractUser(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch user by email.", e);
        }

        return null;
    }

    private User extractUser(ResultSet rs) throws SQLException {

        User user = new User();

        user.setUserID(rs.getInt("userID"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setCreatedAt(rs.getTimestamp("createdAt"));

        return user;
    }
}