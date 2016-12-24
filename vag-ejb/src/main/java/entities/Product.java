package entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;





/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	   
	@GeneratedValue
	@Id
	private Integer IdProd;
private String NameProd;
private String Category ;


	public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
	public String getNameProd() {
	return NameProd;
	
}
public void setNameProd(String nameProd) {
	NameProd = nameProd;
}


	private String User_Id;
	private Integer Quantity;
	private Double Price;
	private String Pro_url;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	
	public void setPro_url(String pro_url) {
		Pro_url = pro_url;
	}
	public Integer getIdProd() {
		return this.IdProd;
	}

	public void setIdProd(Integer IdProd) {
		this.IdProd = IdProd;
	}   
	
	public String getUser_Id() {
		return this.User_Id;
	}

	public void setUser_Id(String User_Id) {
		this.User_Id = User_Id;
	}   
	public Integer getQuantity() {
		return this.Quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.Quantity = Quantity;
	}   
	public Double getPrice() {
		return this.Price;
	}

	public void setPrice(Double Price) {
		this.Price = Price;
	}   
	public String getPro_url() {
		return this.Pro_url;
	}


	 
	 
	 
   
}
