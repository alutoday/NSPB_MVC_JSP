package com.example.model.BO;

import com.example.model.BEAN.adminBEAN;
import com.example.model.DAO.adminDAO;

import java.sql.*;

public class adminBO {

    private adminDAO dao = new adminDAO();

    // CREATE
    // READ

    public adminBEAN readAdmin(adminBEAN ad) throws SQLException {
        return dao.readAdmin(ad);
    }
    // UPDATE
    // DELETE

}
