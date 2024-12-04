<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="com.example.model.BEAN.phongbanBEAN" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Cập nhật phòng ban</title>
  </head>
  <body>
    <h2>Cập nhật phòng ban</h2>

    <% phongbanBEAN phongban = (phongbanBEAN) request.getAttribute("phongban");
    %>

    <form action="phongban?action=update" method="post">
      IDPB :
      <input
        type="text"
        name="idpb"
        value="<%= phongban.getIdpb() %>"
        readonly
      />
      <br />

      <label for="tenpb">Tên phòng ban:</label>
      <input
        type="text"
        id="tenpb"
        name="tenpb"
        value="<%= phongban.getTenpb() %>"
        required
      /><br /><br />

      <label for="mota">Mô tả:</label>
      <textarea id="mota" name="mota" rows="1" cols="50" required>
        <%= phongban.getMota() %>
      </textarea
      ><br /><br />

      <button type="submit">Cập nhật</button>
    </form>

    <br />
    <form action="admin" method="get">
      <button type="submit">Trang chủ</button>
    </form>
  </body>
</html>
