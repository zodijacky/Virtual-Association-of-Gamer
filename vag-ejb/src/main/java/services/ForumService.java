package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Forum;
import entities.Product;
import entities.WishList;

/**
 * Session Bean implementation class ForumService
 */
@Stateless
@LocalBean
public class ForumService implements ForumServiceRemote, ForumServiceLocal {
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ForumService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void CreateSubject(Forum c) {
		em.persist(c);
		
	}

	@Override
	public List<Forum> GetAllSubject() {
		List<Forum> found = new ArrayList<Forum>();
		String jpql = "select a from Forum a where a.First= :name ORDER BY a.Date ";
		Query query = em.createQuery(jpql);
		query.setParameter("name", true);

		
		try{
			found =query.getResultList();
		}catch(Exception ex){
		}
		return found ;
	}

	@Override
	public List<Forum> GetAllSubjectById(int Id) {
		List<Forum> found = new ArrayList<Forum>();
		String jpql = "select a from Forum a where a.Id_Subject= :name ORDER BY a.Date ";
		Query query = em.createQuery(jpql);
		query.setParameter("name", Id);

		
		try{
			found =query.getResultList();
		}catch(Exception ex){
		}
		return found ;
	}

}
