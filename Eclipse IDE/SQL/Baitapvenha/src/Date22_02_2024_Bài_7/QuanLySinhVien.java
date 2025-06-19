package Date22_02_2024_Bài_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class QuanLySinhVien {
	
	private ArrayList<SinhVien> danhsach  ;

	public QuanLySinhVien(ArrayList<SinhVien> danhsach) {
		this.danhsach = danhsach;
	}
	
	public QuanLySinhVien() {
		this.danhsach = new ArrayList<SinhVien>();
	}
	
	public void themSinhVien(SinhVien sv) {
		this.danhsach.add(sv);
	}
	
	public void hienThiDanhSach() {
		for (SinhVien sinhVien : danhsach) {
			System.out.println(sinhVien.toString());
		}
	}
	
	
	public void sapXepDiemTBTangdan() {
        Collections.sort(danhsach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Float.compare(sv1.getDiemtb(), sv2.getDiemtb());
            }
        });
    }
	
	public void timKiem(String ten) {
		for (SinhVien sinhVien : danhsach) {
			if(sinhVien.getTen().equals(ten)) {
				System.out.println(sinhVien.toString());
			}
		}
	}
}
