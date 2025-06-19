package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.TeacherSystemDao;
import Model.Student;
import Model.StudentManagement;
import View.TeacherSignView;
import View.TeacherSystemView;

public class TeacherSystemListener implements ActionListener {

	private TeacherSystemView tsv;
	public TeacherSystemDao ssd = new TeacherSystemDao();
	
	public TeacherSystemListener(TeacherSystemView tsv) {
		this.tsv = tsv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tch = e.getActionCommand();
		if (tch.equals("Tìm")) {
			try {
				Student st = ssd.getInstance().findStudent(Integer.valueOf(tsv.textFieldtim.getText()));
				if (st != null) {
					tsv.SetText(st);
				} else {
					JOptionPane.showMessageDialog(tsv, "Không có thông tin học sinh");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(tsv, "Bạn chưa nhập mã học sinh");
			}
			

		} else if (tch.equals("Trang chủ")) {
			tsv.panelThongtin.setVisible(false);
			tsv.panelChinh.setVisible(false);
			tsv.lblNewLabel_2.setVisible(true);
		} else if (tch.equals("Thông tin")) {
			tsv.panelThongtin.setVisible(true);
			tsv.panelChinh.setVisible(false);
			tsv.lblNewLabel_2.setVisible(false);
			tsv.SetThongTin();

		} else if (tch.equals("Bảng điểm")) {
			tsv.panelThongtin.setVisible(false);
			tsv.lblNewLabel_2.setVisible(false);
			tsv.panelChinh.setVisible(true);
			tsv.thucHienTaiLaiDuLieu();
			for (Student st : ssd.getInstance().Showlist()) {
				tsv.themHocSinhVaoTable(st);
				
			}
		} else if (tch.equals("Đăng xuất")) {
			tsv.setVisible(false);
			TeacherSignView ts = new TeacherSignView();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		} else if (tch.equals("Lưu")) {
			try {
				Student st = tsv.student(Integer.valueOf(tsv.textFieldmahocsinh.getText()));
				ssd.getInstance().Inputscore(st);
				this.tsv.thucHienThem(
						ssd.getInstance().GetStudentByID(Integer.valueOf(tsv.textFieldmahocsinh.getText())));
				JOptionPane.showMessageDialog(tsv, "Lưu thông tin thành công");
				tsv.SetChinh();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(tsv, "Lưu thông tin không thành công");
			}

		} else if (tch.equals("Thêm học sinh")) {
			try {
				Object[] options = { "Có", "Không" };
				int result = JOptionPane.showOptionDialog(tsv, "Bạn có muốn thêm học sinh", "Xác nhận",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.YES_OPTION) {
					ssd.addID(Integer.valueOf(tsv.textFieldmahocsinh.getText()));
					ssd.setAccount(Integer.valueOf(tsv.textFieldmahocsinh.getText()));
					Student st = new Student(Integer.valueOf(tsv.textFieldmahocsinh.getText()), 0, 0, 0);
					if (!tsv.stm.kiemTraTonTai(st)) {
						tsv.themHocSinhVaoTable(st);
						tsv.stm.insert(st);
						JOptionPane.showMessageDialog(tsv, "Thêm thành công");
					}
				}

			} catch (Exception e1) {
				if (tsv.textFieldmahocsinh.getText().equals("")) {
					JOptionPane.showMessageDialog(tsv, "Chưa nhập mã học sinh");
				} else {
					JOptionPane.showMessageDialog(tsv, "Học sinh đã tồn tại");
				}
			}
		} else if (tch.equals("Cập nhật")) {
			try {
				
				tsv.hienThiThongTinHocSinhDaChon();
			} catch (Exception e1) {
				if (tsv.textFieldmahocsinh.getText().equals("")) {
					JOptionPane.showMessageDialog(tsv, "Bạn chưa chọn học sinh");
				} else {
					JOptionPane.showMessageDialog(tsv, "Học sinh không tồn tại");
				}
			}

		} else if (tch.equals("Xóa học sinh")) {
			try {
				Object[] options = { "Có", "Không" };
				int result = JOptionPane.showOptionDialog(tsv, "Bạn có muốn xóa học sinh", "Xác nhận",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.YES_OPTION && tsv.stm.kiemtratontaitheoID(Integer.valueOf(tsv.textFieldmahocsinh.getText())) ) {
					tsv.deleteRowId(Integer.valueOf(tsv.textFieldmahocsinh.getText()));
					ssd.delete(Integer.valueOf(tsv.textFieldmahocsinh.getText()));
					tsv.textFieldmahocsinh.setText(tsv.textFieldmahocsinh.getText());
					ssd.deleteAccount(Integer.valueOf(tsv.textFieldmahocsinh.getText()));
					JOptionPane.showMessageDialog(tsv, "Xóa thành công");
					tsv.SetChinh();
				} 
			} catch (Exception e1) {
				if (tsv.textFieldmahocsinh.getText().equals("")) {
					JOptionPane.showMessageDialog(tsv, "Chưa nhập mã học sinh");
				} else {
					JOptionPane.showMessageDialog(tsv, "Học sinh không tồn tại");
				}
			}

		} else if (tch.equals("Tìm kiếm")) {
			int luachon = tsv.comboBoxTimKiem.getSelectedIndex();
			if (luachon == 1) {
				tsv.thucHienTaiLaiDuLieu();
				for (Student st : ssd.selectStudentsByMath()) {
					tsv.themHocSinhVaoTable(st);
				}
			} else if (luachon == 2) {
				tsv.thucHienTaiLaiDuLieu();
				for (Student st : ssd.selectStudentsByLiterature()) {
					tsv.themHocSinhVaoTable(st);
				}
			} else if (luachon == 3) {
				tsv.thucHienTaiLaiDuLieu();
				for (Student st : ssd.selectStudentsByEnglish()) {
					tsv.themHocSinhVaoTable(st);
				}
			}
		} else if (tch.equals("Sắp xếp")) {
			int luachon = tsv.comboBoxXapxep.getSelectedIndex();
			if (luachon == 1) {
				tsv.thucHienTaiLaiDuLieu();
				for (Student st : tsv.stm.xapxepToan(ssd.getInstance().Showlist())) {
					tsv.themHocSinhVaoTable(st);
				}
			} else if (luachon == 2) {
				tsv.thucHienTaiLaiDuLieu();
				for (Student st : tsv.stm.xapxepVan(ssd.getInstance().Showlist())) {
					tsv.themHocSinhVaoTable(st);
				}
			} else if (luachon == 3) {
				tsv.thucHienTaiLaiDuLieu();
				for (Student st : tsv.stm.xapxepAnh(ssd.getInstance().Showlist())) {
					tsv.themHocSinhVaoTable(st);
				}
			}

		} else if (tch.equals("Hủy tìm kiếm")) {
			tsv.thucHienTaiLaiDuLieu();
			tsv.comboBoxTimKiem.setSelectedIndex(0);
			for (Student st : ssd.getInstance().Showlist()) {
				tsv.themHocSinhVaoTable(st);
			}
		} else if (tch.equals("Hủy sắp xếp")) {
			tsv.thucHienTaiLaiDuLieu();
			tsv.comboBoxXapxep.setSelectedIndex(0);
			for (Student st : ssd.getInstance().Showlist()) {
				tsv.themHocSinhVaoTable(st);
			}
		} else if (tch.equals("Đăng xuất")) {
			tsv.setVisible(false);
			TeacherSignView tSignView = new TeacherSignView();
			tSignView.setVisible(true);
			tSignView.setLocationRelativeTo(null);
		} else if (tch.equals("Đổi mật khẩu")) {
			try {
				String newpass = (String) JOptionPane.showInputDialog(tsv, "Nhập mật khẩu mới", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				ssd.getInstance().ChangePassword(tsv.lblMaGiaoVien.getText(), newpass);
				JOptionPane.showMessageDialog(tsv, "Đổi mật khẩu thành công");
			} catch (Exception e1) {
				// TODO: handle exception
			}
		} else if(tch.equals("Hủy")) {
			tsv.SetChinh();
		} else if(tch.equals("Hủy tìm")) {
			tsv.SetThongTin();
		}

	}
}
