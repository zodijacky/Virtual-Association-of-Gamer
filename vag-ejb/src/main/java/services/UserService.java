package services;



import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;








import javax.validation.OverridesAttribute;

import entities.User;



/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext
	private EntityManager em;
 
    public UserService() { }

	@Override
	public User authentificate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:x and u.passWord=:y";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("x", login);
		query.setParameter("y", password);
		
		try{
			found  = query.getSingleResult();
		}catch(NoResultException e){
			Logger
				.getLogger(getClass().getName())
					.log(Level.WARNING, "auth attempt failed with login="+login+" and passWord="+password);
		}
		
		return found;
	}
	@Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public User find(Integer id) {
		return em.find(User.class, id);
	}

	@Override
	public void update(User user) {
		em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(em.merge(user));
	}
	@Override
	public void delete(Integer id) {
		em.remove(em.find(User.class, id));
	}
  
	@Override
	public List<User> findAll() {

		
		return em
				.createQuery("select u from User u", User.class)
				.getResultList();
	}

	@Override
public User FindUserByName(String name) {
		User user=null;
		String jpql = "Select u from User u where u.lastName=:x";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("x", name);
		user=  query.getSingleResult();
		return user;
} 
	@Override 
	public List<User> FindUserLikeName(String name)
	{
	return em
			.createQuery("select u  from User u where u.firstName LIKE '"+name+"%'",User.class)				
			.getResultList();
 }
	
	@Override
	public User findUserByLogin(String login) {

		User user = null;
		
		try {
			
		user = 
				em.createQuery("SELECT u FROM User u where u.login = '"+login+"'", User.class)
				.getSingleResult();
		if(user == null)
			user = 
			em.createQuery("SELECT a FROM Admin u where u.login = '"+login+"'", User.class)
			.getSingleResult();
		if(user == null)
			user = 
			em.createQuery("SELECT a FROM Student u where u.login = '"+login+"'", User.class)
			.getSingleResult();
		if(user == null)
			user = 
			em.createQuery("SELECT a FROM Driver u where u.login = '"+login+"'", User.class)
			.getSingleResult();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public void addUser(User u) {

		em.persist(u);
	}

	@Override
	public User findUsrById(Integer id) {
		User u = null;
		try {
			u = em.find(User.class, id);
		} catch (Exception e) {

		}
		return u;
	}

	@Override
	public User getuserr(String id) {
	String text= "select u from User u where u.id=:id ";
	Query query= em.createQuery(text).setParameter("id", id);
	User userfind=(User) query.getSingleResult();
		
	return userfind;


	}
	

}
