package com.qa.ims.persistence.domain;

public class Order {

	private Long orderID;
	private Long price;
	private Long quantity;
	private String date;
	private Long fkID;
	private Long fkItemID;

	public Order(Long orderID, Long price, Long quantity, String date, Long fkID, Long fkItemID) {
		super();
		this.orderID = orderID;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
		this.fkID = fkID;
		this.fkItemID = fkItemID;

	}

	public Order(Long price, Long quantity, Long fkID, String date, Long fkItemID) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.date = date;
		this.fkID = fkID;
		this.fkItemID = fkItemID;
	}

	public Order(Long price, Long quantity, String date) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.date = date;
	}

	public Order(Long orderID, Long price, Long quantity, String date) {
		super();
		this.orderID = orderID;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
	}
	
	
//	public Order(long orderID2, long price2, long quantity2, long date2) {
//	
//	}//unsure
	//getters setter, to string and hash.
	
	
	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		//java.sql.Date date = new java.sql.Date(date.getTime());//unsure
		return date;
	}

	public void setDate(String date) { 
		this.date = date;
	}

	public Long getFkID() {
		return fkID;
	}

	public void setFkID(Long fkID) {
		this.fkID = fkID;
	}

	public Long getFkItemID() {
		return fkItemID;
	}

	public void setFkItemID(Long fkItemID) {
		this.fkItemID = fkItemID;
			
	}
	
	

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", price=" + price + ", quantity=" + quantity + ", date=" + date
				+ ", fkID=" + fkID + ", fkItemID=" + fkItemID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((fkID == null) ? 0 : fkID.hashCode());
		result = prime * result + ((fkItemID == null) ? 0 : fkItemID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (fkID == null) {
			if (other.fkID != null)
				return false;
		} else if (!fkID.equals(other.fkID))
			return false;
		if (fkItemID == null) {
			if (other.fkItemID != null)
				return false;
		} else if (!fkItemID.equals(other.fkItemID))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
