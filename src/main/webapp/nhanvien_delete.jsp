<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.BEAN.nhanvienBEAN" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xoá nhân viên</title>
</head>
<body>
    <h2>Xoá nhân viên</h2>
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
                    <td>
                        <form action="nhanvien?action=delete" method="post">
                            <input type="hidden" name="idnv" value="<%= nv.getIdnv() %>" />
                            <button type="submit">Xoá</button>
                        </form>
                    </td>
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