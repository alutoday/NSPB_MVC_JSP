<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="com.example.model.BEAN.nhanvienBEAN" %>
<% nhanvienBEAN nv = (nhanvienBEAN) request.getAttribute("nhanvien"); %>

<!DOCTYPE html>
<html>
  <head>
    <title>Chi tiết nhân viên</title>
  </head>
  <body>
    <h2>Chi tiết nhân viên</h2>
    <table border="1">
      <tr>
        <th>IDNV</th>
        <td><%= nv.getIdnv() %></td>
      </tr>
      <tr>
        <th>Họ tên</th>
        <td><%= nv.getHoten() %></td>
      </tr>
      <tr>
        <th>IDPB</th>
        <td><%= nv.getIdpb() %></td>
      </tr>
      <tr>
        <th>Địa chỉ</th>
        <td><%= nv.getDiachi() %></td>
      </tr>
    </table>
    <a href="admin">Trang chủ</a>
  </body>
  <br />
  <br />
  <form action="admin" method="get">
    <button type="submit">Trang chủ</button>
  </form>
</html>
