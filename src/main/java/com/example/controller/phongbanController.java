package com.example.controller;

import com.example.model.BEAN.phongbanBEAN;
import com.example.model.BEAN.nhanvienBEAN;
import com.example.model.BO.phongbanBO;
import com.example.model.BO.nhanvienBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/phongban")
public class phongbanController extends HttpServlet {
    private phongbanBO pbBO;
    private nhanvienBO nvBO;

    @Override
    public void init() throws ServletException {
        pbBO = new phongbanBO();
        nvBO = new nhanvienBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            System.out.println(action + "getPB");
            switch (action != null ? action : "readAll") {
                case "readAll":
                    readAllPhongBan(request, response);
                    break;
                case "readNV":
                    readPhongBanNV(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                default:
                    response.sendRedirect("phongban?action=readAll");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi trong quá trình xử lý", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        try {
            System.out.println(action + "postPB");
            switch (action != null ? action : "readAll") {

                case "update":
                    updatePhongBan(request, response);
                    break;
                default:
                    response.sendRedirect("phongban?action=readAll");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi trong quá trình xử lý", e);
        }
    }

    private void readAllPhongBan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<phongbanBEAN> phongbans = pbBO.readAllPhongBan();
        request.setAttribute("phongbans", phongbans);
        request.getRequestDispatcher("phongban_readAll.jsp").forward(request, response);
    }

    private void readPhongBanNV(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        nvBO = new nhanvienBO();
        int idpb = Integer.parseInt(request.getParameter("idpb"));
        List<nhanvienBEAN> nhanviens = nvBO.readNhanVienPB(idpb);

        request.setAttribute("nhanviens", nhanviens);
        request.getRequestDispatcher("phongban_detail.jsp").forward(request, response);
    }

    // private void readPhongBan(HttpServletRequest request, HttpServletResponse
    // response)
    // throws SQLException, ServletException, IOException {

    // int idpb = Integer.parseInt(request.getParameter("idpb"));
    // phongbanBEAN phongban = pbBO.readPhongBan(idpb);
    // request.setAttribute("phongban", phongban);
    // request.getRequestDispatcher("phongban_updateform.jsp").forward(request,
    // response);

    // }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String idpbStr = request.getParameter("idpb");
        if (idpbStr == null || idpbStr.isEmpty()) {
            List<phongbanBEAN> phongbans = pbBO.readAllPhongBan();
            request.setAttribute("phongbans", phongbans);
            request.getRequestDispatcher("phongban_update.jsp").forward(request, response);
            return;
        }

        try {
            int idpb = Integer.parseInt(idpbStr); // Chuyển đổi idpb sang kiểu int
            System.out.println(idpb + "Vô đây rồi nè=))");
            phongbanBEAN phongban = pbBO.readPhongBan(idpb); // Lấy phòng ban theo idpb
            request.setAttribute("phongban", phongban); // Đưa dữ liệu phòng ban vào request
            request.getRequestDispatcher("phongban_updateform.jsp").forward(request, response); // Chuyển hướng đến
                                                                                                // trang cập nhật
        } catch (NumberFormatException e) {
            // Nếu idpb không thể chuyển thành int, chuyển hướng về trang danh sách
            response.sendRedirect("phongban?action=readAll");
        }
    }

    private void updatePhongBan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idpb = Integer.parseInt(request.getParameter("idpb"));
        String tenpb = request.getParameter("tenpb");
        String mota = request.getParameter("mota");

        phongbanBEAN pb = new phongbanBEAN();
        pb.setIdpb(idpb);
        pb.setTenpb(tenpb);
        pb.setMota(mota);

        pbBO.updatePhongBan(pb);
        response.sendRedirect("phongban?action=readAll");
    }
}
