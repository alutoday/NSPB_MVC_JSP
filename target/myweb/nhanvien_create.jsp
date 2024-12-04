<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Thêm nhân viên</title>
  </head>
  <body>
    <h2>Thêm nhân viên mới</h2>
    <form action="nhanvien?action=create" method="post">
      <label for="idnv">IDNV:</label>
      <input type="number" id="idnv" name="idnv" required /><br /><br />
      <label for="hoten">Họ tên:</label>
      <input type="text" id="hoten" name="hoten" required /><br /><br />
      <label for="idpb">IDPB:</label>
      <input type="number" id="idpb" name="idpb" required /><br /><br />
      <label for="diachi">Địa chỉ:</label>
      <input type="text" id="diachi" name="diachi" required /><br /><br />
      <input type="submit" value="Save" />
    </form>
  </body>
</html>
