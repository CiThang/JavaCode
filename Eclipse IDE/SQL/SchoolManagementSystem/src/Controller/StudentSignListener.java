package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DAO.StudentSignDao;
import DAO.StudentSystemDao;
import Model.Student;
import Model.StudentAccount;
import View.MainSignView;
import View.StudentSignView;
import View.StudentSystemView;

public class StudentSignListener implements ActionListener {

	private StudentSignView SSV;
	private StudentSystemView system;

	public StudentSignListener(StudentSignView sSV) {
		super();
		this.SSV = sSV;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String ssv = e.getActionCommand();
		if(ssv.equals("Đăng nhập")) {
			StudentAccount sa = new StudentAccount();		
			try {
				sa.setMaHocSinh(Integer.valueOf(SSV.textFieldMaHS.getText()));
				sa.setPass(SSV.passwordField.getText());
				StudentSignDao StDao = new StudentSignDao();
				StDao.getInstance().Dangnhap(SSV);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(SSV, "Tên đăng nhập không hợp lệ");
				SSV.textFieldMaHS.setText("");
				SSV.passwordField.setText("");
			}
					
			} else if(ssv.equals("Thoát")) {
			SSV.setVisible(false);
			MainSignView MSV = new MainSignView();
			MSV.setVisible(true);
			MSV.setLocationRelativeTo(null);
		}
		
	}
	
}
