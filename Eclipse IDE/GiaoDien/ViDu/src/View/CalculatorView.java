package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CalculatorListenner;
import Model.CalculatorModel;
import Ngoaile.Number;

public class CalculatorView extends JFrame {

	private CalculatorModel calculatorModel;
	private JTextField jTextField_a;
	private JTextField jTextField_b;
	private JLabel jLabel_value;

	public CalculatorView() throws HeadlessException {
		this.calculatorModel = new CalculatorModel();
		this.init();
	}
	public void init() {
		this.setTitle("Calculator");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		CalculatorListenner ac = new CalculatorListenner(this);
		
		JPanel jPanel_value =  new JPanel();
		JLabel jLabel_a = new JLabel("Nhap a: ");
		JLabel jLabel_b = new JLabel("Nhap b: ");
		JLabel jLabel_ketqua = new JLabel("Ket qua: ");
		
		jTextField_a = new JTextField();
		jTextField_b = new JTextField();
		jLabel_value = new JLabel();
		
		jPanel_value.setLayout(new GridLayout(3,2));
		jPanel_value.add(jLabel_a);
		jPanel_value.add(jTextField_a);
		jPanel_value.add(jLabel_b);
		jPanel_value.add(jTextField_b);
		jPanel_value.add(jLabel_ketqua);
		jPanel_value.add(jLabel_value);
		
		
		JPanel jPanel_pheptinh = new JPanel();
		JButton jButton_cong = new JButton("+");
		jButton_cong.addActionListener(ac);
		JButton jButton_tru = new JButton("-");
		jButton_tru.addActionListener(ac);
		JButton jButton_nhan = new JButton("*");
		jButton_nhan.addActionListener(ac);
		JButton jButton_chia = new JButton("/");
		jButton_chia.addActionListener(ac);
		
		jPanel_pheptinh.setLayout(new GridLayout(1,4,10,10));
		jPanel_pheptinh.add(jButton_cong);
		jPanel_pheptinh.add(jButton_tru);
		jPanel_pheptinh.add(jButton_nhan);
		jPanel_pheptinh.add(jButton_chia);
		
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_value, BorderLayout.CENTER);
		this.add(jPanel_pheptinh, BorderLayout.SOUTH);

		this.setVisible(true);
	}
/*
 * 		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.plus();
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
 */
	public void cong() {
		try {
		double a = Double.valueOf(jTextField_a.getText());
		double b = Double.valueOf(jTextField_b.getText());
		this.calculatorModel.setA(a);
		this.calculatorModel.setB(b);
		this.calculatorModel.tong();
		this.jLabel_value.setText(this.calculatorModel.getValue()+"");
		} catch (Exception e) {
			this.jLabel_value.setText("Loi !!!");
		}
	}
	
	public void hieu() {
		try {
		double a = Double.valueOf(jTextField_a.getText());
		double b = Double.valueOf(jTextField_b.getText());
		this.calculatorModel.setA(a);
		this.calculatorModel.setB(b);
		this.calculatorModel.hieu();
		this.jLabel_value.setText(this.calculatorModel.getValue()+"");
		} catch (Exception e) {
			this.jLabel_value.setText("Loi !!!");
		}
	}
	
	public void tich() {
		try {
		double a = Double.valueOf(jTextField_a.getText());
		double b = Double.valueOf(jTextField_b.getText());
		this.calculatorModel.setA(a);
		this.calculatorModel.setB(b);
		this.calculatorModel.tich();
		this.jLabel_value.setText(this.calculatorModel.getValue()+"");
		} catch (Exception e) {
			this.jLabel_value.setText("Loi !!!");
		}
	}
	
	public void thuong() throws Number {
		try {
		double a = Double.valueOf(jTextField_a.getText());
		double b = Double.valueOf(jTextField_b.getText());
		this.calculatorModel.setA(a);
		this.calculatorModel.setB(b);
		this.calculatorModel.thuong();
		if(b==0) {
			throw new Number();
		}
		this.jLabel_value.setText(this.calculatorModel.getValue()+"");
		} catch (Exception e) {
			this.jLabel_value.setText("Loi !!!");
		}
	}
	
	
	
	
	
	
}
