package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TimKiemView;

public class TimKiemListener implements ActionListener {
	private TimKiemView timKiemView;

	public TimKiemListener(TimKiemView timKiemView) {
		this.timKiemView = timKiemView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.timKiemView.timkiem();
		
	}
	

}
