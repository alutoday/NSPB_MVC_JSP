<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.BEAN.phongbanBEAN" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách phòng ban</title>
</head>
<body>
    <h2>Danh sách phòng ban</h2>

    <%-- Hiển thị thông báo lỗi nếu có --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <table border="1">
        <thead>
            <tr>
                <th>IDPB</th>
                <th>Tên phòng ban</th>
                <th>Mô tả</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<phongbanBEAN> phongbans = (List<phongbanBEAN>) request.getAttribute("phongbans");
                if (phongbans != null) {
                    for (phongbanBEAN pb : phongbans) {
            %>
                        <tr>
                            <td><%= pb.getIdpb() %></td>
                            <td><%= pb.getTenpb() %></td>
                            <td><%= pb.getMota() %></td>
                            <td><a href="phongban?action=readNV&idpb=<%= pb.getIdpb() %>">Chi tiết</a></td>
                        </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>

    <br>
    <a href="phongban?action=readAll">Quay lại danh sách phòng ban</a>

</body>
</html>
