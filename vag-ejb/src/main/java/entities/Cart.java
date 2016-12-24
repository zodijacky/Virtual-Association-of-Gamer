package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cart
 *
 */
@Entity

public class Cart implements Serializable {

	@GeneratedValue   
	@Id
	private int IdCarte;
	private int Id_User;
	private int Id_Prod;
	private static final long serialVersionUID = 1L;

	public Cart() {
		super();
	}   
	public int getIdCarte() {
		return this.IdCarte;
	}

	public void setIdCarte(int IdCarte) {
		this.IdCarte = IdCarte;
	}   
	public int getId_User() {
		return this.Id_User;
	}

	public void setId_User(int Id_User) {
		this.Id_User = Id_User;
	}   
	public int getId_Prod() {
		return this.Id_Prod;
	}

	public void setId_Prod(int Id_Prod) {
		this.Id_Prod = Id_Prod;
	}
   
}
