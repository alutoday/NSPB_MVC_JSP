package com.example.controller;

import com.example.model.BEAN.nhanvienBEAN;
import com.example.model.BO.nhanvienBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/nhanvien")
public class nhanvienController extends HttpServlet {
    private nhanvienBO nhanVienBO;

    @Override
    public void init() throws ServletException {
        nhanVienBO = new nhanvienBO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            System.out.println(action + "post");
            switch (action != null ? action : "readAll") {
                case "create":
                    createNhanVien(request, response);
                    break;
                case "update":
                    updateNhanVien(request, response);
                    break;
                case "delete":
                    deleteNhanVien(request, response);
                    break;
                case "deleteMultiple":
                    deleteMultipleNhanVien(request, response);
                    break;
                default:
                    response.sendRedirect("nhanvien?action=readAll");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi trong quá trình xử lý", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            System.out.println(action + "get");

            switch (action != null ? action : "readAll") {
                case "readAll":
                    readAllNhanVien(request, response);
                    break;
                case "readNV":
                    readNhanVien(request, response);
                    break;
                case "readPB":
                    readNhanVienPB(request, response);
                    break;
                case "search":
                    searchNhanVien(request, response);
                    break;
                case "checkIdnvExist":
                    checkIdnvExist(request, response);
                    break;
                case "create":
                    showCreateForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "deleteMultiple":
                    showDeleteMultipleForm(request, response);
                    break;
                default:
                    response.sendRedirect("nhanvien?action=readAll");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi trong quá trình xử lý", e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("nhanvien_create.jsp").forward(request, response);
    }

    private void createNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idnv = Integer.parseInt(request.getParameter("idnv"));

        String hoten = request.getParameter("hoten");
        int idpb = Integer.parseInt(request.getParameter("idpb"));
        String diachi = request.getParameter("diachi");

        nhanvienBEAN nv = new nhanvienBEAN();
        nv.setIdnv(idnv);
        nv.setHoten(hoten);
        nv.setIdpb(idpb);
        nv.setDiachi(diachi);

        nhanVienBO.createNhanVien(nv);
        response.sendRedirect("nhanvien?action=readAll");
    }

    private void readAllNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_readAll.jsp").forward(request, response);
    }

    private void readNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int idnv = Integer.parseInt(request.getParameter("idnv"));
        nhanvienBEAN nhanvien = nhanVienBO.readNhanVien(idnv);
        request.setAttribute("nhanvien", nhanvien);
        request.getRequestDispatcher("nhanvien_detail.jsp").forward(request, response);

    }

    private void checkIdnvExist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idnv = Integer.parseInt(request.getParameter("idnv"));
        nhanvienBEAN nhanvien = nhanVienBO.readNhanVien(idnv);
        System.out.println(idnv);
        if (nhanvien != null) {
            response.getWriter().write("exist");
        } else {
            response.getWriter().write("notExist");
        }
    }

    private void searchNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String searchType = request.getParameter("searchType");
        String searchWord = request.getParameter("searchWord");

        if (searchType == null || searchWord == null || searchType.isEmpty() || searchWord.isEmpty()) {
            request.getRequestDispatcher("nhanvien_search.jsp").forward(request, response);
            return;
        }

        List<nhanvienBEAN> searchResults = nhanVienBO.searchNhanVien(searchType, searchWord);
        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("nhanvien_search_result.jsp").forward(request, response);
    }

    private void readNhanVienPB(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int idpb = Integer.parseInt(request.getParameter("idpb"));
        List<nhanvienBEAN> nhanviens = nhanVienBO.readNhanVienPB(idpb);
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("phongban_detail.jsp").forward(request, response);

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_update.jsp").forward(request, response);
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idnv = Integer.parseInt(request.getParameter("idnv"));
        String hoten = request.getParameter("hoten");
        int idpb = Integer.parseInt(request.getParameter("idpb"));
        String diachi = request.getParameter("diachi");

        nhanvienBEAN nv = new nhanvienBEAN();
        nv.setIdnv(idnv);
        nv.setHoten(hoten);
        nv.setIdpb(idpb);
        nv.setDiachi(diachi);

        nhanVienBO.updateNhanVien(nv);

        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_update.jsp").forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_delete.jsp").forward(request, response);
    }

    private void showDeleteMultipleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_deleteMultiple.jsp").forward(request, response);
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String idnvStr = request.getParameter("idnv");
        if (idnvStr != null && !idnvStr.isEmpty()) {
            int idnv = Integer.parseInt(idnvStr);
            nhanVienBO.deleteNhanVien(idnv);
        }
        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_delete.jsp").forward(request, response);
    }

    private void deleteMultipleNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String[] idnvListStr = request.getParameterValues("idnvList");
        if (idnvListStr != null) {
            int[] idnvList = new int[idnvListStr.length];
            for (int i = 0; i < idnvListStr.length; i++) {
                idnvList[i] = Integer.parseInt(idnvListStr[i]);
            }
            nhanVienBO.deleteMultipleNhanVien(idnvList);
        }
        List<nhanvienBEAN> nhanviens = nhanVienBO.readAllNhanVien();
        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("nhanvien_deleteMultiple.jsp").forward(request, response);
    }
}
