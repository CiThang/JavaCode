package Restaurant.Part_01.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String username;
	
	private String password;
	
	private String question;
	
	private String answer;
	
	private Date date;

	public int getId() {
		return id;
	}
	
	

	public Employee( String username, String password, String question, String answer, Date date) {
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.date = date;
	}


	public Employee() {
		super();
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getUsename() {
		return username;
	}

	public void setUsename(String usename) {
		this.username = usename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
