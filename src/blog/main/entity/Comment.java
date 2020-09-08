package blog.main.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment {

	@Id
	@Column
	@GeneratedValue
	private int id;
	
	@Column
	private String date;
	
	@JoinColumn(name = "blogPostId")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private BlogPost blogPost;
	
	@Column
	private boolean visible;
	
	@Column
	private String comment;
	
	
	// Konstruktori
	
	public Comment() {
		date = new Date().toString();
		visible = true;
	}
	
	

	public Comment(String date, BlogPost blogPost, boolean visible, String comment) {
		super();
		this.date = date;
		this.blogPost = blogPost;
		this.visible = visible;
		this.comment = comment;
	}
	
	
	


	
	
	// Geteri i seteri


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public BlogPost getBlogPost() {
		return blogPost;
	}


	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}



	public boolean getVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	// Overrajd
	
	
	@Override
	public String toString() {
		return "id";
	}
	
	
	
	
	
}
