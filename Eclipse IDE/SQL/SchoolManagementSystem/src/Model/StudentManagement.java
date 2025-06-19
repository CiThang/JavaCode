package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import DAO.TeacherSystemDao;

public class StudentManagement {

	private ArrayList<Student> students;
	
	public StudentManagement() {
		this.students = new ArrayList<Student>();
	}

	
	
	public StudentManagement(ArrayList<Student> students) {
		this.students = students;
	}
	
	public ArrayList<Student> getListStudent(){
		return students;
	}
	
	public void insert(Student st) {
		this.students.add(st);
	}
	
	public void update(Student st) {
		this.students.remove(st);
		this.students.add(st);
	}
	public boolean kiemTraTonTai (Student st ) {
		for (Student student : students) {
			if(student.getMaHocSinh() == st.getMaHocSinh()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean kiemtratontaitheoID(int mahocsinh) {
		for (Student student : students) {
			if(student.getMaHocSinh() == mahocsinh) {
				return true;
			}
		}
		return false;
	}
	
	public void hienThi() {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
	
	public ArrayList<Student> xapxepToan(ArrayList<Student> st) {
		 Collections.sort(st, new Comparator<Student>() {
	            @Override
	            public int compare(Student student1, Student student2) {
	                // So sánh theo điểm toán giảm dần
	                return Float.compare(student2.getDiemToan(), student1.getDiemToan());
	            }
	        });
		 return st;
	}
	public ArrayList<Student> xapxepVan(ArrayList<Student> st) {
		 Collections.sort(st, new Comparator<Student>() {
	            @Override
	            public int compare(Student student1, Student student2) {
	                // So sánh theo điểm toán giảm dần
	                return Float.compare(student2.getDiemVan(), student1.getDiemVan());
	            }
	        });
		 return st;
	}
	public ArrayList<Student> xapxepAnh(ArrayList<Student> st) {
		 Collections.sort(st, new Comparator<Student>() {
	            @Override
	            public int compare(Student student1, Student student2) {
	                // So sánh theo điểm toán giảm dần
	                return Float.compare(student2.getDiemAnh(), student1.getDiemAnh());
	            }
	        });
		 return st;
	}


	



	
		
	
}
