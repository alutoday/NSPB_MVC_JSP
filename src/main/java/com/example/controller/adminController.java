package com.example.controller;

import com.example.model.BEAN.adminBEAN;
import com.example.model.BO.adminBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin")
public class adminController extends HttpServlet {
    private adminBO bo = new adminBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        adminBEAN bean = new adminBEAN();
        bean.setUsername(username);
        bean.setPassword(password);

        try {
            if (bo.readAdmin(bean) != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("trangchinh.jsp"); // Redirect to home page
            } else {
                request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi trong quá trình xử lý đăng nhập", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("trangkhach.jsp");
        } else {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
                response.sendRedirect("trangchinh.jsp");
            } else {
                response.sendRedirect("trangkhach.jsp");
            }
        }
    }
}
