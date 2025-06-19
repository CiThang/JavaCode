package Restaurant.Part_01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
@Entity
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer customerID;
	private Double total;
	private Double amount;
	private Double changeee;
	private Date Date;
	private String em_username;
	public Receipt() {
	
	}
	
	public Receipt(Integer customerID, Double total, Double amount, Double change, java.sql.Date date,
			String em_username) {
		this.customerID = customerID;
		this.total = total;
		this.amount = amount;
		this.changeee = change;
		Date = date;
		this.em_username = em_username;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getEm_username() {
		return em_username;
	}
	public void setEm_username(String em_username) {
		this.em_username = em_username;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getChange() {
		return changeee;
	}

	public void setChange(Double change) {
		this.changeee = change;
	}
	
	
	
}
