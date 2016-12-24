package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Product;
import entities.WishList;
import services.ProdServiceLocal;

@ManagedBean
@SessionScoped
public class WishListBean {
	@EJB
	private ProdServiceLocal ProdService;
int WishTaille;
	public int getWishTaille() {
	return WslistP().size();
}

public void setWishTaille(int wishTaille) {
	WishTaille = wishTaille;
}

	public List<WishList> getWishLists() {
		return ProdService.FindWishList("1");
	}

	public int getSizews() {
		return WslistP().size();
	}

	public void setSizews(int sizews) {
		Sizews = sizews;
	}

	int Sizews = 0;
	private int id_p;
	List<Product> WSlist = new ArrayList<Product>();
	private Integer id_prod2;

	public List<Product> getWSlist() {
		return WslistP();
	}

	public void setWSlist(List<Product> wSlist) {
		WSlist = wSlist;
	}

	List<Product> WslistP() {
		List<Product> MyProds = new ArrayList<Product>();
		for (WishList p : ProdService.FindWishList("1")) {
			id_p = p.getProductId();
			Product pro = ProdService.FindProdById(id_p);
			MyProds.add(pro);
		}
		return MyProds;
	}

	public void delete(ProdLike prod) {
		for (WishList p : ProdService.FindWishList("1")) {
			id_p = p.getProductId();
			if (id_p == prod.getId()) {

				ProdService.delete(p.getId());
			}

		}
	}

	public void AddWishListe(ProdLike product) {
		System.out.println("**********************************EXIST*********************");
		boolean exist = false;

		List<Product> MyProd = WslistP();
		
	
		if (MyProd.contains(product)){

			System.out.println("**********************************EXIST*********************");
			
			exist=true;}
		else {ProdService.AddWishList("1", product.getId());}
			

		

		if (exist = false || WslistP().size() == 0) {

			System.out.println("********************************************************");
			System.out.println("IM HEREERE FAAAAAAAAAAAAAAAAALSE" + exist);
			System.out.println("********************************************************");
			String id = "1";
			int prodName = product.getId();
			ProdService.AddWishList(id, prodName);
		}
	

	}
	
	public void SearchIn(Product product){
		List<Product> MyProd = WslistP();
		System.out.println("************");
		System.out.println("************"+MyProd.size()+"**************");
		System.out.println("************");
		
		for (WishList p : ProdService.FindWishList("1")) {
			
			System.out.println("************");
			id_p = p.getProductId();
			id_prod2 = product.getIdProd();
			if ( id_p==id_prod2){
				System.out.println("******Exists******");
				
				
			}
			
		}
		/*if (MyProd.contains(product)){
			
			System.out.println("******Exists******");
		}
		else{System.out.println("******NO****Exists******");}*/
	}
		
	
}
