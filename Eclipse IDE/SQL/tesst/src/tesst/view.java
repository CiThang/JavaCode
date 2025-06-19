package tesst;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel panel;
	public JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ActionListener ac = new controller(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("2");
		btn1.setBounds(157, 285, 89, 23);
		contentPane.add(btn1);
		btn1.addActionListener(ac);
		
		JButton btn2 = new JButton("1");
		btn2.setBounds(356, 285, 89, 23);
		contentPane.add(btn2);
		btn2.addActionListener(ac);
		
		panel_1 = new JPanel();
		panel_1.setBounds(70, 11, 433, 251);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(35, 7, 505, 267);
		contentPane.add(panel);
		
		panel_1.setVisible(false);
		panel.setVisible(false);
		JLabel lblNewLabel = new JLabel("1");
		panel.add(lblNewLabel);
		
	}
}
