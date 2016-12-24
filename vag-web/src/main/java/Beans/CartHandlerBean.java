package Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Cart;
import entities.Product;
import services.ProdServiceLocal;

@ManagedBean
@SessionScoped
public class CartHandlerBean {

	@EJB
	private ProdServiceLocal ProdService;
	List<CartBin> cardlist = new ArrayList<CartBin>();
	List<Product> liste = new ArrayList<Product>();
	List<Product> listeCart = new ArrayList<Product>();
	List<Product> WishList = new ArrayList<Product>();
	List<Product> Panier = new ArrayList<Product>();
	
	Product p = new Product();
	int Quantity;

	double Price;
	double Total;
	String ProductName;
	int SizeProd = 0;
	int SizeProdCart = 0;
	public List<Product> getListeCart() {
		return listeCart;
	}

	public void setListeCart(List<Product> listeCart) {
		this.listeCart = listeCart;
	}

	public int getSizeProdCart() {
		return SizeProdCart;
	}

	public void setSizeProdCart(int sizeProdCart) {
		SizeProdCart = sizeProdCart;
	}

	int sizeWS;
	Product p2 = new Product();

	public Product getP2() {
		return p2;
	}

	public void setP2(Product p2) {
		this.p2 = p2;
	}

	public List<Product> getListe() {
		return liste;
	}

	public void setListe(List<Product> liste) {
		this.liste = liste;
	}

	int productid;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	Map<Integer, CartBin> map = new HashMap<Integer, CartBin>();
	private double totalPrice;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartBin> getCardlist() {
		return cardlist;
	}

	public void setCardlist(List<CartBin> cardlist) {
		this.cardlist = cardlist;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public String AddListe(ProdLike product) {
	
		String navTo ="";
		if (SizeProd == 1 && SizeProd < 3) {

			p2.setNameProd(ProductName);
			p2.setPrice(Price);
			p2.setQuantity(Quantity);
			p2.setCategory(product.getCategory());
			p2.setPro_url(product.getPro_url());
			liste.add(p2);
			SizeProd = liste.size();
			System.out.println("***********");
		 navTo = "/Compar.jsf?faces-redirect=true";
			System.out.println("***********"+navTo);
			return navTo;
		}

		else {
			if (SizeProd == 0) {
				p.setNameProd(ProductName);
				p.setPrice(Price);
				p.setQuantity(Quantity);
				p.setCategory(product.getCategory());
				p.setPro_url(product.getPro_url());
				liste.add(p);
				SizeProd = liste.size();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Choose Another One"));
				
		        
				navTo="";

			}

		}

		return navTo;

	}

	public void AddWishListe(Product product) {
		String id = "1";
		int prodName = product.getIdProd();
		ProdService.AddWishList(id, prodName);
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getSizeProd() {
		return SizeProd;
	}

	public void setSizeProd(int sizeProd) {
		SizeProd = sizeProd;
	}

	public void AddToCart(ProdLike product) {
		System.out.println("***********");
					Cart c = new Cart();
		c.setId_Prod(product.getId());
		c.setId_User(1);
		ProdService.addCart(c);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Game Added"));
	}

	public void AddToPanier(ProdLike product) {
		Boolean IsLike = false;
		int Index = 66;
		Product exist;
		Product Notexist = null;

		if (Panier.size() == 0) {
			System.out.println("******************IFFFFFFFFFFFFFF**************");
			if (product == null) {

				System.out.println("******************NULLLLLL**************");

			}
			p.setCategory(product.getCategory());
			p.setNameProd(product.getName_Prod());
			p.setPro_url(product.getPro_url());
			p.setPrice(product.getPrice());
			p.setQuantity(product.getQuantity());
			p.setIdProd(product.getId());
			Panier.add(p);

		}

		else {
			for (Product p : Panier) {
				if (p.getIdProd() == product.getId()) {

					IsLike = false;
					Index = Panier.indexOf(p);
					p.setQuantity(p.getQuantity() + 1);
					Notexist = p;
				} else {
					IsLike = true;
					Index = Panier.indexOf(p);
					exist = p;

				}

			}
		}

		if (IsLike == false) {
			p.setCategory(product.getCategory());
			p.setNameProd(product.getName_Prod());
			p.setPro_url(product.getPro_url());
			p.setPrice(product.getPrice());
			p.setQuantity(product.getQuantity());
			p.setIdProd(product.getId());
			Panier.add(p);
		} 
		
		else {
			p.setQuantity(Quantity + 1);
			Panier.remove(Index);
			Panier.add(Notexist);
			System.out.println("********************" + Panier.size() + "***************");
			System.out.println("******************aaaaaaaaaaaaaaaaaaa**************");

		}

	}

	public List<Product> getPanier() {
		return Panier;
	}

	public void setPanier(List<Product> panier) {
		Panier = panier;
	}

	public String processCart(ProdLike product) {

		CartBin cb = new CartBin();
		cb.setProductName(product.getName_Prod());
		cb.setPrice(product.getPrice());
		cb.setQuantity(product.getQuantity());

		Total = product.getPrice() * product.getQuantity();
		totalPrice = totalPrice + Total;
		cb.setTotal(Total);

		int occ = 0;
		if (cartsize > 1) {

			for (CartBin item : cardlist) {

				if (item.getProductName().equals(ProductName)) {
					occ = occ + 1;
					item.setQuantity(item.getQuantity() + Quantity);

				}

			}

		}

		if (occ == 0) {
			cardlist.add(cb);
			map.put(productid, cb);
		}

		cartsize = cardlist.size();
		if (cartsize > 1) {

			item = "items";

		}
		/*
		 * Iterator i = map.keySet().iterator();
		 * 
		 * while (i.hasNext()) { String clef = (String)i.next(); List<CartBin>
		 * ca = (List<CartBin>) map.get(cardlist); for(int j=0; j<ca.size();
		 * j++) {
		 * 
		 * 
		 * ca.get(j).getPrice(); totalPrice=ca.get(j).getPrice()+totalPrice; }
		 * 
		 * }
		 */

		return null;

	};

	int cartsize;

	public int getCartsize() {
		return cartsize;
	}

	public void setCartsize(int cartsize) {
		this.cartsize = cartsize;
	}

	String item = "item";

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String payement(){
		
		
		
	return "";	
	}
}
