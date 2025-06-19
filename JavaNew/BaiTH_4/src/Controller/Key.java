package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.QLSachView;

public class Key implements KeyListener {
	QLSachView sachView;

	public Key(QLSachView sachView) {
		this.sachView = sachView;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
			int row = sachView.jTable_nhap.getSelectedRow();
			sachView.idText.setText((String) sachView.jTable_nhap.getValueAt(row, 0));
			sachView.sachText.setText((String) sachView.jTable_nhap.getValueAt(row, 1));
			sachView.tacgiaText.setText((String) sachView.jTable_nhap.getValueAt(row, 2));
			sachView.namXBText.setText((String) sachView.jTable_nhap.getValueAt(row, 3));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
