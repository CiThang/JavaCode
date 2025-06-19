<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Order</title>
 <style>
     body {
        font-family: Arial, sans-serif;
        margin: 0 100px; /* Thụt lề vào 100px ở cả hai bên */
        padding: 0;
        background-color: #f9f9f9;
    }

    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 20px 0;
        border-bottom: 1px solid #ddd;
        margin-bottom: 20px;
    }

    .header h1 {
        margin: 0;
    }

    .header .auth-buttons {
        display: flex;
        gap: 10px;
    }

    .header .auth-buttons a {
        text-decoration: none;
        color: #fff;
        background: linear-gradient(to bottom right, #098c53, #246861);
        padding: 10px 20px;
        border-radius: 4px;
        transition: background-color 0.3s;
    }

    .header .auth-buttons a:hover {
        background: linear-gradient(to bottom right, #0a7547, #205950);
    }

    h2 {
        margin-top: 20px;
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    input[type="text"], input[type="number"] {
        width: 100%;
        padding: 6px 10px;
        margin: 5px 0;
        box-sizing: border-box;
    }

    button {
        background: linear-gradient(to bottom right, #098c53, #246861);
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    button:hover {
        background: linear-gradient(to bottom right, #0a7547, #205950);
    }

    .add-btn-container {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .quantity-input {
        width: 50px;
    }

    .form-container {
        display: flex;
        justify-content: center;
    }

    form {
        width: 40%; /* Kích thước bằng 2/5 của trang */
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .receipt-input {
        margin-bottom: 15px;
    }

    .submit-btn-container {
        text-align: center;
    }
    
    .logout-btn {
        background: linear-gradient(to bottom right, #d9534f, #c9302c);
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        position: fixed;
        bottom: 20px;
        right: 20px;
    }

    .logout-btn:hover {
        background: linear-gradient(to bottom right, #c9302c, #ac2925);
    }
    
    .search-bar {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
        gap: 10px;
    }
    
    .search-bar input {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        flex-grow: 1;
    }
    
    .search-bar button {
        padding: 10px 20px;
        flex-grow: 0;
    }
</style>
</head>
<body>
    <div class="header">
        <h1>Order Management</h1>
        <div class="auth-buttons">
            <a href="Login">Login</a>
            <a href="Register">Register</a>
        </div>
    </div>
        <!-- Hiển thị tên khách hàng từ session -->
    <h2>Welcome ${sessionScope.customerName}!</h2>
    
        <div class="search-bar">
        <input type="text" id="productName" placeholder="Product Name">
        <input type="text" id="productType" placeholder="Product Type">
        <input type="number" id="minPrice" placeholder="Min Price">
        <input type="number" id="maxPrice" placeholder="Max Price">
        <button onclick="filterProducts()">Search</button>
        <button onclick="resetProducts()">Cancel</button>
    </div>
    

    <table id="productTable">
        <tr>
            <th>ProdId</th>
            <th>Name Product</th>
            <th>Price</th>
            <th>Type</th>
            <th>Stock</th>
            <th>Quantity</th>
            <th></th>
        </tr>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.productID }</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.type}</td>
                <td>${product.stock}</td>
                <td><input type="number" class="quantity-input" value="0" min="0"></td>
                <td class="add-btn-container"><button onclick="addItem(this)">Add</button></td>
            </tr>
        </c:forEach>
    </table>

    <h2>Cart</h2>

    <table id="cartTable">
        <tr>
            <th>Prod ID</th>
            <th>Product Name</th>
            <th>Type</th>
            <th>Quantity</th>
            <th>Price</th>
            <th></th>
        </tr>
        <!-- Các hàng sản phẩm trong giỏ hàng sẽ được thêm bằng JavaScript -->
    </table>

    <div class="form-container">
        <form action="RestaurantOrder" method="post">
            <h2>Receipt</h2>
            <div class="receipt-input">
                <label for="total">Total:</label>
                <input type="text" id="total" name="total" readonly>
            </div>
            <div class="receipt-input">
                <label for="amount">Amount:</label>
                <input type="text" id="amount" name="amount">
            </div>
            <div class="receipt-input">
                <label for="change">Change:</label>
                <input type="text" id="change" name="change" readonly>
            </div>
            <div class="submit-btn-container">
                <button type="submit" onclick="order(event)">Submit</button>
            </div>
        </form>
    </div>
  <!--    <button class="logout-btn" onclick="logout()">Logout</button>-->

<form action="LogoutServlet" method="post">
        <input class="logout-btn" type="submit" value="Logout" />
    </form>
	<script>
	  function filterProducts() {
          var productName = document.getElementById('productName').value.toLowerCase();
          var productType = document.getElementById('productType').value.toLowerCase();
          var minPrice = document.getElementById('minPrice').value;
          var maxPrice = document.getElementById('maxPrice').value;
          
          var rows = document.querySelectorAll('#productTable tr:not(:first-child)');
          
          rows.forEach(function(row) {
              var name = row.cells[1].innerText.toLowerCase();
              var type = row.cells[3].innerText.toLowerCase();
              var price = parseFloat(row.cells[2].innerText);
              
              var matches = true;
              
              if (productName && !name.includes(productName)) {
                  matches = false;
              }
              
              if (productType && !type.includes(productType)) {
                  matches = false;
              }
              
              if (minPrice && price < parseFloat(minPrice)) {
                  matches = false;
              }
              
              if (maxPrice && price > parseFloat(maxPrice)) {
                  matches = false;
              }
              
              if (matches) {
                  row.style.display = '';
              } else {
                  row.style.display = 'none';
              }
          });
      }
      
      function resetProducts() {
          document.getElementById('productName').value = '';
          document.getElementById('productType').value = '';
          document.getElementById('minPrice').value = '';
          document.getElementById('maxPrice').value = '';
          
          var rows = document.querySelectorAll('#productTable tr:not(:first-child)');
          rows.forEach(function(row) {
              row.style.display = '';
          });
      }
		function addItem(button) {			
		    var customerName = "${sessionScope.customerName}";
		    if (!customerName || customerName.trim() === "") {
		        alert("Please log in to continue.");
		        return;
		    }
			
			// Get the row of the clicked button
			var row = button.parentNode.parentNode;
			// Get product information from the row
			var productId = row.cells[0].innerText;
			var productName = row.cells[1].innerText;
			var price = row.cells[2].innerText;
			var type = row.cells[3].innerText;
			var quantityInput = row.cells[5].querySelector("input");
			var quantity = parseInt(quantityInput.value);
			// Check if the quantity is a valid number
			if (isNaN(quantity) || quantity <= 0) {
				alert('Please enter a valid quantity.');
				return;
			}
			// Check if the quantity exceeds the available stock
			var availableStock = parseInt(row.cells[4].innerText);
			if (quantity > availableStock) {
				alert('Quantity exceeds available stock.');
				return;
			}
			// Calculate total price for the selected quantity
			var unitPrice =price;
			var total = unitPrice * quantity;
			// Add product to cart
			var cartTable = document.getElementById("cartTable");
			var newRow = cartTable.insertRow();

			var cell0 = newRow.insertCell(0);
			var cell1 = newRow.insertCell(1);
			var cell2 = newRow.insertCell(2);
			var cell3 = newRow.insertCell(3);
			var cell4 = newRow.insertCell(4);
			var cell5 = newRow.insertCell(5); // New cell for delete button

			cell0.innerText = productId;
			cell1.innerText = productName;
			cell2.innerText = type;
			cell3.innerText = quantity;
			cell4.innerText = total.toLocaleString().replace(".", "") + " $";
			// Create delete button
			var deleteButton = document.createElement("button");
			deleteButton.innerHTML = "Delete";
			deleteButton.onclick = function() {
				deleteRow(this);
			};
			cell5.appendChild(deleteButton);
			updateTotal(); // Gọi updateTotal() sau khi thêm sản phẩm vào giỏ hàng
		}

		function deleteRow(button) {
			var row = button.parentNode.parentNode;
			row.parentNode.removeChild(row);
			updateTotal();
		}

		function updateTotal() {
			var cartTable = document.getElementById("cartTable");
			var rows = cartTable.rows;
			var total = 0;
			// Lặp qua các hàng trong giỏ hàng
			for (var i = 1; i < rows.length; i++) {
				var rowTotal = rows[i].cells[4].innerText;
				total += parseFloat(rowTotal.replace(" $", ""));
			}
			// Cập nhật tổng vào thẻ input có id là "total"
			document.getElementById("total").value = total.toLocaleString().replace(".", "")
					+ " $";
		}
// BTN ORDER
		function order(event) {
			event.preventDefault(); // Ngăn chặn form submit tự động

			
		}

		function order(event) {
		    event.preventDefault(); // Ngăn chặn form submit tự động

		    // Hiển thị cửa sổ xác nhận
		    if (confirm("Are you sure you want to place this order?")) {
		    	// Thu thập dữ liệu từ bảng giỏ hàng
				var cartTable = document.getElementById("cartTable");
				var cartData = [];
				for (var i = 1; i < cartTable.rows.length; i++) {
					var rowData = {};
					rowData["prodId"] = cartTable.rows[i].cells[0].innerText;
					rowData["productName"] = cartTable.rows[i].cells[1].innerText;
					rowData["type"] = cartTable.rows[i].cells[2].innerText;
					rowData["quantity"] = cartTable.rows[i].cells[3].innerText;
					rowData["price"] = cartTable.rows[i].cells[4].innerText;
					cartData.push(rowData);
				}

				// Thu thập dữ liệu từ form receipt
				var totalText = document.getElementById("total").value;
				var total = parseFloat(totalText.replace(" $", "").replace(",", ""));
				var amount = parseFloat(document.getElementById("amount").value);
				var change = amount - total;
				if (isNaN(amount) || isNaN(change) || change < 0) {
					alert("Invalid payment amount!");
					return; // Ngăn chặn gửi dữ liệu nếu dữ liệu không hợp lệ
				}

				// Hiển thị số tiền thừa trực tiếp lên ô input "change"
				document.getElementById("change").value = change.toLocaleString()
						+ " $";

				// Tạo một object chứa dữ liệu từ bảng và form
				var postData = {
					"cartData" : cartData,
					"total" : total,
					"amount" : amount,
					"change" : change
				};

				// Chuyển dữ liệu thành chuỗi JSON
				var jsonData = JSON.stringify(postData);

				// Tạo một request AJAX
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "RestaurantOrder", true);
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE) {
						if (xhr.status === 200) {
							console.log("Data sent successfully!");		
							// window.location.reload(true);
							resetPage(); 
						} else {
							alert("An error occurred: " + xhr.statusText);
						}
					}
				};
				xhr.send(jsonData);
				
		    } else {		       
		        return;
		    }
		}
		function resetPage() {
		    // Hiển thị thông báo trên console
		     alert("Order successfully placed!"); // Hiển thị thông báo thành công

		    // Reset lại trang
		    window.location.reload(true);
		}
		
		
// Logout
		 function logout() {
	            var xhr = new XMLHttpRequest();
	            xhr.open("GET", "<%= request.getContextPath() %>/logout", true);
	            xhr.onreadystatechange = function() {
	                if (xhr.readyState === XMLHttpRequest.DONE) {
	                    if (xhr.status === 200) {

	                    } else {
	                        console.error("Logout failed: " + xhr.status + " " + xhr.statusText);
	                    }
	                }
	            };
	            xhr.send();
	        }
 
// HIEN THI BTN LOGIN, REGISTER, LOGOUT
        window.onload = function() {
            // Lấy giá trị của customerName từ session
            var customerName = "${sessionScope.customerName}";

            // Lấy các button login, register và logout
            var loginBtn = document.querySelector('.auth-buttons a[href="Login"]');
            var registerBtn = document.querySelector('.auth-buttons a[href="Register"]');
            var logoutBtn = document.querySelector('.logout-btn');

            // Nếu customerName không rỗng, hiện nút logout và ẩn nút login và register
            if (customerName && customerName.trim() !== "") {
                logoutBtn.style.display = "block";
                loginBtn.style.display = "none";
                registerBtn.style.display = "none";
            } else { // Nếu customerName rỗng, hiện nút login và register và ẩn nút logout
                logoutBtn.style.display = "none";
                loginBtn.style.display = "block";
                registerBtn.style.display = "block";
            }
        };
        
        function clearOrderForm() {
            // Xóa nội dung của bảng cartTable
            var cartTable = document.getElementById("cartTable");
            while (cartTable.rows.length > 1) {
                cartTable.deleteRow(1);
            }

            // Xóa nội dung trong các trường của form
            document.getElementById("total").value = "";
            document.getElementById("amount").value = "";
            document.getElementById("change").value = "";
        }
	</script>
</body>
</html>