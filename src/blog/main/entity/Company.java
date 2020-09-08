package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Company {

	@Transient
	public static Company instance; 
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String city;
	
	@Column
	private String streetAndNumber;
	
	@Column
	private String zipCode;
	
	@Column
	private String phoneOne;
	
	@Column
	private String phoneTwo;
	
	@Column
	private String email;
	
	@Column
	private String facebook;
	
	@Column
	private String twitter;
	
	@Column
	private String instagram;
	
	
	
	
	
	// Konstruktori
	
	private Company() {
		
	}



	private Company(String name, String streetAndNumber, String zipCode, String phoneOne, String phoneTwo, String email,
			String facebook, String twitter, String instagram, String city) {
		super();
		this.name = name;
		this.streetAndNumber = streetAndNumber;
		this.zipCode = zipCode;
		this.phoneOne = phoneOne;
		this.phoneTwo = phoneTwo;
		this.email = email;
		this.facebook = facebook;
		this.twitter = twitter;
		this.instagram = instagram;
		this.city = city;
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



	public String getStreetAndNumber() {
		return streetAndNumber;
	}



	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	public String getPhoneOne() {
		return phoneOne;
	}



	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}



	public String getPhoneTwo() {
		return phoneTwo;
	}



	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFacebook() {
		return facebook;
	}



	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}



	public String getTwitter() {
		return twitter;
	}



	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}



	public String getInstagram() {
		return instagram;
	}



	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}



	public String getCity() {
		return city;
	}
	
	

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	
	
	// Metode
	
	// Singletone
	public static Company getInstanceOfCompany() {
		if(instance == null) {
			instance = new Company();
		}
		
		return instance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
