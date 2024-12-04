<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.BEAN.phongbanBEAN" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật phòng ban</title>
</head>
<body>
    <h2>Cập nhật phòng ban</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <table border="1">
        <thead>
            <tr>
                <th>IDPB</th>
                <th>Tên Phòng ban</th>
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
                    <td><a href="phongban?action=update&idpb=<%= pb.getIdpb() %>">Cập nhật</a></td>                          
                    
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
