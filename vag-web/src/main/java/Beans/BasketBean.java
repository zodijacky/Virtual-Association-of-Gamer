package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Cart;
import entities.Product;
import services.ProdServiceLocal;

@ManagedBean
@SessionScoped
public class BasketBean {
	@EJB
	private ProdServiceLocal ProdService;

	public List<Product> getMyProds() {
		return ListBasket();
	}

	public void setMyProds(List<Product> myProds) {
		MyProds = myProds;
	}

	public int getSizeProd() {
		return ListBasket().size();
	}

	public void setSizeProd(int sizeProd) {
		SizeProd = sizeProd;
	}

	Cart a = new Cart();
	List<Cart> CartBase = ProdService.GetCart(1);
	int SizeCart = CartBase.size();
	List<Product> MyProds = new ArrayList<Product>();
	int SizeProd;Product p;
	int idProd ;
	

	public List<Product> ListBasket() {
    for (Cart c :CartBase ){
    	idProd=c.getId_Prod();
    	p=ProdService.FindProdById(idProd);
    	MyProds.add(p);}
    return MyProds;
	
	}
	
	public void FillBasket(ProdLike product){
		boolean exist=false;
		List<Product> pros=ListBasket();
		for (Product p :pros){
			if (p.getIdProd()==product.getId()){
				
				exist=true;
				
			}
		}
		if (exist==false){
			
			Cart c =null;
			c.setId_User(1);
			c.setId_Prod(product.getId());
			ProdService.addCart(c);
		}
		
		
	}
    	
    	
    	
    	
    
	
	
	

}
