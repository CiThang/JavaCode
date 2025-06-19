package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MainSignView;
import View.StudentSignView;
import View.TeacherSignView;

public class MainSignViewListener implements ActionListener {

	private MainSignView MSV;
	
	public MainSignViewListener(MainSignView mSV) {
		this.MSV = mSV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msv = e.getActionCommand();
		if(msv.equals("HỌC SINH")) {
			this.MSV.dispose();
			StudentSignView SSV = new StudentSignView();
			SSV.setVisible(true);
			SSV.setLocationRelativeTo(null);
			
		} else if(msv.equals("GIÁO VIÊN")) {
			this.MSV.setVisible(false);
			TeacherSignView TSV = new TeacherSignView();
			TSV.setVisible(true);
			TSV.setLocationRelativeTo(null);
		}
		
	}

}
