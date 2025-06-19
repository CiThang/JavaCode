package Restaurant.Part_01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customeraccount")
public class CustomerAccount  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	private String cusname;
	private String email;
	private String password;

	
	public CustomerAccount(Integer id, String cusName, String email, String password) {
		this.id = id;
		this.cusname = cusName;
		this.email = email;
		this.password = password;
	}
	public CustomerAccount() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusName() {
		return cusname;
	}
	public void setCusName(String cusName) {
		this.cusname = cusName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
