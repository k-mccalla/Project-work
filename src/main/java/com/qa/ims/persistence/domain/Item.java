package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemID;
	private Double price;
	private String itemName;
	
	public Item(Long itemID, Double price, String itemName) {
		super();
		this.itemID = itemID;
		this.price = price;
		this.itemName = itemName;
	}

	
	public Item(Double price, String itemName) {
		super();
		this.price = price;
		this.itemName = itemName;
	}


	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", price=" + price + ", itemName=" + itemName + "]";
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
		Item other = (Item) obj;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return false;
	
	}
	


	
	


	




	

}
