package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.QLSVModel;
import Model.ThiSinh;
import Model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.QLSVController;

import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	public QLSVModel model;

	// Khai bao bien cuc bo
	public JTextField textField_masinhvien;
	public JTable table;
	public ButtonGroup btn_gioitinh;
	public TextField textField_mon3;
	public TextField textField_mon2;
	public TextField textField_mon1;
	public TextField textField_ngaysinh;
	public TextField textField_hovaten;
	public TextField textField_mathisinh;
	public JComboBox comboBox_quequan_1;
	public JRadioButton rdbtnrd_nam;
	public JRadioButton rdbtnrd_nu;
	public JComboBox comboBox_quequantimkiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.model = new QLSVModel();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 671);

		Action ac = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnFile);

		JMenuItem mntm_Open = new JMenuItem("Open");
		mntm_Open.addActionListener(ac);
		mnFile.add(mntm_Open);

		JMenuItem mntm_Save = new JMenuItem("Save");
		mntm_Save.addActionListener(ac);
		mnFile.add(mntm_Save);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntm_Exit = new JMenuItem("Exit");
		mntm_Exit.addActionListener(ac);
		mnFile.add(mntm_Exit);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnAbout);

		JMenuItem mItem_Aboutme = new JMenuItem("About");
		mItem_Aboutme.addActionListener(ac);
		mnAbout.add(mItem_Aboutme);
		getContentPane().setLayout(null);

		JLabel label_quequan = new JLabel("Quê quán");
		label_quequan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_quequan.setBounds(20, 21, 80, 30);
		getContentPane().add(label_quequan);

		JLabel label_masinhvien = new JLabel("Mã sinh viên");
		label_masinhvien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_masinhvien.setBounds(265, 21, 120, 30);
		getContentPane().add(label_masinhvien);

		textField_masinhvien = new JTextField();
		textField_masinhvien.setColumns(10);
		textField_masinhvien.setBounds(370, 24, 192, 30);
		getContentPane().add(textField_masinhvien);

		JButton button_tim = new JButton("Tìm");
		button_tim.addActionListener(ac);
		button_tim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_tim.setBounds(572, 23, 80, 30);
		getContentPane().add(button_tim);

		comboBox_quequantimkiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			comboBox_quequantimkiem.addItem(tinh.getTenTinh()); // JComboBox.addItem - Them cac list thong tin vao
																// JComboBox
		}

		comboBox_quequantimkiem.setBounds(98, 21, 138, 30);
		getContentPane().add(comboBox_quequantimkiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 62, 725, 2);
		getContentPane().add(separator_1);

		JLabel label_dsthisinh = new JLabel("Danh sách thí sinh");
		label_dsthisinh.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_dsthisinh.setBounds(20, 72, 165, 30);
		getContentPane().add(label_dsthisinh);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));
		table.setBounds(20, 26, 704, 144);
		getContentPane().add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 102, 705, 171);
		getContentPane().add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 284, 725, 2);
		getContentPane().add(separator_1_1);

		JLabel label_ttthisinh = new JLabel("Thông tin thí sinh");
		label_ttthisinh.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_ttthisinh.setBounds(20, 294, 165, 30);
		getContentPane().add(label_ttthisinh);

		Label label_mathisinh = new Label("Mã thí sinh");
		label_mathisinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_mathisinh.setBounds(85, 331, 80, 22);
		getContentPane().add(label_mathisinh);

		textField_mathisinh = new TextField();
		textField_mathisinh.setBounds(171, 331, 165, 22);
		getContentPane().add(textField_mathisinh);

		Label label_hovaten = new Label("Họ và tên");
		label_hovaten.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_hovaten.setBounds(85, 371, 73, 22);
		getContentPane().add(label_hovaten);

		textField_hovaten = new TextField();
		textField_hovaten.setBounds(171, 371, 165, 22);
		getContentPane().add(textField_hovaten);

		Label label_quequan1 = new Label("Quê quán");
		label_quequan1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_quequan1.setBounds(85, 414, 73, 22);
		getContentPane().add(label_quequan1);

		comboBox_quequan_1 = new JComboBox();
		for (Tinh tinh : listTinh) {
			comboBox_quequan_1.addItem(tinh.getTenTinh());
		}
		comboBox_quequan_1.setBounds(171, 414, 165, 22);
		getContentPane().add(comboBox_quequan_1);

		Label label_ngaysinh = new Label("Ngày sinh");
		label_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_ngaysinh.setBounds(85, 457, 73, 22);
		getContentPane().add(label_ngaysinh);

		textField_ngaysinh = new TextField();
		textField_ngaysinh.setBounds(171, 457, 165, 22);
		getContentPane().add(textField_ngaysinh);

		Label label_gioitinh = new Label("Giới tính");
		label_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_gioitinh.setBounds(85, 497, 73, 22);
		getContentPane().add(label_gioitinh);

		rdbtnrd_nam = new JRadioButton("Nam");
		rdbtnrd_nam.setBounds(170, 497, 53, 23);
		getContentPane().add(rdbtnrd_nam);

		rdbtnrd_nu = new JRadioButton("Nữ");
		rdbtnrd_nu.setBounds(248, 497, 59, 23);
		getContentPane().add(rdbtnrd_nu);

		btn_gioitinh = new ButtonGroup();
		btn_gioitinh.add(rdbtnrd_nu);
		btn_gioitinh.add(rdbtnrd_nam);

		Label label_mon1 = new Label("Môn 1");
		label_mon1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_mon1.setBounds(427, 371, 80, 22);
		getContentPane().add(label_mon1);

		textField_mon1 = new TextField();
		textField_mon1.setBounds(513, 371, 165, 22);
		getContentPane().add(textField_mon1);

		Label label_mon2 = new Label("Môn 2");
		label_mon2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_mon2.setBounds(427, 414, 80, 22);
		getContentPane().add(label_mon2);

		textField_mon2 = new TextField();
		textField_mon2.setBounds(513, 414, 165, 22);
		getContentPane().add(textField_mon2);

		Label label_mon3 = new Label("Môn 3");
		label_mon3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_mon3.setBounds(427, 457, 80, 22);
		getContentPane().add(label_mon3);

		textField_mon3 = new TextField();
		textField_mon3.setBounds(513, 457, 165, 22);
		getContentPane().add(textField_mon3);

		JLabel lblNewLabel = new JLabel("Điểm của thí sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(514, 331, 138, 14);
		getContentPane().add(lblNewLabel);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 541, 725, 2);
		getContentPane().add(separator_1_1_1);

		JButton btn_them = new JButton("Thêm");
		btn_them.setBounds(70, 554, 89, 23);
		getContentPane().add(btn_them);
		btn_them.addActionListener(ac);

		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setBounds(197, 554, 89, 23);
		getContentPane().add(btn_xoa);
		btn_xoa.addActionListener(ac);

		JButton btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.setBounds(324, 554, 89, 23);
		getContentPane().add(btn_capnhat);
		btn_capnhat.addActionListener(ac);

		JButton btn_luu = new JButton("Lưu");
		btn_luu.setBounds(450, 554, 89, 23);
		getContentPane().add(btn_luu);
		btn_luu.addActionListener(ac);

		JButton btn_huybo = new JButton("Hủy bỏ");
		btn_huybo.setBounds(583, 554, 89, 23);
		getContentPane().add(btn_huybo);

		JButton button_huytim = new JButton("Hủy");
		button_huytim.addActionListener(ac);
		button_huytim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_huytim.setBounds(662, 23, 73, 30);
		getContentPane().add(button_huytim);
		btn_huybo.addActionListener(ac);

		this.setVisible(true);
	}

	// Xóa dữ liệu trong các TextField
	public void xoaForm() {
		textField_masinhvien.setText("");
		textField_hovaten.setText("");
		textField_mathisinh.setText("");
		textField_ngaysinh.setText("");
		textField_mon1.setText("");
		textField_mon2.setText("");
		textField_mon3.setText("");
		comboBox_quequan_1.setSelectedItem(-1);
		btn_gioitinh.clearSelection();

	}

	// Lấy thông tin các thí sinh đã được ghi trong JTextField và đưa vào ThiSinh()
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + ""); // getValueAt - lay du lieu -
																				// getValueAt(int row, int column)
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngay_sinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngay_sinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}

	public void themhoaccapnhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		// Nấu chưa tồn tại
		if (!this.model.kiemTraTonTai(ts)) {
			// Thêm thí sinh vào QLSVModel
			this.model.insert(ts);
			// addRow - Them du lieu vao bang (Object)
			this.themThiSinhVaoTable(ts);
			// Nếu đã tồn tại
		} else {
			// Cập nhật thí sinh
			this.model.update(ts);
			// getRowCount - lay so luong dong o table
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				// getMaThiSinh cua tung dong - Roi thuc hien tim tung dong
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					// setValueAt(<Du Lieu>,<Hang>,<Cot>) - sua du lieu cua bang
					// Khi da tim ra thi - model_table.setValueAt(<Du lieu moi>, <Dong thu i>,
					// <Cot>);
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh(), i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh(), i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900), i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);

				}
			}
		}
	}

	public void hienThiThongTinThiSinhDaChon() {
		// Lay thong tin thi sinh da nhap dong thoi tao Constructor ThiSinh()
		ThiSinh ts = getThiSinhDangChon();

		// Dua du lieu tu bang vao lai cac JTextField
		this.textField_mathisinh.setText(ts.getMaThiSinh() + "");
		this.textField_hovaten.setText(ts.getTenThiSinh() + "");
		this.comboBox_quequan_1.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_ngaysinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			rdbtnrd_nam.setSelected(true);
		} else {
			rdbtnrd_nu.setSelected(true);
		}
		this.textField_mon1.setText(ts.getDiemMon1() + "");
		this.textField_mon2.setText(ts.getDiemMon2() + "");
		this.textField_mon3.setText(ts.getDiemMon3() + "");

	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn");
		if (luaChon == JOptionPane.YES_OPTION) {
			// Lay thong tin cua thi sinh da chon
			ThiSinh ts = getThiSinhDangChon();
			// Xoa du lieu trong QLSVModel
			this.model.delete(ts);
			// Xoa du lieu tren hang
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThem() {
		int maThiSinh = Integer.valueOf(this.textField_mathisinh.getText());
		String tenThiSinh = this.textField_hovaten.getText();
		int queQuan = this.comboBox_quequan_1.getSelectedIndex();
		Tinh tinh = Tinh.getTinhByID(queQuan);
		Date ngaySinh = new Date(this.textField_ngaysinh.getText());
		boolean gioiTinh = true;
		String chonGioiTinh = this.btn_gioitinh.getSelection() + "";
		if (this.rdbtnrd_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtnrd_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_mon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);

		this.themhoaccapnhatThiSinh(ts);

	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();

		// Thuc hien tim kiem
		// Lay du lieu tu ComboBox_quequan
		int queQuan = this.comboBox_quequantimkiem.getSelectedIndex();
		// Lay du lieu tu textField_mathisinh
		String maThiSinhTimKiem = this.textField_masinhvien.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		// getRowCount - lay so luong dong
		int soLuongDong = model_table.getRowCount();
		// Tao mot tap hop
		// Muc tieu: Thay vi xoa cac thi sinh khong duoc tim, thi minh se dua cac du
		// lieu do vao Set de sau ni thuc hien lay ra
		Set<Integer> idCacThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan > 0) {
			Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";

				// Neu tenTinh khong giong nhu ten tinh da chon thi them vao
				// TreeSet(idCacThiSinhCanXoa)
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCacThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				// Neu id khong giong nhu ten tinh da chon thi them vao
				// TreeSet(idCacThiSinhCanXoa)
				if (!id.equals(maThiSinhTimKiem)) {
					idCacThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}

		// Duyet tat cac ca phan tu cua TreeSet - Duyet tat ca cac idCacThiSinhCanXoa
		for (Integer idCanXoa : idCacThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			// Neu idCacThiSinhCanXoa == idTrongTable thi thuc hien xoa dong
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		;
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}

	}

	public void hienThiAbout() {
		JOptionPane.showConfirmDialog(this, "Phần mềm quản lý thí sinh 1.0");

	}

	public void thoatKhoiChuongTrinh() {
		int luachon = JOptionPane.showConfirmDialog(this, "Thoát khỏi chương trình", "Exit", JOptionPane.YES_NO_OPTION);
		if (luachon == JOptionPane.YES_OPTION) {
			// Đóng ứng dụng khi người dùng chọn "Yes"
			System.exit(0);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			// Ngăn chặn đóng cửa sổ khi người dùng chọn "No"
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}

	}

	public void saveFile(String path) {
		try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			this.model.setTenFile(path);

			for (ThiSinh ts : this.model.getDsThiSinh()) {
				try {
					oos.writeObject(ts); // Write the actual object 'ts'
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInput ois = new ObjectInputStream(fis);

			ThiSinh ts = null;

			while ((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}

			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}

	}
	
	public void connect() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=BAI1;user=sa;password=120605;encrypt=false";

        
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            System.out.println("ssdasdasdas");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
