package com.model;

import javax.crypto.SecretKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cusname;
	private String email;
	private String password;
	private SecretKey secretkey;

	public CustomerAccount(Integer id, String cusname, String email, String password, SecretKey secretkey) {
		this.id = id;
		this.cusname = cusname;
		this.email = email;
		this.password = password;
		this.secretkey = secretkey;
	}

	public CustomerAccount() {
	}

	public SecretKey getSecretkey() {
		return secretkey;
	}

	public void setSecretkey(SecretKey secretkey) {
		this.secretkey = secretkey;
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
