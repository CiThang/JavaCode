package BorderLayout;

import java.awt.BorderLayout;
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
		
//		BorderLayout borderLayout = new BorderLayout();
		BorderLayout borderLayout_1 = new BorderLayout( 50, 50);
//		this.setLayout(borderLayout);
		this.setLayout(borderLayout_1);

		
		JButton jButton_1 = new JButton("1");
		JButton jButton_2 = new JButton("2");
		JButton jButton_3 = new JButton("3");
		JButton jButton_4 = new JButton("4");
		JButton jButton_5 = new JButton("5");
		
		
		this.add(jButton_1, BorderLayout.NORTH);
		this.add(jButton_2, BorderLayout.SOUTH);
		this.add(jButton_3, BorderLayout.WEST);
		this.add(jButton_4, BorderLayout.EAST);
		this.add(jButton_5, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Vidu();
	}
}
