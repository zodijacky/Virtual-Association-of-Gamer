package services;

import java.util.List;

import javax.ejb.Local;

import entities.Cart;
import entities.Product;
import entities.WishList;



@Local
public interface ProdServiceLocal {
	
List<Product> findAllProducts();
	
	List<Product> findProductsByCategory(String category);

public void AddWishList(String u , int product);
List<WishList> FindWishList(String u);
public void delete(int id );

Product FindProdById(int id);
List<Cart> GetCart(int user);
public void addCart(Cart c);
}
