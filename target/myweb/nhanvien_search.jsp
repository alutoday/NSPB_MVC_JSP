<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<html lang="vi">
  <head>
    <meta charset="UTF-8" />
    <title>Tìm Kiếm Nhân Viên</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  </head>
  <body>
    <form id="searchForm">
      <h2>Tìm Kiếm Thông Tin Nhân Viên</h2>
      <label
        ><input type="radio" name="searchType" value="idnv" checked />
        IDNV</label
      >
      <label
        ><input type="radio" name="searchType" value="hoten" /> Họ Tên</label
      >
      <label
        ><input type="radio" name="searchType" value="diachi" /> Địa Chỉ</label
      >
      <br /><br />
      <label>Nhập vào thông tin:</label>
      <input type="text" id="searchWord" required />
      <br /><br />
      <button type="submit">Tìm Kiếm</button>
      <button type="reset">Reset</button>
    </form>

    <hr />
    <div id="searchResults">
      <!-- Kết quả tìm kiếm sẽ hiển thị tại đây -->
    </div>

    <script>
      $(document).ready(function () {
        $("#searchForm").on("submit", function (event) {
          event.preventDefault();
          let searchType = $("input[name='searchType']:checked").val();
          let searchWord = $("#searchWord").val();

          $.ajax({
            url: "nhanvien?action=search",
            type: "GET",
            data: { searchType, searchWord },
            success: function (data) {
              $("#searchResults").html(data);
            },
            error: function (xhr, status, error) {
              alert("Lỗi: " + error);
            },
          });
        });
      });
    </script>
  </body>
</html>
