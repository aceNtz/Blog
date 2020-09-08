package blog.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table
public class Tag {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	
	@Column
	private int timesUsed;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "blogpost_tag", joinColumns = @JoinColumn(name="idTag"), inverseJoinColumns = @JoinColumn(name="idBlog"))
	private List<BlogPost> blogPosts;
	
	
	// Konstruktori
	
	
	
	public Tag() {
		
	}
	
	
	
	public Tag(String name,String date, int timesUsed) {
		super();
		this.name = name;
		this.timesUsed = timesUsed;
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


	
	public int getTimesUsed() {
		return timesUsed;
	}



	public void setTimesUsed(int timesUsed) {
		this.timesUsed = timesUsed;
	}

	

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}



	public void setBlogPosts(List<BlogPost> blogPosts) {
		this.blogPosts = blogPosts;
	}


	
	
	
	// Overrajd

	@Override
	public String toString() {
		return name;
	}
	
}
