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
@Table(name = "slider")
public class SliderElement {

	// Polja
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 4,max = 150, message = "Minimal number of characters is 4, and maximal is 150.")
	private String name;
	
	@Column
	@NotEmpty(message = "*")
	@Size(max = 150, message = "Too long.")
	private String image;
	
	@Column
	@Size(min = 4, max = 30, message = "Minimal number of characters is 4,and maximal is 30.")
	private String buttonName;
	
	@Column
	@NotEmpty(message = "*")
	@Size(max = 150, message = "Too long.")
	private String buttonUrl;
	
	@Column
	private boolean showInSlider;
	
	@Column
	private String date;
	
//	@Transient
//	private int orderBy;
	
	
	
	
	// Konstruktori
	
	public SliderElement() {
		date = new Date().toString();
	}

	
	public SliderElement(
		@Size(min = 4, max = 150, message = "Minimal number of characters is 4, and maximal is 150.") String name,
		@NotEmpty(message = "*") @Size(max = 150, message = "Too long.") String image,
		@Size(min = 4, max = 30, message = "Minimal number of characters is 4,and maximal is 30.") String buttonName,
		@NotEmpty(message = "*") @Size(max = 150, message = "Too long.") String buttonUrl, boolean showInSlider,
		String date) {
	super();
	this.name = name;
	this.image = image;
	this.buttonName = buttonName;
	this.buttonUrl = buttonUrl;
	this.showInSlider = showInSlider;
	this.date = date;
}





	// Geteri, seteri

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonUrl() {
		return buttonUrl;
	}

	public void setButtonUrl(String buttonUrl) {
		this.buttonUrl = buttonUrl;
	}

	public boolean getShowInSlider() {
		return showInSlider;
	}

	public void setShowInSlider(boolean showInSlider) {
		this.showInSlider = showInSlider;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


//	public int getOrderBy() {
//		return orderBy;
//	}
//
//
//	public void setOrderBy(int orderBy) {
//		this.orderBy = orderBy;
//	}
	
	
	
	
	
	
	
	
}
