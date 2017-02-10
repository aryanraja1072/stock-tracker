package main.java.model;
// default package
// Generated Feb 9, 2017 11:38:22 PM by Hibernate Tools 5.2.0.CR1

/**
 * UserStock generated by hbm2java
 */
public class UserStock implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserStockId id;
	private Stock stock;
	private User user;
	private Double priceValueThreshold;
	private Double privePercentageThreshold;

	public UserStock() {
	}

	public UserStock(UserStockId id, Stock stock, User user) {
		this.id = id;
		this.stock = stock;
		this.user = user;
	}

	public UserStock(UserStockId id, Stock stock, User user, Double priceValueThreshold,
	        Double privePercentageThreshold) {
		this.id = id;
		this.stock = stock;
		this.user = user;
		this.priceValueThreshold = priceValueThreshold;
		this.privePercentageThreshold = privePercentageThreshold;
	}

	public UserStockId getId() {
		return this.id;
	}

	public void setId(UserStockId id) {
		this.id = id;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPriceValueThreshold() {
		return this.priceValueThreshold;
	}

	public void setPriceValueThreshold(Double priceValueThreshold) {
		this.priceValueThreshold = priceValueThreshold;
	}

	public Double getPrivePercentageThreshold() {
		return this.privePercentageThreshold;
	}

	public void setPrivePercentageThreshold(Double privePercentageThreshold) {
		this.privePercentageThreshold = privePercentageThreshold;
	}

}