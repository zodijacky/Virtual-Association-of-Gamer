import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.model.UploadedFile;

import services.ArticleServices;
import services.ArticleServicesLocal;
import entities.Article;

@ManagedBean(name = "ArticlesBean")
@ViewScoped
@SessionScoped
public class ArticlesBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Article article = new Article();

	// injection de dépendances
	@EJB
	private ArticleServicesLocal articleServiceLocal;
	 //private ArticleServices Service;
	List<Article> articles = new ArrayList<>();
	// private DataModel<Article> dataModel;
	//    private UploadedFile uploadedFile;


	@PostConstruct
	public void init() {
		articles = articleServiceLocal.readAllArticles();

	}

	public String doAddArticle() {
		String navTo = null;
		articleServiceLocal.addArticle(article);
//         byte[] file = uploadedFile.getContents();
//         article.setLogoArticle(file);
//         articleServiceLocal.addArticle(article);
		navTo = "/pages/article/ReadAllArticles?faces-redirect=true";
		return navTo;
	}

	public String doUpdateArticle(int id) {
	
		String navTo = null;

		article = articleServiceLocal.findArticleById(id);
		articleServiceLocal.updateArticle(article);
		
		return navTo;
	}
	
	public String doDeleteArticle(int id) {
		String navTo = null;
		articleServiceLocal.deleteArticle(id);
		return navTo;
	}
	
	public String doLikeArticle(int id){
		String navTo = null;
		Article a = articleServiceLocal.findArticleById(id);
		a.setNbLike(a.getNbLike()+1);
		articleServiceLocal.updateArticle(a);
		return navTo;
	}
	
	public String doDislikeArticle(int id){
		String navTo = null;
		Article a = articleServiceLocal.findArticleById(id);
		a.setNbLike(a.getNbLike()-1);
		articleServiceLocal.updateArticle(a);
		
		return navTo;
	}
	
	public String doShowArticleDescription(int id){
		//String navTo = null;
		Article a = articleServiceLocal.findArticleById(id);
		String description = a.getDescriptionArticle();
		FacesMessage msg = new FacesMessage("Error");
		FacesContext.getCurrentInstance().addMessage("article_form:detail",msg);
		return description;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleServicesLocal getArticleServiceLocal() {
		return articleServiceLocal;
	}

	public void setArticleServiceLocal(ArticleServicesLocal articleServiceLocal) {
		this.articleServiceLocal = articleServiceLocal;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	
	
	

}
