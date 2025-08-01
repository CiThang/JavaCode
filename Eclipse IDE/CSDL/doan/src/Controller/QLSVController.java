package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import Model.QLSVModel;
import Model.ThiSinh;
import Model.Tinh;
import View.QLSVView;


public class QLSVController implements Action {
	QLSVView view;
	
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if(cm.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (Exception e1) {
				System.out.println("Lỗi");
				e1.printStackTrace();
			} 
		} else if(cm.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
		} else if (cm.equals("Xóa")) {
			this.view.thucHienXoa();
		} else if (cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		} else if (cm.equals("Tìm")) {
			this.view.thucHienTim();
		} else if (cm.equals("Hủy")) {
			this.view.thucHienTaiLaiDuLieu();
		} else if (cm.equals("About")) {
			this.view.hienThiAbout();
		} else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		} else if (cm.equals("Save")) {
			this.view.thucHienSaveFile();
		} else if (cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
	
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
