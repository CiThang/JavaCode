package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Ngoaile.Number;
import View.CalculatorView;

public class CalculatorListenner implements ActionListener{

	private CalculatorView calculatorView;

	public CalculatorListenner(CalculatorView calculatorView) {
		this.calculatorView = calculatorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nut = e.getActionCommand();
		if (nut.equals("+")) {
			this.calculatorView.cong();
		} else if(nut.equals("-")) {
			this.calculatorView.hieu();
		} else if (nut.equals("*")) {
			this.calculatorView.tich();
		} else if (nut.equals("/")) {
			try {
				this.calculatorView.thuong();
			} catch (Number e1) {
				e1.getMessage();
			}
		}
		
	}
	
}
