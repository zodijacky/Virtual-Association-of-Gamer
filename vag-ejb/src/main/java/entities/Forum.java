package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Forum
 *
 */
@Entity

public class Forum implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Subject;
	private String Category;
	private boolean First;
	private String Description;
	private int Id_Subject;
	private String Id_User;
	private Date Date;
	private String Image;
	private String Answer;
	private String field1;
	private String field2;
	private static final long serialVersionUID = 1L;

	public Forum() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.Subject;
	}

	public void setSubject(String Subject) {
		this.Subject = Subject;
	}   
	public String getCategory() {
		return this.Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}   
	public boolean getFirst() {
		return this.First;
	}

	public void setFirst(boolean First) {
		this.First = First;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public int getId_Subject() {
		return this.Id_Subject;
	}

	public void setId_Subject(int Id_Subject) {
		this.Id_Subject = Id_Subject;
	}   
	public String getId_User() {
		return this.Id_User;
	}

	public void setId_User(String Id_User) {
		this.Id_User = Id_User;
	}   
	public Date getDate() {
		return this.Date;
	}

	public void setDate(Date Date) {
		this.Date = Date;
	}   
	public String getImage() {
		return this.Image;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}   
	public String getAnswer() {
		return this.Answer;
	}

	public void setAnswer(String Answer) {
		this.Answer = Answer;
	}   
	public String getField1() {
		return this.field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}   
	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
   
}
