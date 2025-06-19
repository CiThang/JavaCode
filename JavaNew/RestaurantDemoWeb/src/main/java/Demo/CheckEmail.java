package Demo;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class CheckEmail {

	public static void main(String[] args)  {
		
		  // Thông tin người dùng và email cần xác nhận
        String recipientEmail = "dodotranchithang2k5@gmail.com";
        String confirmationLink = "https://yourwebsite.com/confirm"; // Đường dẫn xác nhận

        // Cấu hình các thuộc tính của session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.yourprovider.com"); // Thay thế bằng SMTP server của bạn
        properties.put("mail.smtp.port", "587"); // Cổng SMTP
        properties.put("mail.smtp.auth", "true"); // Xác thực
        properties.put("mail.smtp.starttls.enable", "true"); // Bật TLS

        // Thông tin tài khoản email của bạn
        String senderEmail = "your_email@yourprovider.com";
        String password = "your_password";

        // Tạo session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        try {
            // Tạo một đối tượng MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Đặt người gửi và người nhận
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Đặt tiêu đề và nội dung email xác nhận
            message.setSubject("Xác nhận địa chỉ email");
            message.setText("Xin chào,\n\n"
                    + "Vui lòng nhấn vào liên kết sau để xác nhận địa chỉ email của bạn:\n\n"
                    + confirmationLink);

            // Gửi email
            Transport.send(message);

            System.out.println("Đã gửi email xác nhận đến " + recipientEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
   }
