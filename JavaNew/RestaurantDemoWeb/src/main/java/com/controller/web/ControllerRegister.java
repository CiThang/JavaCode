package com.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.util.HibernateUtil;
import com.model.CustomerAccount;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/Register")
public class ControllerRegister extends HttpServlet {

	private static final long serialVersionUID = 4010721288146877580L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/Register.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String cusName = request.getParameter("cusName");
		String passWord = request.getParameter("passWord");
		String confirm = request.getParameter("confirmPass");
		String email = request.getParameter("cusEmail");

		// Kiem tra nguoi dung da ton tai chua
		if (isUserExists(cusName)) {
			out.println("<script>alert('User already exists!'); window.location.href = 'Register';</script>");
			return;
		}

		// Kiem tra email da ton tai chua
		if (isEmailExists(email)) {
			out.println("<script>alert('Email already exists!'); window.location.href = 'Register';</script>");
			return;
		}

		// Kiem tra cac truong co trong khong
		if (cusName.isEmpty() || passWord.isEmpty() || confirm.isEmpty() || email.isEmpty()) {
			out.println("<script>alert('Please fill in all fields!');  window.location.href = 'Register'</script>");
			return;
		}

		// Kiem tra Email co hop le khong
		if (!isValidEmail(email)) {
			out.println("<script>alert('Invalid email address!'); window.location.href = 'Register';</script>");
			return;
		}

		if (passWord.length() < 8) {
			out.println(
					"<script>alert('Password does not have enough 8 characters!'); window.location.href = 'Register';</script>");
			return;
		}

		if (confirm.equals(passWord)) {
			
			try {
				KeyGenerator keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(256); // AES key size is 256 bits
				SecretKey secretKey = keyGen.generateKey();
				String sercuriryPass = encryptPassword(passWord, secretKey);
				CustomerAccount cus = new CustomerAccount(null, cusName, email, sercuriryPass,secretKey);
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				if (sessionFactory != null) {
					Session session = sessionFactory.openSession();
					try {
						Transaction tr = session.beginTransaction();
						session.save(cus);
						tr.commit();
						HttpSession ss = request.getSession();
						ss.setAttribute("customerName", cusName); // Setting customer name before redirect

						response.setContentType("text/html;charset=UTF-8");
						out = response.getWriter();
						out.println("<script>alert('Register Success!');</script>");
						response.sendRedirect("RestaurantOrder");
					} finally {
						session.close();
					}
				}
			} catch (Exception e) {
				out.println("<script>alert('Register Error: " + e.getMessage()
						+ "Success!');  window.location.href = 'Register'</script>");
				e.printStackTrace();
			}
		} else {
			out.println("<script>alert('Passwords do not match!');  window.location.href = 'Register'</script>");
		}
	}

	// Phương thức kiểm tra tính hợp lệ của địa chỉ email bằng biểu thức chính quy
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(emailRegex);
	}

	// Phương thức kiểm tra xem người dùng đã tồn tại trong cơ sở dữ liệu hay không
	private boolean isUserExists(String cusName) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "SELECT COUNT(*) FROM CustomerAccount WHERE cusName = :cusName";
			Query<Long> query = session.createQuery(hql, Long.class);
			query.setParameter("cusName", cusName);
			Long count = query.uniqueResult();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private boolean isEmailExists(String email) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "SELECT COUNT(*) FROM CustomerAccount WHERE email = :email";
			Query<Long> query = session.createQuery(hql, Long.class);
			query.setParameter("email", email);
			Long count = query.uniqueResult();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
    // Encrypt password
    public static String encryptPassword(String password, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
