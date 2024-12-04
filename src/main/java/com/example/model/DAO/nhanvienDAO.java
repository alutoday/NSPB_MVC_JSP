package com.example.model.DAO;

import com.example.model.BEAN.nhanvienBEAN;
import com.example.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class nhanvienDAO {

    private List<nhanvienBEAN> executeQuery(String sql, Object... params) throws SQLException {
        List<nhanvienBEAN> list = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    nhanvienBEAN nv = new nhanvienBEAN();
                    nv.setIdnv(rs.getInt("idnv"));
                    nv.setHoten(rs.getString("hoten"));
                    nv.setIdpb(rs.getInt("idpb"));
                    nv.setDiachi(rs.getString("diachi"));
                    list.add(nv);
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
    public void createNhanVien(nhanvienBEAN nv) throws SQLException {
        String query = "INSERT INTO nhanvien (idnv,hoten, idpb, diachi) VALUES (?,?, ?, ?)";
        executeNoQuery(query, nv.getIdnv(), nv.getHoten(), nv.getIdpb(), nv.getDiachi());
    }

    // READ
    public List<nhanvienBEAN> readAllNhanVien() throws SQLException {
        String query = "SELECT * FROM nhanvien";
        return executeQuery(query);
    }

    public List<nhanvienBEAN> readNhanVienPB(int idpb) throws SQLException {
        String query = "SELECT * FROM nhanvien WHERE idpb = ?";
        return executeQuery(query, idpb);
    }

    public nhanvienBEAN readNhanVien(int idnv) throws SQLException {
        String query = "SELECT * FROM nhanvien WHERE idnv = ?";
        List<nhanvienBEAN> list = executeQuery(query, idnv);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public List<nhanvienBEAN> searchNhanVien(String searchType, String searchWord) throws SQLException {
        String query = "SELECT * FROM nhanvien WHERE " + searchType + " LIKE ?";
        System.out.println("Executing query: " + query);
        return executeQuery(query, "%" + searchWord + "%");
    }

    // UPDATE
    public void updateNhanVien(nhanvienBEAN nv) throws SQLException {
        String query = "UPDATE nhanvien SET hoten = ?, idpb = ?, diachi = ? WHERE idnv = ?";
        executeNoQuery(query, nv.getHoten(), nv.getIdpb(), nv.getDiachi(), nv.getIdnv());
    }

    // DELETE
    public void deleteNhanVien(int idnv) throws SQLException {
        String query = "DELETE FROM nhanvien WHERE idnv = ?";
        executeNoQuery(query, idnv);
    }

    public void deleteMultipleNhanVien(int[] idnvList) throws SQLException {
        String query = "DELETE FROM nhanvien WHERE idnv = ?";
        try (Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {

            for (int idnv : idnvList) {
                ps.setInt(1, idnv);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
}
