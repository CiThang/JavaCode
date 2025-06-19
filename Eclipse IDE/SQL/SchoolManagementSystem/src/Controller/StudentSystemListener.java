package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.StudentSignDao;
import DAO.StudentSystemDao;
import Model.Student;
import View.StudentSignView;
import View.StudentSystemView;

public class StudentSystemListener implements ActionListener {

	private StudentSystemView ssv ;
	private StudentSignDao ssigndao;

	private StudentSystemDao ssd = new StudentSystemDao();
	public StudentSystemListener(StudentSystemView ssv) {
		this.ssv = ssv;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String st = e.getActionCommand();
		if(st.equals("Lưu")) {
			try {
				Object[] options = {"Có", "Không"};
                int result = JOptionPane.showOptionDialog(ssv,
                        "Bạn có chắc muốn lưu thông tin",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(result == JOptionPane.YES_OPTION ){                					
                	StudentSignDao.getInstance().selectStudent(Integer.valueOf(ssv.lblMaThiSinh.getText()));
                	ssv.thucHienLuu();
    				ssd.getInstance().insert(ssv.thucHienLuu());
    				JOptionPane.showMessageDialog(ssv,"Lưu thành công");
                } else if(result == JOptionPane.NO_OPTION) {
                	ssv.SetText(ssigndao.getInstance().selectStudent(Integer.valueOf(ssv.lblMaThiSinh.getText())));
                }
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(ssv, "Lưu không thành công");
				ssv.SetText(StudentSignDao.getInstance().selectStudent(Integer.valueOf(ssv.lblMaThiSinh.getText())));
			}
		} else if(st.equals("Đăng xuất")) {
			ssv.setVisible(false);
			ssv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			StudentSignView sv = new StudentSignView();
			sv.setVisible(true);
			sv.setLocationRelativeTo(null);
			
		} else if(st.equals("Xóa")) {
			
			ssv.xoaForm();
		} else if (st.equals("Đổi mật khẩu")) {
			try {
			String newPass = (String) JOptionPane.showInputDialog(
                    ssv,
                    "Nhập mật khẩu mới:",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
			if(newPass != null) {
				ssd.getInstance().ChangePassword(Integer.valueOf(ssv.lblMaThiSinh.getText()), newPass);
				JOptionPane.showMessageDialog(ssv, "Cập nhật mật khẩu thành công");
			}
				
			
			

			}catch (Exception e1) {
				// TODO: handle exception
			}
		} else if (st.equals("Chọn ảnh")) {
			ssv.setAnh();
		} 
		 
	}

}
