package View;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.MenuController;

public class MenuView  extends JFrame{

	private JLabel jLabel;

	public MenuView() {
		this.setTitle("Menu Example");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		MenuController menuController = new MenuController(this);
		
		// Tao thanh menu
		JMenuBar jMenuBar = new JMenuBar();
		
		// Tao 1 menu 
		JMenu jMenu_file = new JMenu("File");
		// Tao cac menu con 
		JMenuItem jMenuItem_new = new JMenuItem("New");
		jMenuItem_new.addActionListener(menuController);
		JMenuItem jMenuItem_open = new JMenuItem("Open");
		jMenuItem_open.addActionListener(menuController);
		JMenuItem jMenuItem_exit = new JMenuItem("Exit");
		jMenuItem_exit.addActionListener(menuController);
		jMenu_file.add(jMenuItem_new);
		jMenu_file.add(jMenuItem_open);
		jMenu_file.addSeparator();
		jMenu_file.add(jMenuItem_exit);

		JMenu jMenu_help = new JMenu("Help");
		JMenuItem jMenuItem_welcome = new JMenuItem("Welcome");
		jMenuItem_welcome.addActionListener(menuController);
		jMenu_help.add(jMenuItem_welcome);
		
		jMenuBar.add(jMenu_file);
		jMenuBar.add(jMenu_help);
		
		// Them thanh menu vao chuong trinh
		this.setJMenuBar(jMenuBar);
		
		// Tao Label hien thi
		Font font = new Font("Arial", Font.BOLD, 50);
		jLabel = new JLabel();
		
		this.setLayout(new BorderLayout());
		this.add(jLabel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	public void setTextJLabel(String s) {
		this.jLabel.setText(s);
	}
	
	
}
