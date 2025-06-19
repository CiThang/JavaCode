package bai3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JFrame {

	private static JButton button;

	public static void main(String[] args) {
		
		
		JFrame f = new JFrame();
		f.setTitle("The Font View");
		f.setSize(500,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);

		JPanel jPanel1 = new JPanel();
		JLabel jLabel = new JLabel("Food to be placed here");
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(jLabel, BorderLayout.CENTER);

		JPanel jPanel2 = new JPanel();
		
		JTextField jTextField = new JTextField("Time to be displayed here");
		
		JPanel jPanel21 = new JPanel();
		jPanel21.setLayout(new GridLayout(4,3));
		for(int i=0 ; i<=9; i++) {
			button = new JButton(""+i);
			jPanel21.add(button);
		}
		JButton jButtonstart = new JButton("Start");
		JButton jButtonstop = new JButton("Stop");
		jPanel21.add(jButtonstart);
		jPanel21.add(jButtonstop);
		
		jPanel2.setLayout(new BorderLayout());
		jPanel2.add(jTextField, BorderLayout.NORTH);
		jPanel2.add(jPanel21,BorderLayout.CENTER);
		
		f.setLayout(new GridLayout());
		f.add(jPanel1);
		f.add(jPanel2);
		f.setVisible(true);
		
		
	}
}
