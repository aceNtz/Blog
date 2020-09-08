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
public class FrontText {

	@Transient
	public static FrontText instance;
	
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	
	@Column
	private String slogan;
	
	@Column
	private String indexIntro;
	
	@Column
	private String indexText1;
	
	@Column
	private String indexText2;
	
	@Column
	private String indexText3;
	
	@Column
	private String indexText4;
	
	@Column
	private String latestFromTheBlogIntro;
	
	
	
	
	// Konstruktori
	
	private FrontText() {
		
	}


	private FrontText(String slogan, String indexIntro, String indexText1, String indexText2, String indexText3,
			String indexText4, String latestFromTheBlogIntro) {
		super();
		this.slogan = slogan;
		this.indexIntro = indexIntro;
		this.indexText1 = indexText1;
		this.indexText2 = indexText2;
		this.indexText3 = indexText3;
		this.indexText4 = indexText4;
		this.latestFromTheBlogIntro = latestFromTheBlogIntro;
	}


	
	
	
	
	// Geteri i seteri 
	
	
	
	public static FrontText getInstance() {
		return instance;
	}


	public static void setInstance(FrontText instance) {
		FrontText.instance = instance;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSlogan() {
		return slogan;
	}


	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}


	public String getIndexIntro() {
		return indexIntro;
	}


	public void setIndexIntro(String indexIntro) {
		this.indexIntro = indexIntro;
	}


	public String getIndexText1() {
		return indexText1;
	}


	public void setIndexText1(String indexText1) {
		this.indexText1 = indexText1;
	}


	public String getIndexText2() {
		return indexText2;
	}


	public void setIndexText2(String indexText2) {
		this.indexText2 = indexText2;
	}


	public String getIndexText3() {
		return indexText3;
	}


	public void setIndexText3(String indexText3) {
		this.indexText3 = indexText3;
	}


	public String getIndexText4() {
		return indexText4;
	}


	public void setIndexText4(String indexText4) {
		this.indexText4 = indexText4;
	}
	
	
	public String getlatestFromTheBlogIntro() {
		return latestFromTheBlogIntro;
	}


	public void setlatestFromTheBlogIntro(String latestFromTheBlogIntro) {
		this.latestFromTheBlogIntro = latestFromTheBlogIntro;
	}
	
	
	
	
	// Metode
	
	// Singletone
	public static FrontText getFrontText() {
		if(instance == null) {
			instance = new FrontText();
		}
		
		return instance;
	}
	
	
	
	
	
	
	
	
	
}
