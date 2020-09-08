package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "roles")
@Table
public class Role {

	
	@Id
	@Column
	private String authority;
	
	
	
	// Konstruktori
	
	public Role() {
		
	}
	
	
	public Role(String authority) {
		super();
		this.authority = authority;
	}











	// Geteri i seteri
	
	


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}





	// Overrajdovane metode

	@Override
	public String toString() {
		return authority;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}