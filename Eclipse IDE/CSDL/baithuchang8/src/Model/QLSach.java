package Model;

import java.util.ArrayList;

public class QLSach {

	ArrayList<Sach> danhsach;
	
	public QLSach() {
		this.danhsach = new ArrayList<Sach>();
	}
	
	public QLSach(ArrayList<Sach> danhsach) {
		this.danhsach = danhsach;
	}
	
	
	public void Add(Sach sach) {
		this.danhsach.add(sach);
	}
	
	public void Xoa(Sach sach) {
		this.danhsach.remove(sach);
	}
	
	
	
	
}
