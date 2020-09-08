package blog.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Category {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 2, max = 45, message = "Minimal number of characters is 2, and maximal is 45.")
	private String name;
	
	@Column
	@Size(min = 2, max = 200, message = "Minimal number of characters is 2, and maximal is 200.")
	private String description;
	
	@Column
	private String date;
	
	@Column
	private int timesUsed;
	
	@Column
	private boolean important;
	
	
	
	
	// Konstruktori
	
	public Category() {
		date = new Date().toString();
	}


	public Category(
			@Size(min = 2, max = 45, message = "Minimal number of characters is 2, and maximal is 45.") String name,
			@Size(min = 2, max = 200, message = "Minimal number of characters is 2, and maximal is 200.") String description,
			String date, int timesUsed, boolean important) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.timesUsed = timesUsed;
		this.important = important;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	public int getTimesUsed() {
		return timesUsed;
	}


	public void setTimesUsed(int timesUsed) {
		this.timesUsed = timesUsed;
	}


	public boolean getImportant() {
		return important;
	}


	public void setImportant(boolean important) {
		this.important = important;
	}

	
	
	
	// Overrajd

	@Override
	public String toString() {
		return name;
	}
	
}
