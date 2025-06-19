package Yelp_View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import Design.FomDanhGia;
import Yelp_Controller.YelpMainController;
import Yelp_Model.YelpPost;
import Yelp_Model.YelpPrimaryKey;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Box;

public class YelpMainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String[] IMAGE_PATHS = { "img1.jpg", "img2.jpg", "img3.jpeg", "img5.jpg" }; // Đường dẫn của
																										// các ảnh
	private static final int DELAY = 3000; // Độ trễ giữa các lần đổi ảnh (ms)

	private int currentImageIndex = 0;
	private Thread slideShowThread;
	private JPanel contentPane;
	public JPanel panelTrangChu;
	public JPanel panelTaoDanhGia;
	public JPanel panelTimKiem;
	public JPanel panelGuiPhanHoi;
	public JPanel panelThongtin;
	public JPanel panelchaomung;
	public JLabel lblanh;
	public JPanel panelLoiChao;
	public JScrollPane scrollPane;
	public JPanel panelBenPhai;
	public JPanel panelTaoDanhGiaChinh;
	public JPanel panelBaiDanhGiaChinh;
	public JPanel panelBaiDanhGia;
	public JLabel lblChonAnh;
	public JTextField textFieldGiaTien;
	public JTextField textFieldDiaChi;
	public JButton btnThoat;
	public JComboBox comboBoxTheLoai;
	public JScrollPane scrollPaneBaiDanhTGia;
	public JTextArea textAreaBaiDanhGia;
	private JPanel panelChonAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public YelpMainView frame;

			public void run() {
				try {

					frame = new YelpMainView();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public YelpMainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelBenPhai = new JPanel();
		panelBenPhai.setBackground(new Color(255, 79, 79));
		panelBenPhai.setBounds(0, 0, 207, 661);
		contentPane.add(panelBenPhai);
		panelBenPhai.setLayout(null);

		panelTrangChu = new JPanel();
		panelTrangChu.setBackground(new Color(255, 79, 79));
		panelTrangChu.setBounds(0, 229, 206, 47);
		panelBenPhai.add(panelTrangChu);
		panelTrangChu.setLayout(null);

		JLabel lblNewLabel = new JLabel("Trang chủ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(58, 0, 138, 47);
		panelTrangChu.add(lblNewLabel);

		JLabel lbl_img = new JLabel("");
		lbl_img.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\home.png"));
		lbl_img.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_img.setBounds(0, 0, 48, 47);
		panelTrangChu.add(lbl_img);

		panelTaoDanhGia = new JPanel();
		panelTaoDanhGia.setBackground(new Color(255, 79, 79));
		panelTaoDanhGia.setBounds(0, 322, 206, 47);
		panelBenPhai.add(panelTaoDanhGia);
		panelTaoDanhGia.setLayout(null);

		JLabel lbl_img_1 = new JLabel("");
		lbl_img_1.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\post.png"));
		lbl_img_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_img_1.setBounds(0, 0, 48, 47);
		panelTaoDanhGia.add(lbl_img_1);

		JLabel lblNewLabel_1 = new JLabel("Tạo đánh giá");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(58, 0, 138, 47);
		panelTaoDanhGia.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));

		panelTimKiem = new JPanel();
		panelTimKiem.setBackground(new Color(255, 79, 79));
		panelTimKiem.setBounds(0, 368, 206, 47);
		panelBenPhai.add(panelTimKiem);
		panelTimKiem.setLayout(null);

		JLabel lbl_imgTaoDanhGia_1 = new JLabel("");
		lbl_imgTaoDanhGia_1.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\find.png"));
		lbl_imgTaoDanhGia_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imgTaoDanhGia_1.setBounds(0, 0, 48, 47);
		panelTimKiem.add(lbl_imgTaoDanhGia_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tìm kiếm");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(58, 0, 138, 47);
		panelTimKiem.add(lblNewLabel_1_1);

		panelGuiPhanHoi = new JPanel();
		panelGuiPhanHoi.setBackground(new Color(255, 79, 79));
		panelGuiPhanHoi.setLayout(null);
		panelGuiPhanHoi.setBounds(0, 414, 206, 47);
		panelBenPhai.add(panelGuiPhanHoi);

		JLabel lbl_imgTaoDanhGia_1_1 = new JLabel("");
		lbl_imgTaoDanhGia_1_1.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\feedback (1).png"));
		lbl_imgTaoDanhGia_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imgTaoDanhGia_1_1.setBounds(0, 0, 48, 47);
		panelGuiPhanHoi.add(lbl_imgTaoDanhGia_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Phản hồi");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(58, 0, 138, 47);
		panelGuiPhanHoi.add(lblNewLabel_1_1_1);

		panelThongtin = new JPanel();
		panelThongtin.setBackground(new Color(255, 79, 79));
		panelThongtin.setLayout(null);
		panelThongtin.setBounds(0, 461, 206, 47);
		panelBenPhai.add(panelThongtin);

		JLabel lbl_imgTaoDanhGia_1_2 = new JLabel("");
		lbl_imgTaoDanhGia_1_2.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\info.png"));
		lbl_imgTaoDanhGia_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imgTaoDanhGia_1_2.setBounds(0, 0, 48, 47);
		panelThongtin.add(lbl_imgTaoDanhGia_1_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("Thông tin");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(58, 0, 138, 47);
		panelThongtin.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2
				.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\Designbolts-Folded-Social-Media-Yelp.128.png"));
		lblNewLabel_2.setBounds(28, 11, 145, 149);
		panelBenPhai.add(lblNewLabel_2);

		YelpMainController ac = new YelpMainController(this);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(0, 221, 221));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		btnThoat.setBounds(28, 614, 157, 36);
		btnThoat.addActionListener(ac);
		panelBenPhai.add(btnThoat);

		panelBaiDanhGia = new JPanel();
		panelBaiDanhGia.setLayout(null);
		panelBaiDanhGia.setBackground(new Color(255, 79, 79));
		panelBaiDanhGia.setBounds(0, 275, 206, 47);
		panelBenPhai.add(panelBaiDanhGia);

		JLabel lblBinhGi = new JLabel("Bài đánh giá");
		lblBinhGi.setVerticalAlignment(SwingConstants.CENTER);
		lblBinhGi.setForeground(Color.WHITE);
		lblBinhGi.setFont(new Font("Arial", Font.BOLD, 18));
		lblBinhGi.setBounds(58, 0, 138, 47);
		panelBaiDanhGia.add(lblBinhGi);

		JLabel lbl_img_2 = new JLabel("");
		lbl_img_2.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\post (1).png"));
		lbl_img_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_img_2.setBounds(0, 0, 48, 47);
		panelBaiDanhGia.add(lbl_img_2);

		JLabel lblNewLabel_8 = new JLabel("Bạn chưa đăng nhập");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_8.setBounds(0, 171, 206, 26);
		panelBenPhai.add(lblNewLabel_8);

// PHẦN MỞ ĐẦU
		panelchaomung = new JPanel();
		panelchaomung.setBackground(new Color(255, 191, 191));
		panelchaomung.setBounds(206, 0, 1016, 661);

		// phần chào mừng
//		contentPane.add(panelchaomung);
		panelchaomung.setLayout(null);
//		

		lblanh = new JLabel("");
		lblanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblanh.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\img1.jpg"));
		lblanh.setBounds(195, 210, 610, 391);
		panelchaomung.add(lblanh);
		ImageIcon icon = new ImageIcon(getClass().getResource("img1.jpg"));
		panelchaomung.add(lblanh);

		JLabel lblNewLabel_7 = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI YELP - ỨNG DỤNG HÀNG ĐÀU VỀ ẨM THỰC THỪA THIÊN HUẾ");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 55, 961, 112);
		panelchaomung.add(lblNewLabel_7);
		startSlideShow();
		this.mouse();

//TẠO ĐÁNH GIÁ CHÍNH			
		panelTaoDanhGiaChinh = new JPanel();
		panelTaoDanhGiaChinh.setBackground(new Color(255, 191, 191));
		panelTaoDanhGiaChinh.setBounds(206, 0, 978, 661);

		contentPane.add(panelTaoDanhGiaChinh);
		panelTaoDanhGiaChinh.setLayout(null);

		textAreaBaiDanhGia = new JTextArea();
		textAreaBaiDanhGia.setFont(new Font("Arial", Font.PLAIN, 19));

		// Tạo JScrollPane và thiết lập chiều cuộn
		scrollPaneBaiDanhTGia = new JScrollPane(textAreaBaiDanhGia);
		scrollPaneBaiDanhTGia.setBounds(48, 294, 510, 318);
		scrollPaneBaiDanhTGia.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Tạo DocumentFilter để tự động xuống hàng khi đạt giới hạn
		((AbstractDocument) textAreaBaiDanhGia.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				// Kiểm tra chiều ngang hiện tại
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + string + currentText.substring(offset);

				// Kiểm tra chiều ngang mới
				if (getLineWidth(newText) <= 58) {
					super.insertString(fb, offset, string, attr);
				} else {
					super.insertString(fb, offset, "\n" + string, attr); // Thêm ký tự xuống hàng
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				// Kiểm tra chiều ngang hiện tại
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

				// Kiểm tra chiều ngang mới
				if (getLineWidth(newText) <= 55) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					super.replace(fb, offset, length, "\n" + text, attrs); // Thêm ký tự xuống hàng
				}
			}
		});

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\164b20568eed6beae4b903a39a9d965a.gif"));
		lblNewLabel_5.setBounds(640, -42, 308, 280);
		panelTaoDanhGiaChinh.add(lblNewLabel_5);

		// Thêm JScrollPane vào panelTaoDanhGiaChinh
		panelTaoDanhGiaChinh.add(scrollPaneBaiDanhTGia);

		JButton btnThemMoi = new JButton("Thêm mới");
		btnThemMoi.setForeground(new Color(255, 255, 255));
		btnThemMoi.setBackground(new Color(114, 114, 114));
		btnThemMoi.setFont(new Font("Arial", Font.BOLD, 13));
		btnThemMoi.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\NicePng_venkateshwara-png_2519428 (1).png"));
		btnThemMoi.setBounds(640, 577, 136, 35);
		btnThemMoi.addActionListener(ac);
		panelTaoDanhGiaChinh.add(btnThemMoi);

		JButton btnHy = new JButton("Hủy");
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\NicePng_venkateshwara-png_2519428 (1) - Copy.png"));
		btnHy.setFont(new Font("Arial", Font.BOLD, 13));
		btnHy.setBackground(new Color(114, 114, 114));
		btnHy.setBounds(812, 577, 136, 35);
		btnHy.addActionListener(ac);
		panelTaoDanhGiaChinh.add(btnHy);

		lblChonAnh = new JLabel("CHỌN ẢNH");
		lblChonAnh.setForeground(new Color(0, 0, 0));
		lblChonAnh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblChonAnh.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\photo.png"));
		lblChonAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblChonAnh.setBounds(159, 47, 188, 64);
		
		panelChonAnh = new JPanel();
		panelChonAnh.setForeground(new Color(0, 0, 0));
		panelChonAnh.setFont(new Font("Arial", Font.PLAIN, 16));
		panelChonAnh.setBounds(48, 106, 510, 154);
		panelChonAnh.setLayout(null);
		panelChonAnh.add(lblChonAnh);
		panelTaoDanhGiaChinh.add(panelChonAnh);

		JLabel lblTheLoai = new JLabel("Thể loại");
		lblTheLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTheLoai.setForeground(new Color(0, 0, 0));
		lblTheLoai.setFont(new Font("Arial", Font.BOLD, 18));
		lblTheLoai.setBackground(new Color(114, 114, 114));
		lblTheLoai.setBounds(599, 394, 107, 35);
		panelTaoDanhGiaChinh.add(lblTheLoai);

		comboBoxTheLoai = new JComboBox();
		comboBoxTheLoai.addItem("");
		comboBoxTheLoai.addItem("Đồ ăn");
		comboBoxTheLoai.addItem("Quán ăn");
		comboBoxTheLoai.addItem("Thể loại");
		
		comboBoxTheLoai.setBounds(745, 394, 203, 35);
		panelTaoDanhGiaChinh.add(comboBoxTheLoai);

		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiTin.setForeground(Color.BLACK);
		lblGiTin.setFont(new Font("Arial", Font.BOLD, 18));
		lblGiTin.setBackground(new Color(114, 114, 114));
		lblGiTin.setBounds(599, 440, 107, 35);
		panelTaoDanhGiaChinh.add(lblGiTin);

		textFieldGiaTien = new JTextField();
		textFieldGiaTien.setBounds(745, 440, 203, 35);
		panelTaoDanhGiaChinh.add(textFieldGiaTien);
		textFieldGiaTien.setColumns(10);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Arial", Font.BOLD, 18));
		lblaCh.setBackground(new Color(114, 114, 114));
		lblaCh.setBounds(599, 486, 107, 35);
		panelTaoDanhGiaChinh.add(lblaCh);

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(745, 486, 203, 35);
		panelTaoDanhGiaChinh.add(textFieldDiaChi);

		JLabel lblNewLabel_6 = new JLabel("Cùng nhau viết lên những bài viết thú vị cho mọi người nào");
		lblNewLabel_6.setFont(new Font("Arial", Font.ITALIC, 13));
		lblNewLabel_6.setBounds(618, 255, 350, 28);
		panelTaoDanhGiaChinh.add(lblNewLabel_6);

		panelLoiChao = new JPanel();
		panelLoiChao.setBackground(new Color(255, 191, 191));
		panelLoiChao.setBounds(207, 0, 977, 105);

		panelLoiChao.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Một số bài đánh giá");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_4.setBounds(328, 26, 303, 51);
		panelLoiChao.add(lblNewLabel_4);

		panelBaiDanhGiaChinh = new JPanel();
		panelBaiDanhGiaChinh.setBackground(new Color(255, 191, 191));
		panelBaiDanhGiaChinh.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout cho panelTrangChu

		scrollPane = new JScrollPane(panelBaiDanhGiaChinh); // Tạo JScrollPane với panelTrangChu
		scrollPane.setBounds(207, 105, 978, 556);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//BAI DANH GIA
//		contentPane.add(panelLoiChao);
//		contentPane.add(scrollPane);
		// Tạo panel chứa các panel con, sử dụng GridBagLayout
		JPanel panelChua = new JPanel(new GridBagLayout());
		panelChua.setBackground(new Color(255, 191, 191)); // Đặt màu nền cho panelChua giống với màu nền của
															// panelTrangChu

		// Thêm panel chứa vào panelTrangChu ở vị trí BorderLayout.CENTER
		panelBaiDanhGiaChinh.add(panelChua, new GridBagConstraints());

		// Tạo và thêm các FomDanhGia vào panel chứa
		for (int i = 0; i < 7; i++) {
			FomDanhGia a = new FomDanhGia();
			a.setPreferredSize(new Dimension(250, 380));

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i % 3; // Xác định cột
			gbc.gridy = i / 3; // Xác định hàng
			gbc.fill = GridBagConstraints.BOTH; // Đảm bảo rằng các panel con sẽ lấp đầy không gian được cung cấp
			gbc.weightx = 1.0 / 3.0; // Phân chia ngang theo 1/3 của panel chứa
			gbc.weighty = 1.0; // Cung cấp đủ không gian theo chiều dọc cho panel con
			gbc.insets = new Insets(15, 15, 15, 15); // Đặt khoảng cách giữa các panel con

			panelChua.add(a, gbc); // Thêm FomDanhGia vào panel chứa
		}

		// Thêm panel trống có màu nền giống với panel cha vào panel chứa để lấp đầy
		// khoảng hở
		for (int i = 0; i < 2; i++) {
			JPanel emptyPanel = new JPanel();
			emptyPanel.setBackground(new Color(255, 191, 191)); // Đặt màu nền cho panel trống giống với màu nền của
																// panel chứa
			panelChua.add(emptyPanel, new GridBagConstraints());
		}

	}

