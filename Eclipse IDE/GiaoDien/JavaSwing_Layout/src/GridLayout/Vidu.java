package GridLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Vidu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vidu() {
		this.setTitle("FlowLayout");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
//		GridLayout gridLayout = new GridLayout();
//		GridLayout gridLayout_1 = new GridLayout(3,3);
		GridLayout gridLayout_2 = new GridLayout(3,3,25,25);
//		this.setLayout(gridLayout);
//		this.setLayout(gridLayout_1);
		this.setLayout(gridLayout_2);

		
//		JButton jButton_1 = new JButton("1");
//		JButton jButton_2 = new JButton("2");
//		JButton jButton_3 = new JButton("3");
//		JButton jButton_4 = new JButton("4");
//		JButton jButton_5 = new JButton("5");
//		JButton jButton_6 = new JButton("6");
//		JButton jButton_7 = new JButton("7");
//		JButton jButton_8 = new JButton("8");
//		JButton jButton_9 = new JButton("9");
//		
//		this.add(jButton_1);
//		this.add(jButton_2);
//		this.add(jButton_3);
//		this.add(jButton_4);
//		this.add(jButton_5);
//		this.add(jButton_6);
//		this.add(jButton_7);
//		this.add(jButton_8);
//		this.add(jButton_9);
		
		for(int i=0 ; i<=8; i++) {
			JButton jButton = new JButton(i+"");
			this.add(jButton);
		}
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Vidu();
	}
}
