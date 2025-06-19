package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import View.ThucDonView;

public class ThucDonController implements ActionListener {

	private ThucDonView thucDonView;
	
	
	public ThucDonController(ThucDonView thucDonView) {
		this.thucDonView = thucDonView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String monChinh = thucDonView.jComboBox_MonChinh.getSelectedItem().toString();
	 	
		
		String monPhu = "";
		Object[] luaChonMonPhu = thucDonView.jList_MonPhu.getSelectedValues();
		for (Object o : luaChonMonPhu) {
			monPhu = monPhu + o.toString() +", ";
		}

		thucDonView.thucDonModel.setLuaChon_MonChinh(monChinh);
		thucDonView.thucDonModel.setLuaChon_MonPhu(monPhu);
		thucDonView.thucDonModel.tinhTongTien();
		thucDonView.hienThiKetQua();
	
		
		String soTien = (String) JOptionPane.showInputDialog(
				thucDonView,
				thucDonView.jLabel_thongtin.getText()
				+"\n Nhap vao so tien: ",
				"Thong bao",
				JOptionPane.INFORMATION_MESSAGE);
	
	try {
		double sotien = Double.valueOf(soTien);
		JOptionPane.showMessageDialog(thucDonView, 
				"Thoi tien lai cho khach: "+(sotien- thucDonView.thucDonModel.getTongTien()));
	} catch (Exception e2) {
		JOptionPane.showMessageDialog(thucDonView, 
				"Nhap du lieu sai!!!",
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}
	}
}
