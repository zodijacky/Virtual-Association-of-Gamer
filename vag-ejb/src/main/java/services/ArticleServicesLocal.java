package services;

import java.util.List;

import javax.ejb.Local;

import entities.Article;

@Local
public interface ArticleServicesLocal {
	
	
	Boolean addArticle(Article article);
	Boolean deleteArticle(Integer id);
	Boolean updateArticle(Article article);
	Article findArticleById(Integer id);
	List<Article> readAllArticles();
	void saveArticle(Article article);
	
}
