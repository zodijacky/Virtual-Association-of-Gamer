package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WishList
 *
 */
@Entity

public class WishList implements Serializable {

	   
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Username;
	private int ProductId;
	private static final long serialVersionUID = 1L;

	public WishList() {
		super();
	}   
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}   
	public String getUsername() {
		return this.Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}   
	public int getProductId() {
		return this.ProductId;
	}

	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
   
}
