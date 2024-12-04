<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<table border="1">
  <tr>
    <th>IDNV</th>
    <th>Họ Tên</th>
    <th>Địa Chỉ</th>
  </tr>
  <c:forEach items="${searchResults}" var="nv">
    <tr>
      <td>${nv.idnv}</td>
      <td>${nv.hoten}</td>
      <td>${nv.diachi}</td>
    </tr>
  </c:forEach>
</table>
