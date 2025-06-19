package com.model;

import java.sql.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String customerName;
	private String producID;
	private String productName;
	private Date date;
	private Integer quanlity;
	private String type;
	private Double price;
	public ProductOrder() {
		
	}
	
	public ProductOrder(Integer id, String customerName, String producID, String productName, Date date,
			Integer quanlity, String type, Double price) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.producID = producID;
		this.productName = productName;
		this.date = date;
		this.quanlity = quanlity;
		this.type = type;
		this.price = price;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProducID() {
		return producID;
	}

	public void setProducID(String producID) {
		this.producID = producID;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerNam() {
		return customerName;
	}
	public void setCustomerNam(String customerNam) {
		this.customerName = customerNam;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(Integer quanlity) {
		this.quanlity = quanlity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
	
}
