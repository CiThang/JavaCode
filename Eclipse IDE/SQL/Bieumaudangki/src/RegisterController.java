import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RegisterController implements ActionListener {

	private RegisterView rv;

	
	public RegisterController(RegisterView rv) {
		this.rv = rv;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String luachon = e.getActionCommand();
		if(luachon.equals("Đăng kí")) {
			String gmail = rv.textFieldEmail.getText();
			try {
				if (!gmail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
		            JOptionPane.showMessageDialog(rv, "Định dạng email không hợp lệ");
		        } else if(rv.textFieldSDT.getText().matches("\\d{10}")) {
		        	JOptionPane.showMessageDialog(rv, "Định dạng số điện thoại không hợp lệ. Vui lòng nhập 10 chữ số không có dấu cách hoặc ký tự đặc biệt");
		        } else {
		        	RegisterModel rm = rv.laythongtin();
					RegisterDAO.getInstance().insert(rm);
		        }
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
		} else if(luachon.equals("Hủy")) {
			
		}
		
	}
	
}
