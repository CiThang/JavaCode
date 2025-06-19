package Test;

import javax.swing.UIManager;

import View.StudentView;

public class test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StudentView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
