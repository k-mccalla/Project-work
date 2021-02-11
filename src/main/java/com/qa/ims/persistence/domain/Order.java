package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long orderID;
	private Double price;
	private Long customerID;
	private List<Item> item;

	
 
	

	public Order(Long orderID, List<Item> item) {
		super();
		this.orderID = orderID;
		this.item = item;
	}




	public Order(Long orderID, Double price, Long customerID, List<Item> item) {
		super();
		this.orderID = orderID;
		this.price = price;
		this.customerID = customerID;
		this.item = item;
	}




	public Order(Double price, Long customerID) {
		super();
		this.price = price;
		this.customerID = customerID;
	} 




	public Order(Long customerID) {
		super();
		this.customerID = customerID;
	}





	
	
//	
//	public Order(Long orderID) {
//		super();
//		this.orderID = orderID;
//	}




	public Long getOrderID() {
		return orderID;
	}




	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}




	public Double getPrice() {
		return price;
	}




	public void setPrice(Double price) {
		this.price = price;
	}




	public Long getCustomerID() {
		return customerID;
	}




	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}


 

	public List<Item> getItem() {
		return item;
	}




	public void setItem(List<Item> item) {
		this.item = item;
	}




	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", price=" + price + ", customerID=" + customerID + ", item=" + item + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
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
		return false;
	}




}
//	}
//
//}
