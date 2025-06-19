package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.TeacherSignListener;
import Controller.TeacherSystemListener;
import DAO.TeacherSystemDao;
import Model.Student;
import Model.StudentManagement;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class TeacherSystemView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldtim;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public ButtonGroup btnGioiTinh;
	public JLabel lblHOTEN;
	public JLabel lblLOP;
	public JLabel lblNGAYSINH;
	public JLabel lblDIACHI;
	public JLabel lblQUEQUAN;
	public JLabel lblDiemToan;
	public JLabel lblimDiemvan;
	public JLabel lblimDiemAnh;
	public Panel panelThongtin;
	public JLabel lblAnh;
	public StudentManagement stm = new StudentManagement(TeacherSystemDao.getInstance().Showlist());
	public JTable table;
	public JTextField textFieldmahocsinh;
	public JTextField textFieldngoaingu;
	public JTextField textFieldVan;
	public JTextField textFieldToan;
	public JComboBox comboBoxTimKiem;
	public JComboBox comboBoxXapxep;
	public JPanel panelChinh;
	public JLabel lblNewLabel_2;
	public JLabel lblMaGiaoVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSystemView frame = new TeacherSystemView();
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
	public TeacherSystemView() {
		setTitle("Hệ thống cổng thông tin");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 927, 603);
		setIconImage(Toolkit.getDefaultToolkit().createImage(TeacherSystemView.class.getResource("teacher.png")));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		

		
		
		ActionListener ac = new TeacherSystemListener(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelChinh = new JPanel();
		panelChinh.setBackground(new Color(255, 255, 255));

		panelChinh.setLayout(null);

		JLabel lblNewLabeltim = new JLabel("Tìm kiếm");
		lblNewLabeltim.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabeltim.setBounds(108, 23, 97, 27);
		panelChinh.add(lblNewLabeltim);

		JLabel lblNewLabelXapxep = new JLabel("Xắp xếp");
		lblNewLabelXapxep.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelXapxep.setBounds(108, 69, 97, 27);
		panelChinh.add(lblNewLabelXapxep);

		comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setBounds(215, 24, 180, 27);
		comboBoxTimKiem.addItem("");
		comboBoxTimKiem.addItem("Điểm toán cao nhất");
		comboBoxTimKiem.addItem("Điểm ngữ văn cao nhất");
		comboBoxTimKiem.addItem("Điểm ngoại ngữ cao nhất");
		panelChinh.add(comboBoxTimKiem);

		comboBoxXapxep = new JComboBox();
		comboBoxXapxep.addItem("");
		comboBoxXapxep.addItem("Điểm toán từ cao đến thấp");
		comboBoxXapxep.addItem("Điểm ngữ văn từ cao đến thấp");
		comboBoxXapxep.addItem("Điểm ngoại ngữ từ cao đến thấp");

		comboBoxXapxep.setBounds(215, 72, 180, 27);

		panelChinh.add(comboBoxXapxep);

		JButton btntimkiem = new JButton("Tìm kiếm");
		btntimkiem.setBackground(new Color(255, 255, 128));
		btntimkiem.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\find.png"));
		btntimkiem.setFont(new Font("Arial", Font.PLAIN, 13));
		btntimkiem.setBounds(432, 24, 112, 27);
		btntimkiem.addActionListener(ac);
		panelChinh.add(btntimkiem);

		JButton btnxapxep = new JButton("Sắp xếp");
		btnxapxep.setBackground(new Color(255, 255, 128));
		btnxapxep.setFont(new Font("Arial", Font.PLAIN, 13));
		btnxapxep.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\sapxep.png"));
		btnxapxep.setBounds(432, 72, 112, 27);
		btnxapxep.addActionListener(ac);
		panelChinh.add(btnxapxep);

		JButton btnhuytimkiem = new JButton("Hủy tìm kiếm");
		btnhuytimkiem.setBackground(new Color(255, 255, 128));
		btnhuytimkiem.setFont(new Font("Arial", Font.PLAIN, 13));
		btnhuytimkiem.setBounds(568, 25, 112, 27);
		btnhuytimkiem.addActionListener(ac);
		panelChinh.add(btnhuytimkiem);

		JButton btnhuyxapxep = new JButton("Hủy sắp xếp");
		btnhuyxapxep.setBackground(new Color(255, 255, 128));
		btnhuyxapxep.setFont(new Font("Arial", Font.PLAIN, 13));
		btnhuyxapxep.setBounds(568, 70, 112, 27);
		btnhuyxapxep.addActionListener(ac);
		panelChinh.add(btnhuyxapxep);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 h\u1ECDc sinh",
				"H\u1ECD t\u00EAn", "L\u1EDBp", "To\u00E1n", "Ng\u1EEF v\u0103n", "Ngo\u1EA1i ng\u1EEF" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(52, 129, 650, 168);
		panelChinh.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Mã học sinh");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 354, 218, 43);
		panelChinh.add(lblNewLabel_1);

		textFieldmahocsinh = new JTextField();
		textFieldmahocsinh.setBounds(176, 354, 113, 43);
		panelChinh.add(textFieldmahocsinh);
		textFieldmahocsinh.setColumns(10);

		JLabel lblNhapdiem = new JLabel("Nhập điểm");
		lblNhapdiem.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhapdiem.setBounds(508, 308, 97, 27);
		panelChinh.add(lblNhapdiem);

		JLabel lblNewLabelToan = new JLabel("Toán");
		lblNewLabelToan.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabelToan.setBounds(430, 360, 79, 27);
		panelChinh.add(lblNewLabelToan);

		JLabel lblNgVn = new JLabel("Ngữ văn");
		lblNgVn.setFont(new Font("Arial", Font.BOLD, 16));
		lblNgVn.setBounds(430, 398, 79, 27);
		panelChinh.add(lblNgVn);

		JLabel lblNewLabelToan_1_1 = new JLabel("Ngoại ngữ");
		lblNewLabelToan_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabelToan_1_1.setBounds(430, 436, 97, 27);
		panelChinh.add(lblNewLabelToan_1_1);

		textFieldngoaingu = new JTextField();
		textFieldngoaingu.setBounds(537, 441, 112, 22);
		panelChinh.add(textFieldngoaingu);
		textFieldngoaingu.setColumns(10);

		textFieldVan = new JTextField();
		textFieldVan.setColumns(10);
		textFieldVan.setBounds(537, 403, 112, 22);
		panelChinh.add(textFieldVan);

		textFieldToan = new JTextField();
		textFieldToan.setColumns(10);
		textFieldToan.setBounds(537, 365, 112, 22);
		panelChinh.add(textFieldToan);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\Custom-Icon-Design-Pretty-Office-7-Save.16.png"));
		btnLuu.setBackground(new Color(0, 128, 255));
		btnLuu.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLuu.setBounds(375, 485, 97, 27);
		btnLuu.addActionListener(ac);
		panelChinh.add(btnLuu);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\Oxygen-Icons.org-Oxygen-Actions-edit-redo.16.png"));
		btnCpNht.setBackground(new Color(0, 128, 255));
		btnCpNht.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCpNht.setBounds(495, 485, 97, 27);
		panelChinh.add(btnCpNht);
		btnCpNht.addActionListener(ac);

		JButton btnhuy = new JButton("Hủy");
		btnhuy.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\exit.png"));
		btnhuy.setFont(new Font("Arial", Font.PLAIN, 11));
		btnhuy.setBackground(new Color(0, 128, 255));
		btnhuy.setBounds(614, 485, 97, 27);
		btnhuy.addActionListener(ac);
		panelChinh.add(btnhuy);
		
		JButton btnThem = new JButton("Thêm học sinh");
		btnThem.setBackground(new Color(0, 128, 255));
		btnThem.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\add.png"));
		btnThem.setFont(new Font("Arial", Font.PLAIN, 11));
		btnThem.setBounds(52, 436, 127, 27);
		panelChinh.add(btnThem);
		btnThem.addActionListener(ac);

		JButton btnXoa = new JButton("Xóa học sinh");
		btnXoa.setBackground(new Color(0, 128, 255));
		btnXoa.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\exit.png"));
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 11));
		btnXoa.setBounds(194, 436, 127, 27);
		panelChinh.add(btnXoa);
		btnXoa.addActionListener(ac);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 911, 22);
		contentPane.add(menuBar);

		JMenu mnTaiKhoan = new JMenu("Tài khoản");
		menuBar.add(mnTaiKhoan);

		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\pass.png"));
		mntmDoiMatKhau.addActionListener(ac);
		mnTaiKhoan.add(mntmDoiMatKhau);

		JMenuItem mntmDangxuat = new JMenuItem("Đăng xuất");
		mntmDangxuat.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\exit.png"));
		mnTaiKhoan.add(mntmDangxuat);
		mntmDangxuat.addActionListener(ac);

		JMenu mnNewMenu_1 = new JMenu("Hỗ trợ");
		menuBar.add(mnNewMenu_1);

		JMenuItem Ykienphanhoi = new JMenuItem("Ý kiến phản hồi");
		Ykienphanhoi.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\Comment.png"));
		mnNewMenu_1.add(Ykienphanhoi);
		Ykienphanhoi.addActionListener(ac);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 21, 165, 543);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\Aha-Soft-Free-Large-Boss-Teacher.128.png"));
		lblNewLabel.setBounds(24, 21, 151, 157);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Thông tin");
		btnNewButton.setIcon(new ImageIcon(
				"D:\\Documents\\ĐỒ ÁN JAVA\\Custom-Icon-Design-Pretty-Office-2-Personal-information.16.png"));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 448, 165, 23);
		btnNewButton.addActionListener(ac);
		panel.add(btnNewButton);

		JButton btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\home.png"));
		btnTrangChu.setFont(new Font("Arial", Font.BOLD, 13));
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setBounds(0, 359, 165, 23);
		btnTrangChu.addActionListener(ac);
		panel.add(btnTrangChu);
		btnGioiTinh = new ButtonGroup();

		JButton btnBngim = new JButton("Bảng điểm");
		btnBngim.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\table.png"));
		btnBngim.setFont(new Font("Arial", Font.BOLD, 13));
		btnBngim.setBackground(Color.WHITE);
		btnBngim.setBounds(0, 403, 165, 23);
		btnBngim.addActionListener(ac);
		panel.add(btnBngim);
		
		JLabel lblNewLabel_3 = new JLabel("Mã giáo viên :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_3.setBounds(17, 199, 79, 23);
		panel.add(lblNewLabel_3);
		
		lblMaGiaoVien = new JLabel("");
		lblMaGiaoVien.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblMaGiaoVien.setBounds(98, 199, 57, 23);
		panel.add(lblMaGiaoVien);

		panelThongtin = new Panel();
		

		panelThongtin.setBackground(new Color(255, 255, 255));
		panelThongtin.setVisible(false);
		panelThongtin.setLayout(null);

		Label label = new Label("Nhập mã học sinh");
		label.setFont(new Font("Arial", Font.BOLD, 17));
		label.setAlignment(Label.CENTER);
		label.setBounds(36, 22, 174, 32);
		panelThongtin.add(label);

		textFieldtim = new JTextField();
		textFieldtim.setBounds(216, 22, 146, 32);
		panelThongtin.add(textFieldtim);
		textFieldtim.setColumns(10);

		JButton btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\find.png"));
		btnTim.setBackground(new Color(255, 255, 128));
		btnTim.setFont(new Font("Arial", Font.PLAIN, 13));
		btnTim.setBounds(394, 22, 100, 32);
		btnTim.addActionListener(ac);
		panelThongtin.add(btnTim);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\exit.png"));
		btnHuyTim.setFont(new Font("Arial", Font.PLAIN, 13));
		btnHuyTim.setBackground(new Color(255, 255, 128));
		btnHuyTim.setBounds(515, 22, 100, 32);
		btnHuyTim.addActionListener(ac);
		panelThongtin.add(btnHuyTim);
		
		JLabel lblHoten = new JLabel("Họ và tên ");
		lblHoten.setFont(new Font("Arial", Font.BOLD, 17));
		lblHoten.setBounds(260, 103, 89, 25);
		panelThongtin.add(lblHoten);

		JLabel lbLop = new JLabel("Lớp");
		lbLop.setFont(new Font("Arial", Font.BOLD, 17));
		lbLop.setBounds(260, 154, 89, 25);
		panelThongtin.add(lbLop);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 17));
		lblGioiTinh.setBounds(260, 208, 89, 25);
		panelThongtin.add(lblGioiTinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Arial", Font.BOLD, 13));
		rdbtnNam.setBackground(new Color(255, 255, 255));
		rdbtnNam.setBounds(379, 210, 63, 23);
		panelThongtin.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nu");
		rdbtnNu.setFont(new Font("Arial", Font.BOLD, 13));
		rdbtnNu.setBackground(new Color(255, 255, 255));
		rdbtnNu.setBounds(473, 210, 63, 23);
		panelThongtin.add(rdbtnNu);
		btnGioiTinh.add(rdbtnNam);
		btnGioiTinh.add(rdbtnNu);

		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Arial", Font.BOLD, 17));
		lblNgySinh.setBounds(260, 265, 89, 25);
		panelThongtin.add(lblNgySinh);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Arial", Font.BOLD, 17));
		lblaCh.setBounds(260, 322, 89, 25);
		panelThongtin.add(lblaCh);

		JLabel lblQuQun = new JLabel("Quê quán");
		lblQuQun.setFont(new Font("Arial", Font.BOLD, 17));
		lblQuQun.setBounds(260, 376, 89, 25);
		panelThongtin.add(lblQuQun);

		lblHOTEN = new JLabel("");
		lblHOTEN.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblHOTEN.setBounds(379, 103, 221, 25);
		panelThongtin.add(lblHOTEN);

		lblLOP = new JLabel("");
		lblLOP.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblLOP.setBounds(379, 154, 221, 25);
		panelThongtin.add(lblLOP);

		lblNGAYSINH = new JLabel("");
		lblNGAYSINH.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblNGAYSINH.setBounds(379, 265, 221, 25);
		panelThongtin.add(lblNGAYSINH);

		lblDIACHI = new JLabel("");
		lblDIACHI.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblDIACHI.setBounds(379, 322, 221, 25);
		panelThongtin.add(lblDIACHI);

		lblQUEQUAN = new JLabel("");
		lblQUEQUAN.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblQUEQUAN.setBounds(379, 376, 221, 25);
		panelThongtin.add(lblQUEQUAN);

		JLabel lblim = new JLabel("Điểm ");
		lblim.setFont(new Font("Arial", Font.BOLD, 17));
		lblim.setBounds(260, 431, 89, 25);
		panelThongtin.add(lblim);

		JLabel lblTon = new JLabel("Toán");
		lblTon.setFont(new Font("Arial", Font.BOLD, 17));
		lblTon.setBounds(405, 431, 52, 25);
		panelThongtin.add(lblTon);

		JLabel lblim_1_1 = new JLabel("Ngữ văn");
		lblim_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblim_1_1.setBounds(511, 431, 89, 25);
		panelThongtin.add(lblim_1_1);

		JLabel lblim_1_1_1 = new JLabel("Ngoại ngữ");
		lblim_1_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblim_1_1_1.setBounds(628, 431, 89, 25);
		panelThongtin.add(lblim_1_1_1);

		lblDiemToan = new JLabel("");
		lblDiemToan.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblDiemToan.setBounds(415, 467, 52, 25);
		panelThongtin.add(lblDiemToan);

		lblimDiemvan = new JLabel("");
		lblimDiemvan.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblimDiemvan.setBounds(521, 467, 57, 25);
		panelThongtin.add(lblimDiemvan);

		lblimDiemAnh = new JLabel("");
		lblimDiemAnh.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblimDiemAnh.setBounds(638, 467, 63, 25);
		panelThongtin.add(lblimDiemAnh);

		lblAnh = new JLabel("          Ảnh");
		lblAnh.setBounds(36, 89, 174, 231);
		panelThongtin.add(lblAnh);
		
		

		// 164, 21, 747, 543
		contentPane.add(panelChinh);	
		contentPane.add(panelThongtin);
		panelThongtin.setBounds(164, 21, 747, 543);
		panelChinh.setBounds(164, 21, 747, 543);
		
		this.panelThongtin.setVisible(false); // false
		this.panelChinh.setVisible(false);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Documents\\ĐỒ ÁN JAVA\\1e3e3738d81b9db4f6b6505b236a996a.gif"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(164, 21, 747, 543);
		contentPane.add(lblNewLabel_2);
		

	}

	public void SetThongTin() {
		this.textFieldtim.setText("");
		this.lblHOTEN.setText("");
		this.lblLOP.setText("");
		this.lblNGAYSINH.setText("");
		this.rdbtnNam.setSelected(false);
		this.rdbtnNu.setSelected(false);
		this.lblDIACHI.setText("");
		this.lblQUEQUAN.setText("");
		this.lblDiemToan.setText("");
		this.lblimDiemvan.setText("");
		this.lblimDiemAnh.setText("");

		this.lblAnh.setIcon(ResizeImage(""));
	}
	public void SetChinh() {
		this.textFieldmahocsinh.setText("");
		this.textFieldToan.setText("");
		this.textFieldngoaingu.setText("");
		this.textFieldVan.setText("");
	}

	public void SetText(Student st) {
		this.lblHOTEN.setText(st.getHoTen());
		this.lblLOP.setText(st.getLop());
		String s_ngaySinh = st.getNgaySinh().getDate() + "/" + (st.getNgaySinh().getMonth() + 1) + "/"
				+ (st.getNgaySinh().getYear() + 1900);
		this.lblNGAYSINH.setText(s_ngaySinh);
		if (st.isGioiTinh()) {
			this.rdbtnNam.setSelected(true);
		} else {
			this.rdbtnNu.setSelected(true);
		}
		this.lblDIACHI.setText(st.getDiaChi());
		this.lblQUEQUAN.setText(st.getQueQuan().getTenTinh());
		this.lblDiemToan.setText(st.getDiemToan() + "");
		this.lblimDiemvan.setText(st.getDiemVan() + "");
		this.lblimDiemAnh.setText(st.getDiemAnh() + "");

		this.lblAnh.setIcon(ResizeImage(st.getAnh()));
	}

	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newimg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newimg);
		return image;

	}

	// Xoa du lieu trong cac TextField
	public void deleteRowId(int mahocsinh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model_table.getRowCount(); i++) {
			if (Integer.parseInt(model_table.getValueAt(i, 0).toString()) == mahocsinh) {
				// Xóa hàng từ mô hình dữ liệu
				model_table.removeRow(i);
				break;
			}
		}

	}

	public Student student(int maHocSinh) {
		Float diemToan = Float.valueOf(this.textFieldToan.getText());
		Float diemVan = Float.valueOf(this.textFieldVan.getText());
		Float diemAnh = Float.valueOf(this.textFieldngoaingu.getText());

		return new Student(maHocSinh, diemToan, diemVan, diemAnh);
	}

	public void themHocSinhVaoTable(Student st) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { st.getMaHocSinh() + "", st.getHoTen(), st.getLop(), st.getDiemToan() + "",
				st.getDiemVan() + "", st.getDiemAnh() + "" });

	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soluongdong = model_table.getRowCount();
			if (soluongdong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		;
	}

	public Student getHocSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		int maHocSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		Float toan = Float.valueOf(model_table.getValueAt(i_row, 3) + "");
		Float van = Float.valueOf(model_table.getValueAt(i_row, 4) + "");
		Float anh = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		return new Student(maHocSinh, toan, van, anh);
	}

	public void hienThiThongTinHocSinhDaChon() {
		Student st = getHocSinhDangChon();
		this.textFieldmahocsinh.setText(st.getMaHocSinh() + "");
		this.textFieldToan.setText(st.getDiemToan() + "");
		this.textFieldVan.setText(st.getDiemVan() + "");
		this.textFieldngoaingu.setText(st.getDiemAnh() + "");
	}

	public void thucHienThem(Student st) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		this.stm.update(st);

		int soluongdong = model_table.getRowCount();
		for (int i = 0; i < soluongdong; i++) {
			String id = model_table.getValueAt(i, 0) + "";
			if (id.equals(st.getMaHocSinh() + "")) {
				model_table.setValueAt(st.getMaHocSinh() + "", i, 0);
				model_table.setValueAt(st.getHoTen(), i, 1);
				model_table.setValueAt(st.getLop(), i, 2);
				model_table.setValueAt(st.getDiemToan(), i, 3);
				model_table.setValueAt(st.getDiemVan(), i, 4);
				model_table.setValueAt(st.getDiemAnh(), i, 5);
			}
		}
	}
}
