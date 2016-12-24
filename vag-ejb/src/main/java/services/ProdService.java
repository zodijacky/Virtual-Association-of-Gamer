package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Cart;
import entities.Product;
import entities.WishList;


@Stateless
@LocalBean
public class ProdService implements  ProdServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
	
    public ProdService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Product> findAllProducts() {
		return em.createQuery("select p from Product p", Product.class)
				.getResultList();
	}






	@Override
	public List<Product> findProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddWishList(String u, int product) {
		WishList wl = new WishList();
		wl.setProductId(product);
		wl.setUsername(u);
		//em.merge(wl);
		em.persist(wl);
		
	}

	@Override
	public List<WishList> FindWishList(String u) {
		List<WishList> found = new ArrayList<WishList>();
		String jpql = "select a from WishList a where a.Username= :name";
		Query query = em.createQuery(jpql);
		query.setParameter("name", u);

		
		try{
			found =query.getResultList();
		}catch(Exception ex){
		}
		return found ;
	}

	@Override
	public Product FindProdById(int id) {
		// TODO Auto-generated method stub
		 return em.find(Product.class, id);
	}

	@Override
	public void delete(int id) {
		
		em.find(WishList.class,id);
		em.merge(em.find(WishList.class, id));
		em.remove(em.find(WishList.class, id));
	}

	@Override
	public List<Cart> GetCart(int user) {
		List<Cart> found = new ArrayList<Cart>();
		String jpql = "select a from Cart a where a.Id_User= :name";
		Query query = em.createQuery(jpql);
		query.setParameter("name", user);

		
		try{
			found =query.getResultList();
		}catch(Exception ex){
		}
		return found ;
	}

	@Override
	public void addCart(Cart c) {

	em.persist(c);
		
	}
	}


