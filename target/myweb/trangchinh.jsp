<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Trang Chính</title>
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
        background-color: #28a745;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        cursor: pointer;
      }
      .button:hover {
        background-color: #218838;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Quản Trị Viên</h1>
      <p>Hệ thống quản lí nhân sự phòng ban</p>
      <a href="nhanvien?action=readAll" class="button"
        >Xem thông tin nhân viên
      </a>
      <a href="phongban?action=readAll" class="button"
        >Xem thông tin phòng ban</a
      >
      <a href="nhanvien?action=search" class="button">Tìm kiếm nhân viên</a>
      <a href="nhanvien?action=delete" class="button">Xóa nhân viên</a>
      <a href="nhanvien?action=deleteMultiple" class="button"
        >Xóa nhiều nhân viên</a
      >
      <a href="phongban?action=update" class="button">Cập nhật phòng ban</a>
      <a href="nhanvien?action=create" class="button">Thêm nhân viên</a>
    </div>
  </body>
</html>
