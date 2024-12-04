package com.example.model.DAO;

import com.example.model.BEAN.adminBEAN;
import com.example.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDAO {

    private adminBEAN executeQuery(adminBEAN ad, String sql) throws SQLException {
        adminBEAN resultAdmin = null;
        try (Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ad.getUsername());
            ps.setString(2, ad.getPassword());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    resultAdmin = new adminBEAN();
                    resultAdmin.setUsername(rs.getString("username"));
                    resultAdmin.setPassword(rs.getString("password"));
                }
            }
        }
        return resultAdmin;
    }

    // CREATE
    // READ
    public adminBEAN readAdmin(adminBEAN ad) throws SQLException {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
        return executeQuery(ad, query);
    }
    // UPDATE
    // DELETE
}
