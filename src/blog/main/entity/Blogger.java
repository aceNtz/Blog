package blog.main.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity(name = "users")
@Table
public class Blogger {

	
	@Id
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String image;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	private String dateJoined;
	
	@Column
	private boolean enabled;
	
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Role> authorities;
	
	
	
	// Konstruktori
	
	public Blogger() {
		dateJoined = new Date().toString();
		enabled = true;
	}

	public Blogger(String password,String name,String surname,String image,String phone,String email, String dateJoined, boolean enabled,
			List<Role> authorities) {
		super();
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.image = image;
		this.phone = phone;
		this.email = email;
		this.dateJoined = dateJoined;
		this.enabled = enabled;
		this.authorities = authorities;
	}




	


	
	// Geteri i seteri



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	

	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDateJoined() {
		return dateJoined;
	}



	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}



	public boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
	public List<Role> getAuthorities() {
		return authorities;
	}



	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

 
	


	
	
	
	
	// Overrajdovane metode

	@Override
	public String toString() {
		return username;
	}

	
	
	
	
	
}
