package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MyColorListener;
import Model.MyColorModel;

public class MyColorView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyColorModel myColorModel;
	private JLabel jLabel;
	
	public MyColorView() {
		this.myColorModel = new MyColorModel();
		this.init();
	}
	public void init() {
		this.setTitle("My Color");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font_text = new Font("Time new Roman", Font.BOLD, 40);
		jLabel = new JLabel("TEXT,..........");
		jLabel.setFont(font_text);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2,3,20,20));
		
		MyColorListener myColorListener = new MyColorListener(this);
		
		// Foreground
		JButton jButton_red = new JButton("Red Text");
		jButton_red.setFont(font);
		jButton_red.setForeground(Color.RED);
		jButton_red.setBackground(Color.WHITE);
		jButton_red.addActionListener(myColorListener);
		
		JButton jButton_yellow = new JButton("Yellow Text");
		jButton_yellow.setFont(font);
		jButton_yellow.setForeground(Color.YELLOW);
		jButton_yellow.setBackground(Color.WHITE);
		jButton_yellow.addActionListener(myColorListener);
		
		JButton jButton_green = new JButton("Green Text");
		jButton_green.setFont(font);
		jButton_green.setForeground(Color.GREEN);
		jButton_green.setBackground(Color.WHITE);
		jButton_green.addActionListener(myColorListener);
		
		// Background
		JButton jButton_background_red = new JButton("Red Background");
		jButton_background_red.setFont(font);
		jButton_background_red.setBackground(Color.RED);
		jButton_background_red.setOpaque(true);
		jButton_background_red.setBorderPainted(false);
		jButton_background_red.addActionListener(myColorListener);
		
		JButton jButton_background_yellow = new JButton("Yellow Background");
		jButton_background_yellow.setFont(font);
		jButton_background_yellow.setBackground(Color.YELLOW);
		jButton_background_yellow.setOpaque(true);
		jButton_background_yellow.setBorderPainted(false);
		jButton_background_yellow.addActionListener(myColorListener);
		
		JButton jButton_background_green = new JButton("Green Background");
		jButton_background_green.setFont(font);
		jButton_background_green.setBackground(Color.GREEN);
		jButton_background_green.setOpaque(true);
		jButton_background_green.setBorderPainted(false);
		jButton_background_green.addActionListener(myColorListener);
		
		jPanel.add(jButton_red);
		jPanel.add(jButton_yellow);
		jPanel.add(jButton_green);
		jPanel.add(jButton_background_red);
		jPanel.add(jButton_background_yellow);
		jPanel.add(jButton_background_green);
		
		this.setLayout(new BorderLayout());
		this.add(jLabel, BorderLayout.NORTH);
		this.add(jPanel, BorderLayout.CENTER);

		this.setVisible(true);
	}
	public void changeTextColor(Color color) {
		this.jLabel.setForeground(color);	
	}
	public void changeBackgroundColor(Color color) {
		this.jLabel.setBackground(color);
		this.jLabel.setOpaque(true);
	}
}
