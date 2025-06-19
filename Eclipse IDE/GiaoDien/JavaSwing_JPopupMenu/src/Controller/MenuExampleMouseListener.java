package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;import java.util.Locale.IsoCountryCode;

import View.MenuView;



public class MenuExampleMouseListener implements MouseListener {
	MenuView menuView;
	

	public MenuExampleMouseListener(MenuView menuView) {
		this.menuView = menuView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.menuView.setTextJLabel("click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.menuView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.menuView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
