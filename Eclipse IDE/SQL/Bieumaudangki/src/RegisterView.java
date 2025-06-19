import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Scrollbar;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class RegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldHoTen;
	public JTextField textFieldngaysinh;
	public JTextField textFieldEmail;
	public JTextField textFieldSDT;
	public JTextField textFieldQuocgia;
	public JTextArea textArea;
	public JDateChooser jDateChooser;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new RegisterController(this);
		Label labelDangKyThongtin = new Label("Đăng kí thông tin");
		labelDangKyThongtin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		labelDangKyThongtin.setBounds(193, 10, 215, 60);
		contentPane.add(labelDangKyThongtin);
		
		Label label = new Label("Họ và tên");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(25, 74, 82, 31);
		contentPane.add(label);
		
		Label label_1 = new Label("Ngày sinh");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(25, 122, 82, 31);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Email");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(25, 169, 82, 31);
		contentPane.add(label_2);
		
		Label label_3 = new Label("SDT");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(25, 216, 82, 31);
		contentPane.add(label_3);
		
		Label label_3_1 = new Label("Giới tính");
		label_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_3_1.setBounds(25, 262, 82, 31);
		contentPane.add(label_3_1);
		
		Label label_3_1_1 = new Label("Quốc gia");
		label_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_3_1_1.setBounds(25, 311, 82, 31);
		contentPane.add(label_3_1_1);
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setBounds(127, 76, 156, 29);
		contentPane.add(textFieldHoTen);
		textFieldHoTen.setColumns(10);
		
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(127, 171, 156, 29);
		contentPane.add(textFieldEmail);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(127, 218, 156, 29);
		contentPane.add(textFieldSDT);
		
		textFieldQuocgia = new JTextField();
		textFieldQuocgia.setColumns(10);
		textFieldQuocgia.setBounds(127, 313, 156, 29);
		contentPane.add(textFieldQuocgia);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(125, 270, 68, 23);
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(215, 270, 68, 23);
		contentPane.add(rdbtnNu);
		
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(rdbtnNam);
		btButtonGroup.add(rdbtnNu);
		
		JButton btnDangki = new JButton("Đăng kí");
		btnDangki.setBounds(173, 373, 89, 23);
		contentPane.add(btnDangki);
		btnDangki.addActionListener(ac);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(319, 373, 89, 23);
		contentPane.add(btnHuy);
		btnHuy.addActionListener(ac);
		
		Label label_4 = new Label("Mỗ tả bản thân");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(419, 74, 128, 31);
		contentPane.add(label_4);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setBounds(352, 122, 239, 211);
		contentPane.add(textArea);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(352, 122, 239, 211);
		contentPane.add(scrollPane);
		
		jDateChooser = new JDateChooser();
		jDateChooser.setBounds(127, 124, 156, 29);
		contentPane.add(jDateChooser);
	}

	public RegisterModel laythongtin() {
		String hoten = textFieldHoTen.getText();
		Date ngaysinh = jDateChooser.getDate();
		String email = textFieldEmail.getText();
		int sdt = Integer.valueOf(textFieldSDT.getText());
		boolean gioiTinh = true;
		if (this.rdbtnNam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtnNu.isSelected()) {
			gioiTinh = false;
		}
		String quocgia = textFieldQuocgia.getText();
		String mota = textArea.getText();
		return new RegisterModel(hoten, ngaysinh, email, sdt, gioiTinh, quocgia, mota);
	}

	public void detele() {
		textFieldHoTen.setText("");
		jDateChooser.setDate(null);
		textFieldEmail.setText("");
		textFieldSDT.setText("");
		rdbtnNam.setSelected(false);
		rdbtnNu.setSelected(false);
		textFieldQuocgia.setText("");
		textArea.setText("");
	}
}
