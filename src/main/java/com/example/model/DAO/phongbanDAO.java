package com.example.model.DAO;

import com.example.model.BEAN.phongbanBEAN;
import com.example.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class phongbanDAO {

    private List<phongbanBEAN> executeQuery(String sql, Object... params) throws SQLException {
        List<phongbanBEAN> list = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    phongbanBEAN pb = new phongbanBEAN();
                    pb.setIdpb(rs.getInt("idpb"));
                    pb.setTenpb(rs.getString("tenpb"));
                    pb.setMota(rs.getString("mota"));
                    list.add(pb);
                }
            }
        }
        return list;
    }

    private void executeNoQuery(String sql, Object... params) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ps.executeUpdate();
        }
    }

    // CREATE

    // READ
    public List<phongbanBEAN> readAllPhongBan() throws SQLException {
        String query = "SELECT * FROM phongban";
        return executeQuery(query);
    }

    public phongbanBEAN readPhongBan(int idpb) throws SQLException {
        String query = "SELECT * FROM phongban WHERE idpb = ?";
        List<phongbanBEAN> list = new ArrayList<phongbanBEAN>();
        list = executeQuery(query, idpb);
        if (list.size() > 0)
            return list.getFirst();
        else
            return null;
    }

    // UPDATE
    public void updatePhongBan(phongbanBEAN pb) throws SQLException {
        String query = "UPDATE phongban SET tenpb = ?, mota = ? WHERE idpb = ?";
        executeNoQuery(query, pb.getTenpb(), pb.getMota(), pb.getIdpb());
    }

    // DELETE

}
