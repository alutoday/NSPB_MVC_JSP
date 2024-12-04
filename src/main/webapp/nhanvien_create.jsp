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
      <input
        type="number"
        id="idnv"
        name="idnv"
        required
        onblur="checkIdnvExist()"
      />
      <span id="idnvMessage"></span>
      <br /><br />
      <label for="hoten">Họ tên:</label>
      <input type="text" id="hoten" name="hoten" required /><br /><br />
      <label for="idpb">IDPB:</label>
      <input type="number" id="idpb" name="idpb" required /><br /><br />
      <label for="diachi">Địa chỉ:</label>
      <input type="text" id="diachi" name="diachi" required /><br /><br />
      <input type="submit" value="Save" />
    </form>
    <br />
    <br />
    <form action="admin" method="get">
      <button type="submit">Trang chủ</button>
    </form>
  </body>
</html>
<script>
  function checkIdnvExist() {
    var idnv = document.getElementById("idnv").value;

    if (idnv) {
      var xhr = new XMLHttpRequest();
      xhr.open("GET", "nhanvien?action=checkIdnvExist&idnv=" + idnv, true);
      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
          var response = xhr.responseText;
          var message = document.getElementById("idnvMessage");
          if (response === "exist") {
            message.textContent = "ID nhân viên đã tồn tại!";
            message.style.color = "red";
          } else {
            message.textContent = "";
          }
        }
      };
      xhr.send();
    }
  }
</script>
