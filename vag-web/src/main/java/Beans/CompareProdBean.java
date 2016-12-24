package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import entities.Product;

@ManagedBean
@ViewScoped 
public class CompareProdBean {
	public List<Product> CompareProducts = null;
	int SizeProd = 0;
	
	
	ProdLike pro = new ProdLike();
	List<ProdLike> Prods =  null;
	int Index = 66;
	boolean IsFound=false;
	private int Size;
  public void AddTocart(ProdLike product){
	System.out.println("**********Index of*****=>"+Index+Prods.size());
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




















public int getSize() {
	return Size;
}




















public void setSize(int size) {
	Size = size;
}




















	public List<Product> getCompareProducts() {
		return CompareProducts;
	}
	public void setCompareProducts(List<Product> compareProducts) {
		CompareProducts = compareProducts;
	}
	public int getSizeProd() {
		return SizeProd;
	}
	public void setSizeProd(int sizeProd) {
		SizeProd = sizeProd;
	} 
	
	
	
	public String AddToProd(ProdLike product ){
		System.out.println("***************");
		Product p = new Product();
		p.setCategory(product.getCategory());
		p.setIdProd(product.getId());
		p.setPrice(product.getPrice());
		p.setNameProd(product.getName_Prod());
		p.setQuantity(product.getQuantity());
		p.setPro_url(product.getPro_url());
		CompareProducts.add(p);
		SizeProd=CompareProducts.size();
		System.out.println("SizeProd");
		System.out.println(SizeProd);
		return "compare.jsf";
		
	}
}
