import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import services.ArticleServicesLocal;

import entities.Article;

 
@ManagedBean
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List<Article> articles = new ArrayList<>();
    
    
 
    

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@EJB
	private ArticleServicesLocal service;
	
	private PieChartModel pieArticles;
	

	public ArticleServicesLocal getService() {
		return service;
	}

	public void setService(ArticleServicesLocal service) {
		this.service = service;
	}

	public PieChartModel getPieArticles() {
		return pieArticles;
	}

	public void setpieArticles(PieChartModel pieArticles) {
		this.pieArticles = pieArticles;
	}

	@PostConstruct
    public void init() {
        createPieModels();
    }
    
	private void createPieModels() {
        createPieLikes();
        
    }
 
    private void createPieLikes() {
    	pieArticles = new PieChartModel();
		articles = service.readAllArticles();
		for (Article article : articles) {
			pieArticles.set(article.getTitleArticle(),article.getNbLike());
			
		}

		pieArticles.setTitle("Articles chart");
		pieArticles.setLegendPosition("e");
		pieArticles.setFill(false);
		pieArticles.setShowDataLabels(true);
		pieArticles.setDiameter(150);
		
    }
    public String goToHomePage(){
		return "/template/LayoutArticle?faces-redirect=true";
	}
    
    
}
     