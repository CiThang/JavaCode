package Demo;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void main(String[] args) {
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
		
		Session session = Session.getInstance(props,auth);
		
		final String to = "chisthawngs05@gmail.com";
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.addHeader("Content-type", "text/HTML;charset=UTF-8");
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			
			msg.setSubject("thu nghiem gui email");

			
			msg.setText("Day la phan noi dung","UTF-8");
			
			Transport.send(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
