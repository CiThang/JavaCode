package Test;

import javax.swing.UIManager;

import View.MainSignView;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MainSignView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
