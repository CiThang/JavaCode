package Baith2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test extends JFrame {

	public static void main(String[] args) {
		JFrame jF = new JFrame();
		jF.setTitle("Calculator");
		jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jF.setSize(300,500);
		jF.setLocationRelativeTo(null);
		
		JPanel jPanel = new JPanel();
		JTextField jTextField = new JTextField();
		Button[] buttonarray = new Button[16];
//		JButton jB1 = new JButton("1");
//		JButton jB2 = new JButton("2");
//		JButton jB3 = new JButton("3");
//		JButton jB4 = new JButton("4");
//		JButton jB5 = new JButton("5");
//		JButton jB6 = new JButton("6");
//		JButton jB7 = new JButton("7");
//		JButton jB8 = new JButton("8");
//		JButton jB9 = new JButton("9");
//		JButton jB0 = new JButton("0");
//		JButton jBcham = new JButton(".");
//		JButton jBcong = new JButton("+");
//		JButton jBtru = new JButton("-");
//		JButton jBnhan = new JButton("*");
//		JButton jBchia = new JButton("/");
//		JButton jBbang = new JButton("=");
		Font font = new Font("Arial", Font.BOLD, 20);
		
		buttonarray[0] = new Button("1");
		buttonarray[1] = new Button("2");
		buttonarray[2] = new Button("3");
		buttonarray[3] = new Button("+");
		buttonarray[4] = new Button("4");
		buttonarray[5] = new Button("5");
		buttonarray[6] = new Button("6");
		buttonarray[7] = new Button("-");
		buttonarray[8] = new Button("7");
		buttonarray[9] = new Button("8");
		buttonarray[10] = new Button("9");
		buttonarray[11] = new Button("*");
		buttonarray[12] = new Button("0");
		buttonarray[13] = new Button(".");
		buttonarray[14] = new Button("=");
		buttonarray[15] = new Button("/");
		
		
		
		jPanel.setLayout(new GridLayout(4,4));
//		jPanel.add(jB1);
//		jPanel.add(jB2);
//		jPanel.add(jB3);
//		jPanel.add(jBcong);
//		jPanel.add(jB4);
//		jPanel.add(jB5);
//		jPanel.add(jB6);
//		jPanel.add(jBtru);
//		jPanel.add(jB7);
//		jPanel.add(jB8);
//		jPanel.add(jB9);
//		jPanel.add(jBnhan);
//		jPanel.add(jB0);
//		jPanel.add(jBcham);
//		jPanel.add(jBbang);
//		jPanel.add(jBchia);
		
		for(int i = 0 ; i<16 ; i++) {
			buttonarray[i].setFont(font);
			jPanel.add(buttonarray[i]);
		}
		
		jF.setLayout(new BorderLayout());
		jF.add(jPanel, BorderLayout.CENTER);
		jF.add(jTextField, BorderLayout.NORTH);

		jF.setVisible(true);
		
	}
	
}
