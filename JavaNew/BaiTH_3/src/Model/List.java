package Model;

import java.util.ArrayList;

public class List {

	private ArrayList<Student> list;

	public List() {
		this.list = new ArrayList<Student>();
	}
	
	public List(ArrayList<Student> list) {
		this.list = list;
	}
	
	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}

	public void add(Student student) {
		this.list.add(student);
	}
	
	public void delete(Student student) {
		this.list.remove(student);
	}
	
	public void xoaall() {
		this.list.removeAll(list);
	}
	
	
	
	
}
