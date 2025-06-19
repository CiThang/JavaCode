package com.SpringPro.SpringPro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="student")
public class Student {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "mark")
	private int mark;
	
	@Column(name = "name")
	private String name;
	
}
