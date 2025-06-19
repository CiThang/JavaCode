package Main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class DrawExample extends JFrame {

	public DrawExample() {
		this.setTitle("DrawExample");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPaneDraw jPaneDraw = new JPaneDraw();
		
		this.setLayout(new BorderLayout());
		this.add(jPaneDraw, BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DrawExample();
	}
}
