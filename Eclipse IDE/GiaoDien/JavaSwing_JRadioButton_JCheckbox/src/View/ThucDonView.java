package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import Controller.ThucDonController;
import Model.ThucDonModel;

public class ThucDonView extends JFrame {

	public ThucDonModel thucDonModel;
	public JRadioButton jRadioButton_com;
	public JRadioButton jRadioButton_pho;
	public JRadioButton jRadioButton_banhmi;
	public ButtonGroup buttonGroup_MonChinh;
	public JCheckBox jCheckBox_trasua;
	public JCheckBox jCheckBox_coca;
	public JCheckBox jCheckBox_banhngot;
	public JCheckBox jCheckBox_nem;
	public ArrayList<JCheckBox> list_buttonGroup_monphu;
	public JTextArea jTextArea_thongtin;
	
	public ThucDonView() {
		this.thucDonModel = new ThucDonModel();
		this.init();
	}
	
	public void init() {
		this.setTitle("Thuc don ");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
	
		Font font = new Font("Arial", Font.BOLD, 40);
		
		JLabel header = new JLabel("THUC DON NHA HANG Mot Minh Tao");
		header.setFont(font);
		
		
		
		// JPanel Tieu De
		JPanel jPanel_TieuDe = new JPanel();
		jPanel_TieuDe.add(header);
		jPanel_TieuDe.setBackground(Color.BLUE);
		
		// JPanel Mon Chinh
		JPanel jPanel_MonChinh = new JPanel();
		jPanel_MonChinh.setLayout(new GridLayout(1,3));
		
		jRadioButton_com = new JRadioButton("COM");
		jRadioButton_com.setFont(font);		
		jRadioButton_com.setBackground(Color.WHITE);
		jRadioButton_pho = new JRadioButton("PHO");
		jRadioButton_pho.setFont(font);
		jRadioButton_pho.setBackground(Color.WHITE);
		jRadioButton_banhmi = new JRadioButton("BANH MI");
		jRadioButton_banhmi.setFont(font);
		jRadioButton_banhmi.setBackground(Color.WHITE);
		buttonGroup_MonChinh = new ButtonGroup();
		buttonGroup_MonChinh.add(jRadioButton_com);
		buttonGroup_MonChinh.add(jRadioButton_pho);
		buttonGroup_MonChinh.add(jRadioButton_banhmi);		
		jPanel_MonChinh.add(jRadioButton_com);
		jPanel_MonChinh.add(jRadioButton_pho);
		jPanel_MonChinh.add(jRadioButton_banhmi);
		
		
		// JPanel mon phu
		JPanel jPanel_MonPhu = new JPanel();
		jPanel_MonPhu.setLayout(new GridLayout(2,2));
		jCheckBox_trasua = new JCheckBox("TRA SUA");
		jCheckBox_trasua.setFont(font);
		jCheckBox_coca = new JCheckBox("COCA COLA");
		jCheckBox_coca.setFont(font);
		jCheckBox_banhngot = new JCheckBox("BANH NGOT");
		jCheckBox_banhngot.setFont(font);
		jCheckBox_nem = new JCheckBox("NEM");
		jCheckBox_nem.setFont(font);
		list_buttonGroup_monphu = new ArrayList<JCheckBox>();
		list_buttonGroup_monphu.add(jCheckBox_trasua);
		list_buttonGroup_monphu.add(jCheckBox_coca);
		list_buttonGroup_monphu.add(jCheckBox_banhngot);
		list_buttonGroup_monphu.add(jCheckBox_nem);
		
		jPanel_MonPhu.add(jCheckBox_trasua);
		jPanel_MonPhu.add(jCheckBox_coca);
		jPanel_MonPhu.add(jCheckBox_banhngot);
		jPanel_MonPhu.add(jCheckBox_nem);
		
		
		
		JPanel jPanel_luachon = new JPanel();
		jPanel_luachon.setLayout(new GridLayout(2,1));
		jPanel_luachon.add(jPanel_MonChinh);
		jPanel_luachon.add(jPanel_MonPhu);
		
		
		JPanel jPanel_ThanhToan = new JPanel();
		jPanel_ThanhToan.setLayout(new GridLayout(1, 2));
		jTextArea_thongtin = new JTextArea();
		
		Font font2 = new Font("Arial", Font.BOLD, 20);
		
		jTextArea_thongtin.setFont(font2);
		JButton jButton_thanhtoan = new JButton("Thanh toan");
		jButton_thanhtoan.setFont(font);
		ActionListener thucdonController = new ThucDonController(this);
		jButton_thanhtoan.addActionListener(thucdonController);
		jPanel_ThanhToan.add(jTextArea_thongtin);
		jPanel_ThanhToan.add(jButton_thanhtoan);
		
		this.add(jPanel_ThanhToan, BorderLayout.SOUTH);
		this.add(jPanel_TieuDe, BorderLayout.NORTH);
		this.add(jPanel_luachon, BorderLayout.CENTER);


		
		this.setVisible(true);
	}

	public void hienThiKetQua() {
		String kq ="Mon chinh: "+ this.thucDonModel.getLuaChon_MonChinh() +"\n"
					+"Mon phu: "+ this.thucDonModel.getLuaChon_MonPhu() +"\n"
					+"Tong tien: "+ this.thucDonModel.getTongTien();
		this.jTextArea_thongtin.setText(kq);
	}
}
