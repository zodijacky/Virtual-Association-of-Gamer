package Beans;




import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.json.JSONException;

import entities.User;
import services.UserService;
import webservices.Clientloginhttp;




@ManagedBean
@SessionScoped
public class UserBean {
	@EJB
	private UserService service;
	private String email;

	private String password;
	private String lastName;
	private String firstName;
	private int cin;
	private String UserName;
	private User user;

	private String phone;
	private User userselected;
	private boolean loggedIn=true;
	public String getEmail() {
		return email;
	}
	
	

	public User getUserselected() {
		return userselected;
	}



	public void setUserselected(User userselected) {
		this.userselected = userselected;
	}



	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public User finduser(String  id){
		
		System.out.println("okok");
	User u=	service.getuserr(id);
	System.out.println("aaa"+u.getEmail());
		return u;	
	}
	


public String login()throws JSONException, IllegalAccessException{
	Clientloginhttp client= new Clientloginhttp();
	User u =new User();
	u.setEmail(email);
	u.setPassword(password);
	String idClient =client.login(u);
	System.out.println("test login--> this is id client==>"+idClient);
	if (idClient.equals("false")){
		System.out.println("************"+"Login false");
		
		return"/LoginIdentity?faces-redirect=true";
		
	}else
	
	{
	System.out.println(idClient.substring(1, 37).trim());
	
	
	 

	
		userselected = service.getuserr(idClient.substring(1,idClient.length()-1).trim());
		System.out.println("************"+"Login works");
		return"/VagStore?faces-redirect=true";
		 
		
	
	}
	
}

public String login2()throws JSONException, IllegalAccessException{
	Clientloginhttp client= new Clientloginhttp();
	User u =new User();
	u.setEmail(email);
	u.setPassword(password);
	String idClient =client.login(u);
	System.out.println("test login--> this is id client==>"+idClient);
	if (idClient.equals("false")){
		System.out.println("*****Login 2*******"+"Login false");
		
		
		
		String username=email;
		return"/VagStore?username=valuefaces-redirect=true";
		
	}else
	
	{
	System.out.println(idClient.substring(1, 37).trim());
	
	
	 

	
		userselected = service.getuserr(idClient.substring(1,idClient.length()-1).trim());
		System.out.println("************"+"Login works");

		
		
		
		String username=email;
		return"/SVag?username=value";
		 
		
	
	}
	
}

public String doLogout() {
	userselected = null;
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return  "/LoginIdentity.jsf?faces-redirect=true";
	
}

}
