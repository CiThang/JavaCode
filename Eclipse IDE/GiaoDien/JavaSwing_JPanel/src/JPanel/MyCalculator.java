package JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyCalculator() {
		this.setTitle("My Calculator");
		
		this.setSize(300,600);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		// Tạo ra JTextField: Nơi để ghi 
		JTextField jTextField = new JTextField(20);
		
		// jPanel_head chua jTextField va nam o vi tri chinh giua 
		JPanel jPanel_head = new JPanel();
		jPanel_head.setLayout(new BorderLayout());
		jPanel_head.add(jTextField, BorderLayout.CENTER);
		
		// Tao cac nut bam
		JButton jButton_0 = new JButton("0");
		JButton jButton_1 = new JButton("1");
		JButton jButton_2 = new JButton("2");
		JButton jButton_3 = new JButton("3");
		JButton jButton_4 = new JButton("4");
		JButton jButton_5 = new JButton("5");
		JButton jButton_6 = new JButton("6");
		JButton jButton_7 = new JButton("7");
		JButton jButton_8 = new JButton("8");
		JButton jButton_9 = new JButton("9");
		JButton jButton_cong = new JButton("+");
		JButton jButton_tru = new JButton("-");
		JButton jButton_nhan = new JButton("*");
		JButton jButton_chia = new JButton("/");
		JButton jButton_bang = new JButton("=");
		
		
		// jPanel_buttons chua cac JButton vua moi tao o tren
		JPanel jPanel_buttons = new JPanel();
		
		// Xap xep cac JButton vua moi tao vao jPanel_buttons 
		jPanel_buttons.setLayout(new GridLayout(5,3));
		jPanel_buttons.add(jButton_0);
		jPanel_buttons.add(jButton_1);
		jPanel_buttons.add(jButton_2);
		jPanel_buttons.add(jButton_3);
		jPanel_buttons.add(jButton_4);
		jPanel_buttons.add(jButton_5);
		jPanel_buttons.add(jButton_6);
		jPanel_buttons.add(jButton_7);
		jPanel_buttons.add(jButton_8);
		jPanel_buttons.add(jButton_9);
		jPanel_buttons.add(jButton_cong);
		jPanel_buttons.add(jButton_tru);
		jPanel_buttons.add(jButton_nhan);
		jPanel_buttons.add(jButton_chia);
		jPanel_buttons.add(jButton_bang);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_head, BorderLayout.NORTH);
		this.add(jPanel_buttons, BorderLayout.CENTER);

		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MyCalculator();
		
	}
}
