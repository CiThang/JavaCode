package Design;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FomDanhGia extends JPanel {

	private static final long serialVersionUID = 1L;
	private ButtonGroup radioButton;
	private JLabel lblTenTaiKhoan;
	private JLabel lblavatal;
	private JLabel lblAnhMonAn;
	private JTextArea textArea;
	private JLabel lblLike;
	private JPanel panelLike;
	private int luachon;
	private JLabel lbllikel;
	private JLabel lblGiTin;
	private JLabel lblaCh;
	private JLabel lblGiaTien;
	private JLabel lblDiaChi;

	/**
	 * Create the panel.
	 */
	public FomDanhGia() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		lblavatal = new JLabel("New label");
		lblavatal.setIcon(new ImageIcon("D:\\Pictures\\3f368a7615ee399a42f31256b0127b78.jpg"));
		lblavatal.setBounds(10, 14, 30, 30);
		add(lblavatal);
		
		lblTenTaiKhoan = new JLabel("Họ tên người dùng");
		lblTenTaiKhoan.setFont(new Font("Arial", Font.ITALIC, 12));
		lblTenTaiKhoan.setBounds(50, 17, 126, 25);
		add(lblTenTaiKhoan);
		
		lblAnhMonAn = new JLabel("");
		lblAnhMonAn.setIcon(new ImageIcon("D:\\Pictures\\3.png"));
		lblAnhMonAn.setForeground(new Color(0, 255, 255));
		lblAnhMonAn.setBackground(new Color(0, 255, 255));
		lblAnhMonAn.setBounds(10, 55, 231, 76);
		add(lblAnhMonAn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 231, 124);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		panelLike = new JPanel();
		panelLike.setBackground(new Color(255, 255, 255));
		panelLike.setBounds(31, 313, 76, 28);
		add(panelLike);
		panelLike.setLayout(null);
		
		lblLike = new JLabel("Like");
		lblLike.setFont(new Font("Arial", Font.PLAIN, 13));
		lblLike.setBounds(0, 0, 63, 28);
		panelLike.add(lblLike);
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setBackground(new Color(255, 255, 255));
		lblLike.setForeground(new Color(0, 0, 0));
		lblLike.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\like.png"));
		
		lbllikel = new JLabel("Luot like");
		lbllikel.setHorizontalAlignment(SwingConstants.LEFT);
		lbllikel.setBounds(131, 313, 45, 28);
		add(lbllikel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\DoAnYelpJava\\Pixelkit-Flat-Jewels-Chat.24.png"));
		lblNewLabel.setBounds(211, 11, 30, 30);
		add(lblNewLabel);
		
		lblGiTin = new JLabel("Giá tiền: ");
		lblGiTin.setFont(new Font("Arial", Font.ITALIC, 12));
		lblGiTin.setBounds(20, 131, 59, 25);
		add(lblGiTin);
		
		lblaCh = new JLabel("Địa chỉ: ");
		lblaCh.setFont(new Font("Arial", Font.ITALIC, 12));
		lblaCh.setBounds(20, 154, 59, 25);
		add(lblaCh);
		
		lblGiaTien = new JLabel(".......");
		lblGiaTien.setFont(new Font("Arial", Font.ITALIC, 12));
		lblGiaTien.setBounds(73, 131, 168, 25);
		add(lblGiaTien);
		
		lblDiaChi = new JLabel(".........");
		lblDiaChi.setFont(new Font("Arial", Font.ITALIC, 12));
		lblDiaChi.setBounds(73, 154, 168, 25);
		add(lblDiaChi);
		radioButton = new ButtonGroup();
		
		mouse();
	}
	
	
	
	public void mouse() {
		luachon=0; 
		panelLike.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
//				panelLike.setBackground(new Color(255, 79, 79));
				luachon=1;
				if(luachon==1) {
					panelLike.setBackground(new Color(255, 79, 79));
					
				} else if(luachon==2) {
					
					panelLike.setBackground(Color.white);
				}
			}
		});
	}
}
