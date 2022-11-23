package com.api.rentalcar.services;

import com.api.rentalcar.repositories.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionCreator {
    public static String dbURL = "jdbc:postgresql://localhost:5432/carrental";
    public static String dbUser = "garsoft";
    public static String dbUserPwd = "garsoft";

    public static void createConnection() {
        Properties dbInfo = new Properties();
        dbInfo.put("dbUrl", dbURL);
        dbInfo.put("dbUser", dbUser);
        dbInfo.put("dbUserPwd", dbUserPwd);
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(dbInfo.getProperty("dbUrl"), dbInfo.getProperty("dbUser"), dbInfo.getProperty("dbUserPwd"));
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            System.out.println("Could not connect to database" + e.toString());
        }

        Repository.databaseConn = conn;
    }

}
