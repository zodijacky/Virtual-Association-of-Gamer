package entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	

	private String Id;
	private String Email;
	public int cin ;
public String password;
@Column(columnDefinition = "LONGTEXT")
	public String getPassword() {
	return password;
}
@Column(columnDefinition = "LONGTEXT")
public void setPassword(String password) {
	this.password = password;
}




	private String lastName;
	private String firstName;
	public int trophiesNumber ;
	private String job;
	private Date birthdate;
	public byte[] picture ;
	
	
	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getTrophiesNumber() {
		return trophiesNumber;
	}

	public void setTrophiesNumber(int trophiesNumber) {
		this.trophiesNumber = trophiesNumber;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	
	

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	
	
	

	

	

	

	@Column(columnDefinition = "LONGTEXT")
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	@Column(columnDefinition = "LONGTEXT")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(columnDefinition = "LONGTEXT")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(columnDefinition = "LONGTEXT")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}




	public boolean EmailConfirmed;
	public boolean PhoneNumberConfirmed;
	public boolean TwoFactorEnabled;
	public boolean LockoutEnabled;
	public boolean AccessFailedCount;


	public boolean isEmailConfirmed() {
		return EmailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		EmailConfirmed = emailConfirmed;
	}

	public boolean isPhoneNumberConfirmed() {
		return PhoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		PhoneNumberConfirmed = phoneNumberConfirmed;
	}

	public boolean isTwoFactorEnabled() {
		return TwoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		TwoFactorEnabled = twoFactorEnabled;
	}

	public boolean isLockoutEnabled() {
		return LockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		LockoutEnabled = lockoutEnabled;
	}

	public boolean isAccessFailedCount() {
		return AccessFailedCount;
	}

	public void setAccessFailedCount(boolean accessFailedCount) {
		AccessFailedCount = accessFailedCount;
	}
	
}
