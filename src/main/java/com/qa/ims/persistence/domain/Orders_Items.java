package com.qa.ims.persistence.domain;


public class Orders_Items  {
	
	
	private Long saleID;
	private Long fkOrderID;
	private Long fkItemID;

	
	public Orders_Items(Long saleID, Long fkOrderID, Long fkItemID) {
		super();
		this.saleID = saleID;
		this.fkOrderID = fkOrderID;
		this.fkItemID = fkItemID;
	}
	public Long getSaleID() {
		return saleID;
	}
	public void setSaleID(Long saleID) {
		this.saleID = saleID;
	}
	public Long getFkOrderID() {
		return fkOrderID;
	}
	public void setFkOrderID(Long fkOrderID) {
		this.fkOrderID = fkOrderID;
	}
	public Long getFkItemID() {
		return fkItemID;
	}
	public void setFkItemID(Long fkItemID) {
		this.fkItemID = fkItemID;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Orders_Items [saleID=" + saleID + ", fkOrderID=" + fkOrderID + ", fkItemID=" + fkItemID + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fkItemID == null) ? 0 : fkItemID.hashCode());
		result = prime * result + ((fkOrderID == null) ? 0 : fkOrderID.hashCode());
		result = prime * result + ((saleID == null) ? 0 : saleID.hashCode());
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
		Orders_Items other = (Orders_Items) obj;
		if (fkItemID == null) {
			if (other.fkItemID != null)
				return false;
		} else if (!fkItemID.equals(other.fkItemID))
			return false;
		if (fkOrderID == null) {
			if (other.fkOrderID != null)
				return false;
		} else if (!fkOrderID.equals(other.fkOrderID))
			return false;
		if (saleID == null) {
			if (other.saleID != null)
				return false;
		} else if (!saleID.equals(other.saleID))
			return false;
		return true;
	}
	
	
	

}

