package Baimodau;

import javax.swing.JFrame;

public class Taogiaodien extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// Tạo khung giao diện 
		JFrame jFrame = new JFrame();
		
		// Đặt tên 
		jFrame.setTitle("Chi thang ne ");
		
		// Đặt kích thước
		jFrame.setSize(600,600);
		
		// Cho hiện thi giữa màn hình 
		jFrame.setLocationRelativeTo(null);
		
		// Đóng cửa sổ và đóng luôn chương trình
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Cho hiện thị cửa sổ giao diện 
		jFrame.setVisible(true);
		
	}
	
}
