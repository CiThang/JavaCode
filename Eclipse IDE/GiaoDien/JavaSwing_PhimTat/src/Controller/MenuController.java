package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MenuView;

public class MenuController implements ActionListener {

	private MenuView menuView;

	
	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("Open")) {
			this.menuView.setTextJLabel("Ban da click JMenuItem OPEN");
		} else if(button.equals("Exit")) {
//			this.menuView.setTextJLabel("Ban da click JMenuItem Exit");
			System.exit(0);
		} else if(button.equals("Welcome")) {
			this.menuView.setTextJLabel("Ban da click JMenuItem Welcome");
		} else if(button.equals("New")) {
			this.menuView.setTextJLabel("Ban da click JMenuItem New");
		} else if(button.equals("Help")) {
			this.menuView.setTextJLabel("Ban da click JMenu Help");
		}
		
	}
	
}