// THỰC THI CÁC CHỨC NĂNG Ở THANH CÔNG CỤ
	public void mouse() {
		panelTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelTrangChu.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelTrangChu.setBackground(new Color(255, 79, 79));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				for (Component component : contentPane.getComponents()) {
					if (component != panelTrangChu && component != panelBenPhai) {
						contentPane.remove(component);
					}
				}
				contentPane.add(panelchaomung);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		panelBaiDanhGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBaiDanhGia.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBaiDanhGia.setBackground(new Color(255, 79, 79));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				for (Component component : contentPane.getComponents()) {
					if (component != panelTrangChu && component != panelBenPhai) {
						contentPane.remove(component);
					}
				}
				contentPane.add(panelLoiChao);
				contentPane.add(scrollPane);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		panelTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelTimKiem.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelTimKiem.setBackground(new Color(255, 79, 79));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		panelThongtin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelThongtin.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelThongtin.setBackground(new Color(255, 79, 79));
			}
		});
		panelTaoDanhGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelTaoDanhGia.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelTaoDanhGia.setBackground(new Color(255, 79, 79));
			}

			public void mouseClicked(MouseEvent e) {
				for (Component component : contentPane.getComponents()) {
					if (component != panelTrangChu && component != panelBenPhai) {
						contentPane.remove(component);
					}
				}
				contentPane.add(panelTaoDanhGiaChinh);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		panelGuiPhanHoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelGuiPhanHoi.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelGuiPhanHoi.setBackground(new Color(255, 79, 79));
			}
		});
	}

