package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.ThucDonController;
import Model.ThucDonModel;

public class ThucDonView extends JFrame {

	public ThucDonModel thucDonModel;
	public ButtonGroup buttonGroup_MonChinh;

	public ArrayList<JCheckBox> list_buttonGroup_monphu;
	public JTextArea jTextArea_thongtin;
	public JComboBox<String> jComboBox_MonChinh;
	public JList<String> jList_MonPhu;
	
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
		jPanel_MonChinh.setLayout(new FlowLayout());
		String[] cacMonChinh = new String[] {"COM","PHO","BANH MI"};
		jComboBox_MonChinh = new JComboBox<String>(cacMonChinh);
		jComboBox_MonChinh.setFont(font);
		jPanel_MonChinh.add(jComboBox_MonChinh);
		
		
		// JPanel mon phu
		JPanel jPanel_MonPhu = new JPanel();
		jPanel_MonPhu.setLayout(new BorderLayout());
		String[] cacMonPhu = new String[] {"TRA SUA","COCA COLA","BANH NGOT","NEM"};
		jList_MonPhu = new JList<String>(cacMonPhu);
		jList_MonPhu.setFont(font);
		jPanel_MonPhu.add(jList_MonPhu);

		
		
		JPanel jPanel_luachon = new JPanel();
		jPanel_luachon.setLayout(new GridLayout(2,1));
		jPanel_luachon.add(jPanel_MonChinh, BorderLayout.NORTH);
		jPanel_luachon.add(jPanel_MonPhu, BorderLayout.CENTER);
		
		
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
