package Yelp_Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Yelp_DAO.YelpRegisterDAO;
import Yelp_Model.YelpUserAccount;
import Yelp_View.YelpMainView;
import Yelp_View.YelpRegisterView;
import Yelp_View.YelpSignInView;

public class YelpRegisterController implements ActionListener {

	private YelpRegisterView register;


	public YelpRegisterController(YelpRegisterView register) {
		this.register = register;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String luachon = e.getActionCommand();

		if (luachon == "HỦY") {
			register.setVisible(false);
			YelpSignInView view = new YelpSignInView();
			view.setVisible(true);
			view.setLocationRelativeTo(null);
		} else if (luachon == "Chọn ảnh") {
			register.setAnh();
		} else if (luachon == "TẠO TÀI KHOẢN") {
			try {
				YelpUserAccount userAccount = register.ThongtinUser();

				// Kiểm tra tài khoản đã tồn tại và thông tin bỏ trống 
				if (YelpRegisterDAO.getInstance().kiemtrataikhoantontai(userAccount)
						&& register.kiemtrathongtinbotrong()
						&& YelpRegisterDAO.getInstance().isValidEmail(userAccount.getEmailNguoiDung())) {
					YelpRegisterDAO.getInstance().DangKi(userAccount);
					JOptionPane.showMessageDialog(register, "Đăng kí thành công");
					register.setVisible(false);
					
				} else {
					register.textFieldTenTaiKhoan.setText("");
					register.textFieldEmail.setText("");
					JOptionPane.showMessageDialog(register, "Đăng kí thất bại");
				}

			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(register, "Đăng kí thất bại");
				e2.printStackTrace();
			}
		}

	}

}
