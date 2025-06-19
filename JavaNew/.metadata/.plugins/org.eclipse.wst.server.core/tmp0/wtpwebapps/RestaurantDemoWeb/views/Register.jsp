<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f9f9f9;
    }

    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .back-to-home {
        position: absolute;
        top: 20px;
        right: 20px;
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
    }

    .back-to-home:hover {
        background-color: #45a049;
    }
    a {
        color: #4CAF50;
        text-decoration: none;
        display: block;
        text-align: center;
        margin-top: 10px;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
  <a href="RestaurantOrder" class="back-to-home">Home</a>
   
    <form action="Register" method="post">
     <h2>Register</h2>
        Name : <input type="text" name="cusName"><br>
        Email : <input type="text" name="cusEmail"><br>
        Password : <input type="password" name="passWord"><br>
        ConfirmPass : <input type="password" name = "confirmPass"><br>
        <a href="Login">Login</a>
        <input type="submit" value="Register">
    </form>
</body>
</html>
