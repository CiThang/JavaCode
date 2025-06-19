package Restaurant.Part_01.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer customer_ID;
	private String product_ID;
	private String product_Name;
	private String type;
	private Integer quantity;
	private Double price;
	private Date date;
	private String img;
	private String em_username;
	public Customer() {
	
	}
	public Customer(Integer customer_ID, String product_ID, String product_Name, String type, Integer quantity,
			Double price, Date date, String img, String em_username) {
		super();
		this.customer_ID = customer_ID;
		this.product_ID = product_ID;
		this.product_Name = product_Name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.img = img;
		this.em_username = em_username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(Integer customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getEm_username() {
		return em_username;
	}
	public void setEm_username(String em_username) {
		this.em_username = em_username;
	}
	
	
	

	
	
	
}
