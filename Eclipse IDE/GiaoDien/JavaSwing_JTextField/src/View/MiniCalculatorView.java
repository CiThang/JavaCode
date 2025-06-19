package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MiniCalculatorListener;
import Model.MiniCalculatorModel;

public class MiniCalculatorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiniCalculatorModel miniCalculatorModel;
	private JTextField jTextField_firsValue;
	private JTextField jTextField_secondValue;
	private JTextField jTextField_answer;

	public MiniCalculatorView() throws HeadlessException {
		this.miniCalculatorModel = new MiniCalculatorModel();
		this.init();
	}
	private void init() {
		this.setTitle("Mini Calculator");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		Font font = new Font("Arial", Font.BOLD, 40);
		JLabel jLabel_firstValue = new JLabel("1st Value");
		jLabel_firstValue.setFont(font);
		JLabel jLabel_secondValue = new JLabel("2nd Value");
		jLabel_secondValue.setFont(font);
		JLabel jLabel_answer = new JLabel("Answer");
		jLabel_answer.setFont(font);
		
		jTextField_firsValue = new JTextField(50);
		jTextField_firsValue.setFont(font);
		jTextField_secondValue = new JTextField(50);
		jTextField_secondValue.setFont(font);
		jTextField_answer = new JTextField(50);
		jTextField_answer.setFont(font);
		
		JPanel jPanel_IO = new JPanel();
		jPanel_IO.setLayout(new GridLayout(3,2,10,10));
		jPanel_IO.add(jLabel_firstValue);
		jPanel_IO.add(jTextField_firsValue);
		jPanel_IO.add(jLabel_secondValue);
		jPanel_IO.add(jTextField_secondValue);
		jPanel_IO.add(jLabel_answer);
		jPanel_IO.add(jTextField_answer);
		
		MiniCalculatorListener miniCalculatorListener = new MiniCalculatorListener(this);
		
		JButton jButton_plus = new JButton("+");
		jButton_plus.setFont(font);
		jButton_plus.addActionListener(miniCalculatorListener);
		
		JButton jButton_minus = new JButton("-");
		jButton_minus.setFont(font);
		jButton_minus.addActionListener(miniCalculatorListener);
		
		JButton jButton_multiply = new JButton("*");
		jButton_multiply.setFont(font);
		jButton_multiply.addActionListener(miniCalculatorListener);
		
		JButton jButton_divide = new JButton("/");
		jButton_divide.setFont(font);
		jButton_divide.addActionListener(miniCalculatorListener);
		
		JButton jButton_pow = new JButton("^");
		jButton_pow.setFont(font);
		jButton_pow.addActionListener(miniCalculatorListener);
		
		JButton jButton_mod = new JButton("%");
		jButton_mod.setFont(font);
		jButton_mod.addActionListener(miniCalculatorListener);
		
		JPanel jPanelButton = new JPanel();
		jPanelButton.setLayout(new GridLayout(2,3,10,10));
		jPanelButton.add(jButton_plus);
		jPanelButton.add(jButton_minus);
		jPanelButton.add(jButton_multiply);
		jPanelButton.add(jButton_divide);
		jPanelButton.add(jButton_pow);
		jPanelButton.add(jButton_mod);
		
		
		this.setLayout( new BorderLayout(20,20));
		this.add(jPanel_IO, BorderLayout.CENTER);
		this.add(jPanelButton, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	public void plus() {
		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.plus();
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	} 
	public void minus() {
		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.minus();
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	} 
	public void multiply() {
		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.multiply();
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	} 
	public void divide() {
		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.divide();
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	} 
	public void pow() {
		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.pow();;
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	} 
	public void mod() {
		double firstValue = Double.valueOf(jTextField_firsValue.getText());
		double secondValue = Double.valueOf(jTextField_secondValue.getText());
		this.miniCalculatorModel.setFirsValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);;
		this.miniCalculatorModel.mod();
		this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	} 
}
