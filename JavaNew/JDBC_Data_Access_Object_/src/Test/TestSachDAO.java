package Test;

import java.util.ArrayList;

import DAO.SachDAO;
import Model.Sach;

public class TestSachDAO {

	public static void main(String[] args) {
		/* Test Insert  TEST INSERT
		Sach sach1 = new Sach("LTJV", "Lap trinh java", 5000000, 2000);
		Sach sach2 = new Sach("LTCB", "Lap trinh co ban", 50000, 2005);
		
		SachDAO.getInstance().insert(sach1);
		SachDAO.getInstance().insert(sach2);
		
		for(int i=3; i<100; i++) {
			Sach sach = new Sach("LT "+i, "Lap trinh "+i, 50000, 2005);
			SachDAO.getInstance().insert(sach);
		}*/
		
		/* Test update  TEST UPDATE
		Sach sach2 = new Sach("LTCB","Lap trinh C++",10000,2005);
		SachDAO.getInstance().update(sach2);*/
		
		/* Test delete  TEST DELETE
		for(int i=2; i<100;i++) {
			Sach sach = new Sach("LT "+i, "Lap trinh "+i, 50000, 2005);
			SachDAO.getInstance().delete(sach);
		}*/
		
		/* Test hien thi thong tin tu SQL
		Sach sach2 = new Sach("Toan12  ", "hoc toan nao ca nha 12 ", 20000, 200000);
		SachDAO.getInstance().insert(sach2);
		*/
		
		ArrayList<Sach> list = SachDAO.getInstance().selecAll();
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
		System.out.println("-------------------------------------------");
		Sach find = new Sach();
		find.setId("Toan");
		Sach sach2 = SachDAO.getInstance().selectById(find);
		System.out.println(sach2);
		
		System.out.println("-------------------------------------------");
		
		ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("giaBan > 2000.0");
		for (Sach sach : list2) {
			System.out.println(sach.toString());
		}
	}
}
