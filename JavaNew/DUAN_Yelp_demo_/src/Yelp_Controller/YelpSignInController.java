package Yelp_Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Yelp_DAO.YelpSignInDAO;
import Yelp_View.YelpRegisterView;
import Yelp_View.YelpSignInView;

public class YelpSignInController implements ActionListener {

	
	
	private YelpSignInView sign;
	
	public YelpSignInController(YelpSignInView sign) {
		this.sign = sign;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String luachon = e.getActionCommand();
		if(luachon=="ĐĂNG NHẬP") {
			YelpSignInDAO signInDAO = new YelpSignInDAO();
			signInDAO.getInstance().DangNhap(sign);
		} else if(luachon=="ĐĂNG KÝ") {
			sign.setVisible(false);
			YelpRegisterView register = new YelpRegisterView();
			register.setVisible(true);
			register.setLocationRelativeTo(null);
			
		}
		
	}

}
