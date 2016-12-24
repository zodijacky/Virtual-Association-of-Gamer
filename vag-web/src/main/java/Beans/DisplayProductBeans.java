package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Cart;
import entities.Product;
import entities.WishList;
import services.ProdServiceLocal;

@ManagedBean
@SessionScoped
public class DisplayProductBeans {
	@EJB
	private ProdServiceLocal ProdService;
	private Product SelectedProduct ; 
	private Product SelectedProd1;
	private Product SelectedProd2;
	List<ProdLike> MyProds = new ArrayList<ProdLike>();
	
	
	
public List<ProdLike> getMyProds() {
		return WslistP();
	}
public void test(){
	
	
	System.out.println("*********************");
	System.out.println("*********************");
	System.out.println("*********************");
	System.out.println("*********************");
}


	public void setMyProds(List<ProdLike> myProds) {
		MyProds = myProds;
	}



public Product getSelectedProduct() {
		return SelectedProduct;
	}



	public void setSelectedProduct(Product selectedProduct) {
		SelectedProduct = selectedProduct;
	}

	Product product = new Product();
public List<Product> Products = null;
private int id_p;
private Integer id_prod2;
private String Liked;
private boolean Like;
public String getLiked() {
	return Liked;
}



public void setLiked(String liked) {
	Liked = liked;
}



public List<Product> getAllProduct (){
	
	
	Products = ProdService.findAllProducts();
	return Products;
}



public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}
List<ProdLike> WslistP() {

	if (MyProds.size()==0 || MyProds.size()<ProdService.findAllProducts().size()){
	for (Product p :  ProdService.findAllProducts()) {
		Like = SearchIn(p);
		System.out.println("******WslistP()******");
		ProdLike pr = new ProdLike();
		if (Like==true){pr.setLiiked(222);
		pr.setUrl_like("full_heart.png");
		}
		else{ pr.setLiiked(0);
	
		pr.setUrl_like("empty_heart.png");
		}
		pr.setId(p.getIdProd());
		pr.setName_Prod(p.getNameProd());
		pr.setPrice(p.getPrice());
		pr.setQuantity(p.getQuantity());
		pr.setLiked(Like);
		pr.setPro_url(p.getPro_url());
		Product pro = ProdService.FindProdById(id_p);
		pr.setLiiked(MyProds.size());
		MyProds.add(pr);
		
	}
	}
	return MyProds;
}

public Boolean SearchIn(Product product){
	Like=false;
	List<Product> MyProd = ProdService.findAllProducts();
	System.out.println("************");
	System.out.println("************"+MyProd.size()+"**************");
	System.out.println("************");
	
	for (WishList p : ProdService.FindWishList("1")) {
		
		System.out.println("************");
		id_p = p.getProductId();
		id_prod2 = product.getIdProd();
		if ( id_p==id_prod2){
			System.out.println("******Exists******");
			Like=true;
			te = 222;
			System.out.println("******Exists******");
		}
		else {Like=false;
		te=0;
		}
		
	}
	
	return Like ;
}
int te;



public int getTe() {
	return te;
}



public void setTe(int te) {
	this.te = te;
}







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
List<Cart> CartBase =new ArrayList<Cart>();
int idProd;
Product pa = new Product();
List<Product> MyProdB = new ArrayList<Product>();

public List<Product> getMyProdB() {
	return ListBasket();
}
int SizeCart;


public int getSizeCart() {
	return ListBasket().size();
}



public void setSizeCart(int sizeCart) {
	SizeCart = sizeCart;
}



public void setMyProdB(List<Product> myProdB) {
	MyProdB = myProdB;
}


double TotalCart=0;
public double getTotalCart() {
	return TotalCart;
}



public void setTotalCart(double totalCart) {
	TotalCart = totalCart;
}

public void AddToBasket(ProdLike product){
	System.out.println("*********ADD TO BASKET***********");
	List<Product> list = ListBasket();
	boolean found = false;
	boolean zero=false;
	System.out.println("**********Index of*****=>"+Index);
	if (Prods.size()==0 ){
		zero=true;
		System.out.println("**********I'm in In Taille 0 **size=0***=>"+Index);
		Cart c = new Cart();
		c.setId_Prod(product.getId());
		c.setId_User(1);
		ProdService.addCart(c);
		
		
		}else {
			for ( Product p : list){
				if ( p.getIdProd()==product.getId())
				{found=true;}
			}
			
			
		}
	if( (found==false) && (zero==false)){
		Cart c = new Cart();
		c.setId_Prod(product.getId());
		c.setId_User(1);
		ProdService.addCart(c);
		
	}
		
	}

public List<Product> ListBasket() {
	System.out.println("*************");
	
	CartBase = ProdService.GetCart(1);
	
	if(MyProdB.size()==0 || CartBase.size()>MyProdB.size()){
	System.out.println("*************"+CartBase.size());
    for (Cart c :CartBase){
    	idProd=c.getId_Prod();
    	pa=ProdService.FindProdById(idProd);
    	TotalCart=pa.getPrice()+TotalCart;
    	MyProdB.add(pa);
    	System.out.println("*************");
    	System.out.println(MyProdB.size());
    	System.out.println("**********TotalCart***"+TotalCart);
    }}
    return MyProdB;
	
	}




















}
