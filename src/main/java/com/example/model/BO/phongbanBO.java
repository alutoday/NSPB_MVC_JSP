package com.example.model.BO;

import com.example.model.BEAN.phongbanBEAN;
import com.example.model.DAO.phongbanDAO;
import java.sql.*;
import java.util.List;

public class phongbanBO {
    private phongbanDAO dao = new phongbanDAO();

    // CREATE
    // READ
    public List<phongbanBEAN> readAllPhongBan() throws SQLException {
        return dao.readAllPhongBan();
    }

    public phongbanBEAN readPhongBan(int idpb) throws SQLException {
        return dao.readPhongBan(idpb);
    }

    // UPDATE
    public void updatePhongBan(phongbanBEAN pb) throws SQLException {
        dao.updatePhongBan(pb);
    }
    // DELETE
}
