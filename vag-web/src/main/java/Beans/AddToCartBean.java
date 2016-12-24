package Beans;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.Cart;
import entities.Product;
import services.ProdServiceLocal;


@ManagedBean
@RequestScoped
public class AddToCartBean {
	@EJB
	private ProdServiceLocal ProdService;
	ProdLike pro = new ProdLike();
	List<ProdLike> Prods = null;
	
	int Index = 66;
	boolean IsFound=false;
	private int Size=0;
  public void AddTocart(ProdLike product){
	System.out.println("**********Index of*****=>"+Index);
	if (Prods.size()==0 ){
		System.out.println("**********I'm in In Taille 0 **size=0***=>"+Index);
		Prods.add(product);
		
	}
	System.out.println("**********Taille ** After size=0***=>"+Prods.size());
	if (Prods.size()>0){
		for(ProdLike p : Prods){
			if ( product.getId()==p.getId())
			{
				Index= Prods.indexOf(p);
				System.out.println("**********Index of****if+for*=>"+Index);
				IsFound=true;
				
			}
			else{
				Index= Prods.indexOf(p);
				System.out.println("**********Index of**else+for***=>"+Index);
				IsFound=false;
				p.setQuantity(p.getQuantity()+1);
				pro=p;
			}
			
		}
		if (IsFound==false && Prods.size()>0 ){
			System.out.println("**********I'm in In Found *****=>"+Index);
			Prods.add(product);
			
		}
		
	
		else {
			System.out.println("**********I'm in Else*****=>"+Index);
			Prods.remove(Index);
			Prods.add(pro);
			
		}
		
		
	}
	
	
	Size=Prods.size();
	System.out.println("*************************===>size"+Size);
}
  
  public void test(){
	  
	  
	  System.out.println("*********************");
	  System.out.println("*********************");
	  System.out.println("*********************");
  }
public int getSize() {
	return Size;
}
public void setSize(int size) {
	Size = size;
}
public ProdLike getPro() {
	return pro;
}
public void setPro(ProdLike pro) {
	this.pro = pro;
}
public List<ProdLike> getProds() {
	return Prods;
}
public void setProds(List<ProdLike> prods) {
	Prods = prods;
}
public int getIndex() {
	return Index;
}
public void setIndex(int index) {
	Index = index;
}
public boolean isIsFound() {
	return IsFound;
}
public void setIsFound(boolean isFound) {
	IsFound = isFound;
}
	
Cart a = new Cart();
List<Cart> CartBase = ProdService.GetCart(1);
int SizeCart = CartBase.size();
List<Product> MyProds = new ArrayList<Product>();
int SizeProd;Product p;
int idProd ;
	

public List<Product> ListBasket() {
    for (Cart c :CartBase){
    	idProd=c.getId_Prod();
    	p=ProdService.FindProdById(idProd);
    	MyProds.add(p);}
    return MyProds;
	
	}
public List<Product> getMyProds() {
	return  ListBasket();
}
public void setMyProds(List<Product> myProds) {
	MyProds = myProds;
}
	
	
	
	
	
}
