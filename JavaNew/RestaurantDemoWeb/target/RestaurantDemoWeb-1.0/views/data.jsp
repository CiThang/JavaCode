<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table id="myTable">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <tr>
            <td>1</td>
            <td>John</td>
            <td>25</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Jane</td>
            <td>30</td>
        </tr>
    </table>
    <button onclick="submitData()">Submit</button>

    <script>
        function submitData() {
            var table = document.getElementById("myTable");
            var data = [];
            for (var i = 1; i < table.rows.length; i++) {
                var rowData = {};
                rowData["id"] = table.rows[i].cells[0].innerHTML;
                rowData["name"] = table.rows[i].cells[1].innerHTML;
                rowData["age"] = table.rows[i].cells[2].innerHTML;
                data.push(rowData);
            }

            // Chuyển dữ liệu thành JSON
            var jsonData = JSON.stringify(data);

            // Tạo một request AJAX
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "ajaxServlet", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Data sent successfully!");
                    } else {
                        alert("An error occurred: " + xhr.statusText);
                    }
                }
            };
            xhr.send(jsonData);
        }
    </script>
</body>
</html>