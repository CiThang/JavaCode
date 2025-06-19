package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MainSignViewListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainSignView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSignView frame = new MainSignView();
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
	 * Create the frae.
	 */
	public MainSignView() {
		setVisible(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 675, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 213, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ActionListener ac = new MainSignViewListener(this);
		
		URL urlIconNotepad = MainSignView.class.getResource("user.png");
		Image image = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		setIconImage(image);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\anhnenSignMain.jpg"));
		lblNewLabel.setBounds(-33, 0, 721, 203);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(230, 214, 198, 55);
		contentPane.add(lblNewLabel_1);
		
		JButton btnHocSinh = new JButton("HỌC SINH");
		btnHocSinh.setBackground(new Color(255, 255, 255));
		btnHocSinh.setFont(new Font("Arial", Font.BOLD, 18));
		btnHocSinh.setBounds(127, 274, 164, 38);
		btnHocSinh.addActionListener(ac);
		btnHocSinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainSignView.class.getResource("student.png"))));
		contentPane.add(btnHocSinh);
		
		JButton btnGiaoVien = new JButton("GIÁO VIÊN");
		btnGiaoVien.setBackground(new Color(255, 255, 255));
		btnGiaoVien.setFont(new Font("Arial", Font.BOLD, 18));
		btnGiaoVien.setBounds(363, 274, 164, 38);
		btnGiaoVien.addActionListener(ac);
		btnGiaoVien.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainSignView.class.getResource("teacher.png"))));
		contentPane.add(btnGiaoVien);
	}
}
