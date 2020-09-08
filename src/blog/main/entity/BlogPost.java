package blog.main.entity;

import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class BlogPost {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String image;
	
	@JoinColumn(name = "idCategory")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Category category;
	
	@JoinColumn(name = "usernameAuthor")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Blogger author;
	
	@Column
	private LocalDate date;
	
	@OneToMany(mappedBy = "blogPost")
	private List<Comment> comments;
	
	@Column
	private boolean enabled;
	
	@Column
	private boolean important;
	
	@Column
	private long viewCount;
	
	@JoinTable(name = "blogpost_tag", joinColumns = @JoinColumn(name = "idBlog"), inverseJoinColumns = @JoinColumn(name = "idTag"))
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Tag> tags;
	
	@Column
	private String description;
	
	@Transient
	private String dateOptionOne;
	
	@Transient
	private String dateOptionTwo;
	
	//TODO TEKST BLOGA
	
	
	




	// Konstruktori
	
	
	public BlogPost() {
		date = LocalDate.now();
	}


	public BlogPost(String name, String image, Category category, Blogger author, LocalDate date, List<Comment> comments,
			boolean enabled, boolean important, long viewCount, List<Tag> tags, String description, String dateOptionOne, String dateOptionTwo) {
		super();
		this.name = name;
		this.image = image;
		this.category = category;
		this.author = author;
		this.date = date;
		this.comments = comments;
		this.enabled = enabled;
		this.important = important;
		this.viewCount = viewCount;
		this.tags = tags;
		this.description = description;
		this.dateOptionOne = dateOptionOne;
		this.dateOptionTwo = dateOptionTwo;
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



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Blogger getAuthor() {
		return author;
	}


	
	public void setAuthor(Blogger author) {
		this.author = author;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public boolean getImportant() {
		return important;
	}



	public void setImportant(boolean important) {
		this.important = important;
	}



	public long getViewCount() {
		return viewCount;
	}



	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
	public List<Tag> getTags() {
		return tags;
	}



	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getDateOptionOne() {
		return dateOptionOne;
	}


	public void setDateOptionOne(String dateOptionOne) {
		this.dateOptionOne = dateOptionOne;
	}


	public String getDateOptionTwo() {
		return dateOptionTwo;
	}


	public void setDateOptionTwo(String dateOptionTwo) {
		this.dateOptionTwo = dateOptionTwo;
	}
	
	
	
	
	
	
	// Overrajd 
	



	@Override
	public String toString() {
		return "name";
	}
	
	
	
}
