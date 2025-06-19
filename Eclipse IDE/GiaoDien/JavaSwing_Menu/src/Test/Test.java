package Test;

import javax.swing.UIManager;

import View.MenuView;

public class Test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MenuView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
