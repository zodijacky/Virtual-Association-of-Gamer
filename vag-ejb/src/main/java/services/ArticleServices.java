package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Article;

/**
 * Session Bean implementation class ArticleServices
 */
@Stateless
@LocalBean
public class ArticleServices implements ArticleServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ArticleServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addArticle(Article article) {

		Boolean b = false;
		try {
			entityManager.persist(article);
			b = true;
		} catch (Exception e) {
			System.err.println("erreur ...");
		}
		return b;
	}

	@Override
	public Boolean deleteArticle(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Article.class, id));
			b = true;
		} catch (Exception e) {
			System.err.println("erreur ..." + e.toString() + "");
		}
		return b;
	}

	@Override
	public Boolean updateArticle(Article article) {
		Boolean b = false;
		try {
			entityManager.merge(article);
			b = true;
		} catch (Exception e) {
			System.err.println("erreur ..." + e.toString());
		}
		return b;
	}

	@Override
	public Article findArticleById(Integer id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	public List<Article> readAllArticles() {
		String jpql = "select a from Article a ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	

	@Override
	public void saveArticle(Article article) {
		entityManager.merge(article);

	}


    

}
