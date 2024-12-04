<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Đăng Nhập</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }
      .login-container {
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 10px;
        background-color: #f9f9f9;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 350px;
      }
      .login-container h1 {
        text-align: center;
      }
      .login-container input {
        width: 90%;
        padding: 10px;
        margin: 10px 0px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }
      .button-container {
        text-align: center;
      }
      .login-container button {
        width: 50%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      .login-container button:hover {
        background-color: #0056b3;
      }
    </style>
  </head>
  <body>
    <div class="login-container">
      <h1>Đăng Nhập</h1>
      <form action="admin" method="post">
        <label for="username">Tài khoản:</label>
        <input type="text" id="username" name="username" required />
        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required />
        <div class="button-container">
          <button type="submit">Đăng nhập</button>
        </div>
      </form>
      <% if (request.getAttribute("error") != null) { %>
      <p style="color: red"><%= request.getAttribute("error") %></p>
      <% } %>
    </div>
  </body>
</html>
