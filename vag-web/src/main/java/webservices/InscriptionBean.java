package webservices;




import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.json.JSONException;

import entities.User;
import services.UserService;



@ManagedBean
@SessionScoped
public class InscriptionBean {

	@EJB
	private UserService  service;
	@EJB
	private UserService  serviceU;
	private int cin;
	private String test ;
public String password;

	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getPasswordHash() {
		return PasswordHash;
	}
	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}
	private String PasswordHash;
	private String firstName;
	private String lastName;
	private String adress;
	private String Email;
	
	
	
	
	
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getPassword() {
		return PasswordHash;
	}
	public void setPassword(String PasswordHash) {
		this.PasswordHash = PasswordHash;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String Inscription2()throws JSONException, IllegalAccessException{

		httpClientInscription service=new httpClientInscription();
		System.out.println("***************************************");
	    User u =new User();
		u.setEmail(Email);
		
		u.setCin(cin);
		u.setLastName(lastName);
		u.setFirstName(firstName);
		u.setPassword(PasswordHash);
		
        service.register(u);
	   
		System.out.println("***************************************");
		System.out.println("******"+u.getEmail());


		
	
	
	
	
	

		return "/LoginIdentity";
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	public String inscription()throws JSONException, IllegalAccessException{

		httpClientInscription service=new httpClientInscription();
		System.out.println("***************************************");
	    User u =new User();
		u.setEmail(Email);
		u.setId("a9ef7437-6a19-452d-8e96-252f5b07c423");
		u.setCin(cin);
		u.setLastName(lastName);
		u.setFirstName(firstName);
		u.setPassword(password);
	//	service.register(u);
	    u.setTrophiesNumber(16);
	    u.setJob("aa");
		System.out.println("***************************************");
		System.out.println("******"+u.getEmail());
		serviceU.create(u);
     u.setAccessFailedCount(false);
     u.setTwoFactorEnabled(false);
     
     u.setLockoutEnabled(false);
     u.setEmailConfirmed(false);
     u.setPhoneNumberConfirmed(false);
  
		
		System.out.println("***************************************");
		return "/VagStore.jsf";
		
	}	
	
}
