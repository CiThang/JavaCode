package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.TeacherSignDao;
import DAO.TeacherSystemDao;
import Model.Student;
import Model.StudentManagement;
import View.MainSignView;
import View.TeacherSignView;
import View.TeacherSystemView;

public class TeacherSignListener implements ActionListener {

	private TeacherSignView TSV;
	private TeacherSystemView teacher;
	public TeacherSignListener(TeacherSignView tSV) {
		super();
		TSV = tSV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tsv = e.getActionCommand();
		if (tsv.equals("Đăng nhập")) {
			TeacherSignDao teDao = new TeacherSignDao();
			teDao.getInstance().Dangnhap(TSV);
			TeacherSystemDao tsDao = new TeacherSystemDao();
			StudentManagement stm = new StudentManagement(tsDao.getInstance().Showlist());
			
			
		} else if (tsv.equals("Thoát")) {
			TSV.setVisible(false);
			MainSignView MSV = new MainSignView();
			MSV.setVisible(true);
			MSV.setLocationRelativeTo(null);
		}

	}

}
