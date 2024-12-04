<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Trang Khách</title>
    <style>
      body {
        font-family: Arial, sans-serif;
      }
      .container {
        text-align: center;
        margin-top: 50px;
      }
      .button {
        display: inline-block;
        margin: 10px;
        padding: 15px 30px;
        font-size: 16px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        cursor: pointer;
      }
      .button:hover {
        background-color: #0056b3;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <p>Hệ thống quản lý nhân sự phòng ban.</p>
      <a href="nhanvien?action=readAll" class="button"
        >Xem thông tin nhân viên</a
      >
      <a href="phongban?action=readAll" class="button"
        >Xem thông tin phòng ban</a
      >
      <a href="nhanvien?action=search" class="button">Tìm kiếm nhân viên</a>
      <a href="login.jsp" class="button">Đăng nhập</a>
    </div>
  </body>
</html>
