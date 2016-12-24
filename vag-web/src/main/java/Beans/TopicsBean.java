package Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Forum;
import services.ForumServiceLocal;



@ManagedBean
@SessionScoped
public class TopicsBean {
	@EJB
	private ForumServiceLocal forumService;

	int Posts;
	String Subject;
	String Category;
	String Description;
	String Answer;
	Date date=new Date();
	List <Forum> Topics = new ArrayList<Forum>();
	List <Forum> Single_Topic = new ArrayList<Forum>();
	Forum SelectedForum =  new Forum();
	
	
	
	public String AddSubject(){
		
		Forum c = new Forum();
		c.setSubject(Subject);
		c.setCategory(Category);
		c.setDescription(Description);
		c.setDate(date);
		c.setFirst(true);
		int radom = (int) (2 + (Math.random() * (500 - 2)));
		c.setId_Subject(radom);
		c.setId_User("1");
		c.setAnswer(Description);
		forumService.CreateSubject(c);
		
		return "" ;
	}

	
	
	public List<Forum> ListOfTopics(){
		List <Forum> Topics = new ArrayList<Forum>();
		Topics=forumService.GetAllSubject();
		return Topics;
	}
	
	public void Test (){
		
		
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
	}
	public String IsSignleTopic(Forum f){
		System.out.println("**********");
		
		String navTo = null;	
		System.out.println("aaaaaaa");
		Single_Topic=forumService.GetAllSubjectById(f.getId_Subject());
		System.out.println("***************");
		System.out.println("**************===>"+Single_Topic.size());
	    navTo = "/Topics.jsf?faces-redirect=true";
	    System.out.println(navTo);
	    Posts=Single_Topic.size()-1;
	    SelectedForum=f;
	    System.out.println("************");
	    System.out.println("************"+SelectedForum.getId_Subject());
		return navTo;
				
	}
	
	
	
	
	public String AnswerSubject(){
		  System.out.println("****************************************");
		Forum f = new Forum();
	
		 f.setDate(date);
		 f.setCategory(SelectedForum.getCategory());
		 f.setFirst(false);
		 f.setId_Subject(SelectedForum.getId_Subject());
		 f.setDescription(SelectedForum.getDescription());
		 f.setId_User("1");
		 f.setImage("u1.png");
		 f.setField1("omar");
		 f.setSubject(SelectedForum.getSubject());
		 f.setAnswer(Answer);
		 forumService.CreateSubject(f);
		 Single_Topic=forumService.GetAllSubjectById(f.getId_Subject());
		 Posts=Single_Topic.size()-1;
		 String navTo = "/Topics.jsf?faces-redirect=true";
		 return navTo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getPosts() {
		return Posts;
	}



	public void setPosts(int posts) {
		Posts = posts;
	}



	public List<Forum> getSingle_Topic() {
		return Single_Topic;
	}



	public void setSingle_Topic(List<Forum> single_Topic) {
		Single_Topic = single_Topic;
	}



	public List<Forum> getTopics() {
		return ListOfTopics();
	}



	public void setTopics(List<Forum> topics) {
		Topics = topics;
	}



	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public String getAnswer() {
		return Answer;
	}



	public void setAnswer(String answer) {
		Answer = answer;
	}
	
}
