package services;



import java.util.List;

import javax.ejb.Remote;

import entities.User;



@Remote
public interface UserServiceRemote {
	
 public User authentificate  (String login,String password);
 public void create(User user);
 public User find(Integer id);
 public void update(User user);
 public void delete(User user);
 public void delete(Integer id);
 public List<User> findAll();
 public User FindUserByName(String name);
	void addUser(User u);

	User findUsrById(Integer id);
	
	public User getuserr(String id);
	
 public List<User> FindUserLikeName(String name);
User findUserByLogin(String login);
 

}
