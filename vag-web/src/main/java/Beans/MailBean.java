package Beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import services.GwMessageServiceLocal;




@ManagedBean

public class MailBean {

	@EJB
	private GwMessageServiceLocal MailService;
	String Subject;
	String to;
	String Name;
	String Content;
	
	
	public String getSubject() {
		return Subject;
	}


	public void setSubject(String subject) {
		Subject = subject;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}


	public String SendMail(){
	System.out.println("*************");
	
		
		MailService.sendEmail("Zodijacky@gmail.com", "Zodijacky@gmail.com", Subject, Content);
		 String navTo = "/VagStore?faces-redirect=true";
		 return navTo;

	}
	
}
