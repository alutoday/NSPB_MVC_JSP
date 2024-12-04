package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLyNhanSu?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
