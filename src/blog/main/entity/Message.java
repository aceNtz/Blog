package blog.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table
public class Message {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 2, max = 45, message = "Minimal number of characters is 2, and maximal is 45.")
	private String name;
	
	@Column
	@Email
	@Size(min = 10, max = 45, message = "Minimal number of characters is 10, and maximal is 45.")
	private String email;
	
	@Column
	@Size(min = 15, max = 1500, message = "Minimal number of characters is 15, and maximal is 1500.")
	private String message;
	
	@Column
	private boolean seen;
	
	@Column
	private String date;
	
	
	// Konstruktori
	
	
	
	public Message() {
		seen = false;
		date = new Date().toString();
	}
	
	

	public Message(
			@Size(min = 2, max = 45, message = "Minimal number of characters is 2, and maximal is 45.") String name,
			@Email @Size(min = 10, max = 45, message = "Minimal number of characters is 10, and maximal is 45.") String email,
			@Size(min = 15, max = 1500, message = "Minimal number of characters is 15, and maximal is 1500.") String message,
			boolean seen, String date) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
		this.seen = seen;
		this.date = date;
	}

	
	
	

	// Geteri i seteri


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
