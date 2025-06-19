package Test;

import java.sql.Date;
import java.util.ArrayList;

import DAO.KhachHangDAO;
import Model.KhachHang;

public class TestKhachHangDAO {
 
	public static void main(String[] args) {
		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selecAll();
		for (KhachHang khachHang : list) {
			System.out.println(khachHang.toString());
		}
	}
}