// HÀM THỰC HIỆN VIỆC TRÌNH CHIẾU ĐẦU TRANG
	private void startSlideShow() {
		slideShowThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(DELAY); // Đợi một khoảng thời gian
						currentImageIndex = (currentImageIndex + 1) % IMAGE_PATHS.length; // Chuyển đến ảnh tiếp theo
						updateImage(lblanh); // Cập nhật ảnh
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		slideShowThread.start(); // Bắt đầu thread
	}

// PHƯƠNG THỨC CẬP NHẬT ẢNH LÊN JLABEL
	private void updateImage(JLabel jLabel) {
		ImageIcon icon = new ImageIcon(getClass().getResource(IMAGE_PATHS[currentImageIndex])); // Tạo ImageIcon từ
																								// đường dẫn
		jLabel.setIcon(icon); // Đặt ImageIcon cho JLabel
		jLabel.setLayout(null);
		jLabel.setHorizontalAlignment(JLabel.CENTER);
		jLabel.setVerticalAlignment(JLabel.CENTER);
	}

// PHƯƠNG THỨC CHỈNH CHIỀU RỘNG CỦA JTEXTAREA
	private static int getLineWidth(String text) {
		String[] lines = text.split("\n");
		int maxWidth = 0;
		for (String line : lines) {
			maxWidth = Math.max(maxWidth, line.length());
		}
		return maxWidth;
	}

// XÓA FORM VIẾT BÀI ĐÁNH GIÁ
	public void xoaForm() {
		this.textFieldDiaChi.setText("");
		this.textFieldGiaTien.setText("");
		this.comboBoxTheLoai.setSelectedItem("");
		this.textAreaBaiDanhGia.setText("");
		this.lblChonAnh.setIcon(null);
	}

// TẠO ĐÓI TƯỢNG POST

	public YelpPost taoBaiDang() {
		String TaiKhoan = YelpPrimaryKey.getInstance().getTaikhoan();
		String Email =YelpPrimaryKey.getInstance().getGmail();
		String BaiDanhGia = this.textAreaBaiDanhGia.getText();
		String TheLoai = String.valueOf(this.comboBoxTheLoai.getSelectedItem());
		double GiaTien = Double.valueOf(this.textFieldGiaTien.getText());
		String DiaChi = this.textFieldDiaChi.getText();
		String AnhDanhGia;
		
		return null;
	}
}
