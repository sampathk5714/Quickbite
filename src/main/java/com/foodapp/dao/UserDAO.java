package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.User;

public interface UserDAO {

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int userID);

    User getUserByID(int userID);

    List<User> getAllUsers();

    User getUserByEmail(String email);
}