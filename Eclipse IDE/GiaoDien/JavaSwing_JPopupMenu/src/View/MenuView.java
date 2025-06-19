package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.KeyStore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import Controller.MenuController;
import Controller.MenuExampleMouseListener;

public class MenuView  extends JFrame{

	private JLabel jLabel;
	public JPopupMenu jPopupMenu;

	public MenuView() {
		this.setTitle("Menu Example");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		MenuController menuController = new MenuController(this);
		
		// Tao thanh menu
		JMenuBar jMenuBar = new JMenuBar();
		
		// Tao 1 menu 
		JMenu jMenu_file = new JMenu("File");
		// Tao cac menu con 
		JMenuItem jMenuItem_new = new JMenuItem("New",KeyEvent.VK_N);
		// Them phim tat
		jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK)); 
		jMenuItem_new.addActionListener(menuController);
		JMenuItem jMenuItem_open = new JMenuItem("Open",KeyEvent.VK_O);
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		jMenuItem_open.addActionListener(menuController);
		JMenuItem jMenuItem_exit = new JMenuItem("Exit",KeyEvent.VK_X);
		jMenuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.ALT_DOWN_MASK));
		jMenuItem_exit.addActionListener(menuController);
		jMenu_file.add(jMenuItem_new);
		jMenu_file.add(jMenuItem_open);
		jMenu_file.addSeparator();
		jMenu_file.add(jMenuItem_exit);

		JMenu jMenu_help = new JMenu("Help");
		jMenu_help.setMnemonic(KeyEvent.VK_H);
		JMenuItem jMenuItem_welcome = new JMenuItem("Welcome");
		jMenuItem_welcome.addActionListener(menuController);
		jMenu_help.add(jMenuItem_welcome);
		
		jMenuBar.add(jMenu_file);
		jMenuBar.add(jMenu_help);
		
		// Them thanh menu vao chuong trinh
		this.setJMenuBar(jMenuBar);
		
		// Tao ToolBar (Thanh cong cu)
		JToolBar jToolBar = new JToolBar();
		JButton jButton_Undo = new JButton("Undo");
		jButton_Undo.addActionListener(menuController);
		JButton jButton_Redo = new JButton("Redo");
		jButton_Redo.addActionListener(menuController);
		JButton jButton_Copy = new JButton("Copy");
		jButton_Copy.addActionListener(menuController);
		JButton jButton_Cut = new JButton("Cut");
		jButton_Cut.addActionListener(menuController);
		JButton jButton_Paste = new JButton("Paste");
		jButton_Paste.addActionListener(menuController);
		jToolBar.add(jButton_Undo);
		jToolBar.add(jButton_Redo);
		jToolBar.add(jButton_Copy);
		jToolBar.add(jButton_Cut);
		jToolBar.add(jButton_Paste);
		
		this.add(jToolBar, BorderLayout.NORTH);
		
		// Menu chuot phai JPoupMenu
		
		jPopupMenu = new JPopupMenu();
		
		JMenu jMenuPoupFont = new JMenu("Font");
		JMenuItem jMenuItemType = new JMenuItem("Type");
		jMenuItemType.addActionListener(menuController);
		JMenuItem jMenuItemSize = new JMenuItem("Size");
		jMenuItemSize.addActionListener(menuController);
		jMenuPoupFont.add(jMenuItemSize);
		jMenuPoupFont.add(jMenuItemType);
		
		JMenuItem jMenuItemCut = new JMenuItem("Cut");
		jMenuItemCut.addActionListener(menuController);
		JMenuItem jMenuItemCopy = new JMenuItem("Copy");
		jMenuItemCopy.addActionListener(menuController);
		JMenuItem jMenuItemPaste = new JMenuItem("Paste");
		jMenuItemPaste.addActionListener(menuController);
		
		jPopupMenu.add(jMenuPoupFont);
		jPopupMenu.add(jMenuItemCut);
		jPopupMenu.add(jMenuItemCopy);
		jPopupMenu.add(jMenuItemPaste);
		this.add(jPopupMenu);
		
		MenuExampleMouseListener exampleMouseListener = new MenuExampleMouseListener(this);
		this.addMouseListener(exampleMouseListener);
		
		
		// Tao Label hien thi
		Font font = new Font("Arial", Font.BOLD, 50);
		jLabel = new JLabel();
		
		
		this.add(jLabel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	public void setTextJLabel(String s) {
		this.jLabel.setText(s);
		
	}
	
	
}
