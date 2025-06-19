package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.LastButtonView;

public class LastButtonListener implements ActionListener {

	private LastButtonView lastButtonView;
	
	
	public LastButtonListener(LastButtonView lastButtonView) {
		this.lastButtonView = lastButtonView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String nguoiSuKien = e.getActionCommand();
		if(nguoiSuKien.equals("1")) {
			this.lastButtonView.changeTo_1();
		} else if(nguoiSuKien.equals("2")) {
			this.lastButtonView.changeTo_2();
		}  else if(nguoiSuKien.equals("3")) {
			this.lastButtonView.changeTo_3();
		}  else if(nguoiSuKien.equals("4")) {
			this.lastButtonView.changeTo_4();
		} 
		
	}

}
