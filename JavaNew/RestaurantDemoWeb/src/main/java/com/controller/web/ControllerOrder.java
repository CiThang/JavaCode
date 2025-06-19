package com.controller.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.hibernate.util.HibernateUtil;
import com.model.Product;
import com.model.ProductOrder;
import com.model.ReceiptOrder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/RestaurantOrder")
public class ControllerOrder extends HttpServlet {

	private static final long serialVersionUID = -4700606767952299699L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					productList = session.createQuery("FROM Product").list();
					tr.commit();
				} finally {
					session.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("productList", productList);
		RequestDispatcher rd = req.getRequestDispatcher("/views/Restaurant.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerName = (String) request.getSession().getAttribute("customerName");
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					// Đọc dữ liệu JSON từ request
					StringBuilder jsonData = new StringBuilder();
					BufferedReader reader = request.getReader();
					String line;
					while ((line = reader.readLine()) != null) {
						jsonData.append(line);
					}
					// Chuyển dữ liệu JSON thành object
					JSONObject jsonObject = new JSONObject(jsonData.toString());

					JSONArray cartData = jsonObject.getJSONArray("cartData");
					for (int i = 0; i < cartData.length(); i++) {
						JSONObject item = cartData.getJSONObject(i);
						String productID = item.getString("prodId");
						String productName = item.getString("productName");
						String type = item.getString("type");
						double price = Double.parseDouble(item.getString("price").replaceAll("[^\\d.]", ""));
						int quantity = item.getInt("quantity");
						java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

						ProductOrder productOrder = new ProductOrder(null, customerName, productID, productName,
								sqlDate, quantity, type, price);

						session.save(productOrder);

						// Tìm kiếm sản phẩm dựa trên productID
						Query<Product> query = session.createQuery("FROM Product WHERE productID = :productID",
								Product.class);
						query.setParameter("productID", productID);
						Product product = query.uniqueResult();

						// Kiểm tra sản phẩm tồn tại
						if (product != null) {
							int currentQuantity = product.getStock();

							// Cập nhật số lượng sản phẩm
							if (currentQuantity == quantity) {
								product.setStock(0);
								product.setStatus("Unavailable");
							} else if (currentQuantity > quantity) {
								product.setStock(currentQuantity - quantity);
							} else {

								System.out.println("Không đủ hàng cho sản phẩm này.");
							}

							// Lưu thay đổi vào cơ sở dữ liệu
							session.update(product);
						} else {

							System.out.println("Không tìm thấy sản phẩm với productID " + productID);
						}
					}

					Double total = jsonObject.getDouble("total");
					Double amount = jsonObject.getDouble("amount");
					Double change = jsonObject.getDouble("change");

					ReceiptOrder receiptOrder = new ReceiptOrder(customerName, total, amount, change,
							new java.sql.Date(new Date().getTime()));
					session.save(receiptOrder);
					tr.commit();

//					out.println("<script>alert('Order Successfully!');  window.location.href = 'RestaurantOrder'</script>");
				} finally {

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
