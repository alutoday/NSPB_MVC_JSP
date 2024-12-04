<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.BEAN.nhanvienBEAN" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết phòng ban</title>
</head>
<body>
    <h2>Chi tiết phòng ban</h2>

    <%
        // Lấy thông tin nhân viên từ request
        List<nhanvienBEAN> nhanviens = 
            (List<nhanvienBEAN>) request.getAttribute("nhanviens");

        if (nhanviens != null && !nhanviens.isEmpty()) {
    %>
        <h3>Danh sách nhân viên trong phòng ban</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>IDNV</th>
                    <th>Họ tên</th>
                    <th>IDPB</th>
                    <th>Địa chỉ</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (nhanvienBEAN nv : nhanviens) {
                %>
                        <tr>
                            <td><%= nv.getIdnv() %></td>
                            <td><%= nv.getHoten() %></td>
                            <td><%= nv.getIdpb() %></td>
                            <td><%= nv.getDiachi() %></td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <% 
        } else {
    %>
        <p>Không có nhân viên nào trong phòng ban này.</p>
    <% 
        }
    %>

    <br /> <br/>
    <form action="admin" method="get">
        <button type="submit">Trang chủ</button>
      </form>
</body>
</html>
