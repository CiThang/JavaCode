<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <script>
	 function addRow() {
	     // Lấy dữ liệu từ bảng thứ nhất
	     var id = document.getElementById("id").value;
	     var name = document.getElementById("name").value;

	     // Tạo một dòng mới trong bảng thứ hai
	     var table = document.getElementById("data-table");
	     var row = table.insertRow(-1);
	     var cell1 = row.insertCell(0);
	     var cell2 = row.insertCell(1);
	     cell1.innerHTML = "<td  name='ID'>"+id+"</td>";
	     cell2.innerHTML = "<td  name='NAME'>"+name+"</td>";}
    </script>
</head>
<body>
	<h1>Hello</h1>


	<h2>Form 1: Enter User Details</h2>
	<form action="LearnProProduct" method="post">
		<label for="userId">User ID: </label>
		<input type="text" id="userId" name="userId"><br><br>
		<label for="username">Username: </label>
		<input type="text" id="username" name="username"><br><br>
		<label for="email">Email:</label>
		<input type="text" id="email" name="email"><br><br>
		<input type="submit" value="Submit Form 1">
	</form>
	
	<h2>Form 2: Enter Product Details</h2>
	<h2>Enter User Details in the Table</h2>
    <form action="LearnProUser" method="post">
        <table border="1">
            <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>Email</th>
            </tr>
            <tr>
                <td><input type="text" name="userIdd"></td>
                <td><input type="text" name="username"></td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><input type="text" name="userIdd"></td>
                <td><input type="text" name="username"></td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><input type="text" name="userIdd"></td>
                <td><input type="text" name="username"></td>
                <td><input type="text" name="email"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Submit">
    </form>

     <h2>Add Data</h2>
     Bảng thứ nhất 
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" id="id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" id="name"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="button" onclick="addRow()">Add</button></td>
        </tr>
    </table>
    
    <!-- Bảng thứ hai -->
    <h3>Data Table</h3>
    <form id="data-form" action="AddRow" method="post">
        <table id="data-table" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <!-- Dữ liệu sẽ được thêm vào đây -->
            </tbody>
        </table>
        <br>
        <!-- Nút Submit -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>



