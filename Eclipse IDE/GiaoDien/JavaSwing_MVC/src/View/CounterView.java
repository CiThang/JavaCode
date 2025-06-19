package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.CounterListener;
import Model.CounterModel;

public class CounterView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CounterModel counterModel;
	// Bien cuc bo	
	private JButton jButton_up;
	private JButton jButton_down;
	private JButton jButton_reset;
	private JLabel jLabel_value;
	public CounterView() {
		this.counterModel = new CounterModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("Counter ");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		
		ActionListener ac = new CounterListener(this);
		
		jButton_up = new JButton("Up");
		jButton_up.addActionListener(ac);
		jButton_down = new JButton("Down");
		jButton_down.addActionListener(ac);
		jButton_reset = new JButton("Reset");
		jButton_reset.addActionListener(ac);
		jLabel_value = new JLabel(this.counterModel.getValue()+"", JLabel.CENTER);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jButton_up, BorderLayout.WEST);
		jPanel.add(jLabel_value, BorderLayout.CENTER);
		jPanel.add(jButton_down, BorderLayout.EAST);
		jPanel.add(jButton_reset, BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	public void increment() {
		this.counterModel.incresment();
		this.jLabel_value.setText(this.counterModel.getValue()+"");
	}
	public void decrement() {
		this.counterModel.decrement();
		this.jLabel_value.setText(this.counterModel.getValue()+"");
	}
	public void reset() {
		this.counterModel.reset();
		this.jLabel_value.setText(this.counterModel.getValue()+"");
	}

	
	
	
	
}
