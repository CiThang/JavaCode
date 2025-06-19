package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
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
		
	}
	
}
