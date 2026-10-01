 package com.foodapp.test;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {

    public static void main(String[] args) {

    	String password = "123456";

    	String hashedPassword =
    	        BCrypt.hashpw(password, BCrypt.gensalt());

    	System.out.println(hashedPassword);
    }
}