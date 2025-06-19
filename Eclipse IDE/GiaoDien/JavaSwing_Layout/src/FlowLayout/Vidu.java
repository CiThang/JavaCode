package FlowLayout;

import java.awt.FlowLayout;

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
		
//		FlowLayout flowLayout = new FlowLayout();
		FlowLayout flowLayout_1 = new FlowLayout(FlowLayout.RIGHT);
//		FlowLayout flowLayout_2 = new FlowLayout(FlowLayout.CENTER, 10,10);

//		this.setLayout(flowLayout);
		this.setLayout(flowLayout_1);
//		this.setLayout(flowLayout_2);
		
		JButton jButton_1 = new JButton("1");
		JButton jButton_2 = new JButton("2");
		JButton jButton_3 = new JButton("3");
		
		this.add(jButton_1);
		this.add(jButton_2);
		this.add(jButton_3);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Vidu();
	}
}
