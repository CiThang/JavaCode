package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.TeacherSignListener;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TeacherSignView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSignView frame = new TeacherSignView();
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
	public TeacherSignView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ActionListener ac = new TeacherSignListener(this);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\Aha-Soft-Free-Large-Boss-Teacher.128.png"));
		lblNewLabel.setBounds(128, 0, 136, 166);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GIÁO VIÊN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1.setBounds(128, 173, 136, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã giáo viên");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_2.setBounds(46, 232, 100, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(46, 288, 85, 31);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(147, 232, 169, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 288, 169, 31);
		contentPane.add(passwordField);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\user.png"));
		btnDangNhap.setBounds(63, 350, 115, 31);
		btnDangNhap.addActionListener(ac);
		contentPane.add(btnDangNhap);
		
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\exit.png"));
		btnThoat.setBounds(202, 350, 115, 31);
		btnThoat.addActionListener(ac);
		contentPane.add(btnThoat);
		

		URL urlIconNotepad = MainSignView.class.getResource("user.png");
		Image image = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		setIconImage(image);
		
		
		
	}

}
