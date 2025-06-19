package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.StudentSignListener;
import Model.Student;
import Model.StudentAccount;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class StudentSignView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldMaHS;
	public JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSignView frame = new StudentSignView();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentSignView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new StudentSignListener(this);
		
		URL urlIconNotepad = MainSignView.class.getResource("user.png");
		Image image = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		setIconImage(image);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\Webalys-Kameleon.pics-Student-3.128.png"));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(128, 11, 136, 166);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Mã học sinh");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(46, 232, 100, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Arial", Font.BOLD, 17));
		lblMtKhu.setBounds(46, 288, 85, 31);
		contentPane.add(lblMtKhu);
		
		textFieldMaHS = new JTextField();
		textFieldMaHS.setBounds(147, 232, 169, 31);
		contentPane.add(textFieldMaHS);
		textFieldMaHS.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 288, 169, 31);
		contentPane.add(passwordField);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(StudentSystemView.class.getResource("user.png"))));
		btnDangNhap.setBounds(59, 350, 119, 31);
		contentPane.add(btnDangNhap);
		btnDangNhap.addActionListener(ac);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(202, 350, 119, 31);
		btnThoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(StudentSystemView.class.getResource("exit.png"))));
		contentPane.add(btnThoat);
		btnThoat.addActionListener(ac);
		
		JLabel lblNewLabel_2 = new JLabel("HỌC SINH");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(128, 173, 136, 31);
		contentPane.add(lblNewLabel_2);
		
		
		
	}
}
