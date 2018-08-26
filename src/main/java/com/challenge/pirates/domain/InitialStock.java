package com.challenge.pirates.domain;

import java.util.List;

public class InitialStock extends JsonResult{

	private List<Stock> stockList;

	public InitialStock() {
		super();
	}

	public InitialStock(List<Stock> events) {
		super();
		this.stockList = events;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockList == null) ? 0 : stockList.hashCode());
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
		InitialStock other = (InitialStock) obj;
		if (stockList == null) {
			if (other.stockList != null)
				return false;
		} else if (!stockList.equals(other.stockList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "listEvents [events=" + stockList + "]";
	}
	
	
	
	
}
