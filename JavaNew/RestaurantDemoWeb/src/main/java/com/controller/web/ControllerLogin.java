package com.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.util.HibernateUtil;
import com.model.CustomerAccount;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.mail.*;
import javax.mail.internet.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/Login")
public class ControllerLogin extends HttpServlet {

	private static final long serialVersionUID = -261894415859900327L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/Login.jsp");
		rd.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String cusName = request.getParameter("cusname");
		String passWord = request.getParameter("passWord");

		if (cusName.isEmpty() || passWord.isEmpty()) {
			out.println("<script>alert('Please fill in all fields!'); window.location.href = 'Login';</script>");
			return;
		}


		List<CustomerAccount> customerAccounts = null;

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();					
					Query<CustomerAccount> query ;
					query  = session.createQuery("FROM CustomerAccount WHERE cusname = :identifier OR email = :identifier");
					query.setParameter("identifier", cusName);
					customerAccounts = query.getResultList();
					tr.commit();

					if (!customerAccounts.isEmpty()) {
						CustomerAccount customerAccount = customerAccounts.get(0);
						// Initialize key generator and secret key
						SecretKey secretKey;
						secretKey = customerAccount.getSecretkey();
						// Check password
						if (checkPassword(passWord, customerAccount.getPassword(), secretKey)) {
							HttpSession session2 = request.getSession();
							if(isValidEmail(cusName)) {
								session2.setAttribute("customerName", customerAccount.getCusName()); // Set customer name in session
							} else {
								session2.setAttribute("customerName", cusName);
							}
							// Send confirmation email
							sendEmail(customerAccount.getEmail());

							response.sendRedirect("Notice"); // Redirect to notice page
						} else {
							out.println("<script>alert('Wrong Password!');  window.location.href = 'Login';</script>");
						}
					} else {
						out.println(
								"<script>alert('Account does not exist!'); window.location.href = 'Login';</script>");
					}
				} finally {
					session.close();
				}
			} else {
				out.println(
						"<script>alert('Internal Server Error! Please try again later.'); window.location.href = 'Login';</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println(
					"<script>alert('Internal Server Error! Please try again later.'); window.location.href = 'Login';</script>");
		}
	}

	// Phương thức kiểm tra tính hợp lệ của địa chỉ email bằng biểu thức chính quy
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(emailRegex);
	}
	
	public void sendEmail(String cusEmail) {
		// rsod zinr kscl kqrx
		// dodotranchithang2k5@gmail.com
		final String from = "thangdtc.23ce@vku.udn.vn";
		final String pass = "ddsq pfpm nkxc upwo";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new javax.mail.PasswordAuthentication(from, pass);
			}
		};

		// Tạo session
		javax.mail.Session session = javax.mail.Session.getInstance(props, auth);

		MimeMessage msg = new MimeMessage(session);
		String to = cusEmail;
		try {
			msg.addHeader("Content-type", "text/HTML;charset=UTF-8");
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			msg.setSubject("Xác nhận đăng nhập vào Order Management");

			// Nội dung email với link xác nhận
			String confirmationLink = "http://localhost:8080/RestaurantDemoWeb/RestaurantOrder";
			String emailContent = "You have just logged in to Order Management.<br><br>";
			emailContent += "Click <a href='" + confirmationLink
					+ "'>here</a> to confirm and go to the Order Management page.";

			msg.setText(emailContent, "UTF-8", "html");

			Transport.send(msg);

			System.out.println("Email đã được gửi thành công đến: " + to);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    // Decrypt password and check if it matches the expected password
    public static boolean checkPassword(String userInputPassword, String encryptedPassword, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        String decryptedPassword = new String(decryptedBytes);            
        return userInputPassword.equals(decryptedPassword);
    }
    

}
