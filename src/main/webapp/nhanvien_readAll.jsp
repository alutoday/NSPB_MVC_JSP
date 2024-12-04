<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.BEAN.nhanvienBEAN" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
    <h2>Danh sách nhân viên</h2>
    <%-- Hiển thị thông báo lỗi nếu có --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <table border="1">
        <thead>
            <tr>
                <th>IDNV</th>
                <th>Họ tên</th>
                <th>IDPB</th>
                <th>Địa chỉ</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<nhanvienBEAN> nhanviens = (List<nhanvienBEAN>) request.getAttribute("nhanviens");
                if (nhanviens != null) {
                    for (nhanvienBEAN nv : nhanviens) {
            %>
                        <tr>
                            <td><%= nv.getIdnv() %></td>
                            <td><%= nv.getHoten() %></td>
                            <td><%= nv.getIdpb() %></td>
                            <td><%= nv.getDiachi() %></td> 
                            <td><a href="nhanvien?action=readNV&idnv=<%= nv.getIdnv() %>">Chi tiết</a></td>                          
                        </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <br /> <br/>
    <form action="admin" method="get">
        <button type="submit">Trang chủ</button>
      </form>
</body>
</html>
