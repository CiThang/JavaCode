package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
		private ArrayList<SinhVien> danhSach;
		
		public DanhSachSinhVien() {
			this.danhSach = new ArrayList();
		}
		
		public DanhSachSinhVien(ArrayList danhSach) {
			this.danhSach = danhSach;
		}
		
		// 1.	Thêm sinh viên vào danh sách.
		public void themSinhVien(SinhVien sv) {
			this.danhSach.add(sv);
		}
		
//		2.	In danh sách sinh viên ra màn hình.
		public void inDanhSachSinhVien() {
			for (SinhVien sinhVien : danhSach) {
				System.out.println(sinhVien);
			}
		}
		
//		3.	Kiểm tra danh sách có rỗng hay không.
		public boolean kiemTraDanhSachRong() {
			return this.danhSach.isEmpty();
		}
		
//		4.	Lấy ra số lượng sinh viên trong danh sách.
		public int laySoLuongSinhVien() {
			return this.danhSach.size();
		}
		
//		5.	Làm rỗng danh sách sinh viên.
		public void lamRongDanhSach() {
			this.danhSach.removeAll(danhSach);
		}
		
//		6.	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.
		public boolean kiemTraTonTai(SinhVien sv) {
			return this.danhSach.contains(sv);
		}
		
//		7.	Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.
		public boolean xoaSinhVien(SinhVien sv) {
			return this.danhSach.remove(sv);
		}
		
//		8.	Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.
		public void timSinhVien(String ten) {
			for (SinhVien sinhVien : danhSach) {
				if(sinhVien.getHoVaTen().indexOf(ten)>=0) {
					System.out.println(sinhVien);
				}
			}
		}
//		9.	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.
		public void sapXepSinhVienGiamDanTheoDiem() {
			Collections.sort(this.danhSach, new Comparator<SinhVien>() {

				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					if(sv1.getDiemTrungBinh()<sv2.getDiemTrungBinh()) {
						return 1;
					} else if(sv1.getDiemTrungBinh()>sv2.getDiemTrungBinh()) {
						return -1;
					} else {
						return 0;
					}
				}
				
			});
		}
//		10. Ghi xuong File
		public void ghiDuLieuXuongFile(File file) {
			try {
				
//				OutputStream os = new FileOutputStream(file);
//				ObjectOutputStream oos = new ObjectOutputStream(os);
				PrintWriter pw = new PrintWriter(file.getAbsoluteFile());
				for (SinhVien sinhVien : danhSach) {
//					pw.println(sinhVien.toString());
					pw.println(sinhVien.getMaSinhVien());
					pw.println(sinhVien.getHoVaTen());
					pw.println(sinhVien.getNamSinh());
					pw.println(sinhVien.getDiemTrungBinh());
				}
				
				pw.flush();
				pw.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
}