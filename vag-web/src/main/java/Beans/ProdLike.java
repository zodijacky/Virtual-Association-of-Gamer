package Beans;

public class ProdLike {

	
	int id ;
	String Name_Prod ;
	Double Price ;
	Integer Quantity;
	String Category;
	String pro_url;
	int liiked ;
	String url_like ;
	public String getUrl_like() {
		return url_like;
	}
	public void setUrl_like(String url_like) {
		this.url_like = url_like;
	}
	public int getLiiked() {
		return liiked;
	}
	public void setLiiked(int liiked) {
		this.liiked = liiked;
	}
	public String getPro_url() {
		return pro_url;
	}
	public void setPro_url(String pro_url) {
		this.pro_url = pro_url;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	Boolean Liked ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_Prod() {
		return Name_Prod;
	}
	public void setName_Prod(String name_Prod) {
		Name_Prod = name_Prod;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Boolean getLiked() {
		return Liked;
	}
	public void setLiked(Boolean liked) {
		Liked = liked;
	}
	
}
