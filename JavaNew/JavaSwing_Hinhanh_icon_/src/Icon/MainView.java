package Icon;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu menu, submenu;
	JMenuItem i1,i2,i3,i4,i5;
	JMenuBar mb = new JMenuBar();
	private JButton jButton;
	private JLabel jLabel;
	
	public MainView() {
		this.setTitle("Chi thang");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//Set icon => JFrame
		
		URL urlIconNotepad = MainView.class.getResource("Notepad.png");
		Image image = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		
		this.setIconImage(image);
		
		
		
		// JMenuBar
		menu = new JMenu("Menu");
		submenu = new JMenu("Sub Menu");
		submenu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("Menu.16.png"))));
		i1 = new JMenuItem("New");
		i1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("New.png"))));
		i2 = new JMenuItem("Save");
		i2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("Save.png"))));
		i3 = new JMenuItem("Save As");
		i3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("SaveAs.png"))));
		i4 = new JMenuItem("Exit");
		i4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("Exit.png"))));
		i5 = new JMenuItem("Test");
		i5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("Test.png"))));

		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		submenu.add(i4);
		submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);
		
		// JLabel
		jLabel = new JLabel();
		
		// JButton
		jButton = new JButton("Test button");
		jButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("Button.png"))));
		jButton.setFont(new Font("Arial", Font.BOLD, 50));
		jButton.setSize(50,50);
		
		this.setJMenuBar(mb);
		this.add(jLabel, BorderLayout.SOUTH);
		this.add(jButton, BorderLayout.SOUTH);

		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MainView();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi ");
		}
	}
	
}
