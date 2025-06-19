<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Danh sách sinh viên</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Họ và tên</th>
                <th>Năm sinh</th>
                <th>Điểm trung bình</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through students -->
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.fullName}</td>
                    <td>${student.birthYear}</td>
                    <td>${student.gpa}</td>
                    <td>
                        <a href="editStudent.jsp?id=${student.id}">Sửa</a>
                        <a href="student?action=deleteStudent&id=${student.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Thêm sinh viên mới</h2>
    <form action="student?action=addStudent" method="post">
        Họ và tên: <input type="text" name="fullName"><br>
        Năm sinh: <input type="number" name="birthYear"><br>
        Điểm trung bình: <input type="number" step="0.01" name="gpa"><br>
        <input type="submit" value="Thêm sinh viên">
    </form>
</body>
</html>