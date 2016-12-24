package services;

import java.util.List;

import javax.ejb.Local;

import entities.Forum;

@Local
public interface ForumServiceLocal {

	
	
	public void CreateSubject(Forum c);
	List<Forum> GetAllSubject();
	List<Forum> GetAllSubjectById(int Id);
	
}
