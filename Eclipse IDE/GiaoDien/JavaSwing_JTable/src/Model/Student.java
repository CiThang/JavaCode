package Model;

public class Student {

	private String id, name, address;
	public Student() {
		
	}
	public Student(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
	public Student(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
