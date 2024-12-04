package com.example.model.BO;

import com.example.model.BEAN.nhanvienBEAN;
import com.example.model.DAO.nhanvienDAO;
import java.sql.*;
import java.util.List;

public class nhanvienBO {
    private nhanvienDAO dao = new nhanvienDAO();

    // CREATE
    public void createNhanVien(nhanvienBEAN nv) throws SQLException {
        dao.createNhanVien(nv);
    }

    // READ
    public List<nhanvienBEAN> readAllNhanVien() throws SQLException {
        return dao.readAllNhanVien();
    }

    public nhanvienBEAN readNhanVien(int idnv) throws SQLException {
        return dao.readNhanVien(idnv);
    }

    public List<nhanvienBEAN> readNhanVienPB(int idpb) throws SQLException {
        return dao.readNhanVienPB(idpb);
    }

    public List<nhanvienBEAN> searchNhanVien(String searchType, String searchWord) throws SQLException {
        return dao.searchNhanVien(searchType, searchWord);
    }

    // UPDATE
    public void updateNhanVien(nhanvienBEAN nv) throws SQLException {
        dao.updateNhanVien(nv);
    }

    // DELETE
    public void deleteNhanVien(int idnv) throws SQLException {
        dao.deleteNhanVien(idnv);
    }

    public void deleteMultipleNhanVien(int[] idnvList) throws SQLException {
        dao.deleteMultipleNhanVien(idnvList);
    }
}
