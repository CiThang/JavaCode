package Restaurant.Part_01.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String productID;
	private String productName;
	private String type;
	private Integer stock;
	private Double price;
	private String status;
	private String image;
	private Date date;
	private Integer quantity;
	
	
	public Product(String productID, String productName, String type, Integer stock, Double price,
			String status, String image, Date date) {
		this.productID = productID;
		this.productName = productName;
		this.type = type;
		this.stock = stock;
		this.price = price;
		this.status = status;
		this.image = image;
		this.date = date;
	}

	public Product() {
	}

	public Product(String productID, String productName, String type, Double price,
			 String image, Date date, Integer quantity) {
		this.productID = productID;
		this.productName = productName;
		this.type = type;
		this.price = price;
		this.image = image;
		this.date = date;
		this.quantity = quantity;
	}
	
	public Product(Integer id, String productID, String productName, String type, Double price,
			 String image, Date date, Integer quantity) {
		this.id = id;
		this.productID = productID;
		this.productName = productName;
		this.type = type;
		this.price = price;
		this.image = image;
		this.date = date;
		this.quantity = quantity;
	}


	public Product(String productID, String productName, Double price, String image, Date date) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.image = image;
	}

	public Product(String productName, String status) {
		this.productName = productName;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productID=" + productID + ", productName=" + productName + ", type=" + type
				+ ", stock=" + stock + ", price=" + price + ", status=" + status + ", image=" + image + ", date=" + date
				+ ", quantity=" + quantity + "]";
	}



}
