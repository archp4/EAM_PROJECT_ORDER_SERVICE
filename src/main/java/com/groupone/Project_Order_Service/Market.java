package com.groupone.Project_Order_Service;

import lombok.Data;

@Data
public class Market {
    private String marketID;
    private String stockSymbol;
    private double price;
    private int availableQty;
    private String listedExchangeName;
	public String getMarketID() {
		return marketID;
	}
	public void setMarketID(String marketID) {
		this.marketID = marketID;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	public String getListedExchangeName() {
		return listedExchangeName;
	}
	public void setListedExchangeName(String listedExchangeName) {
		this.listedExchangeName = listedExchangeName;
	}
    
    
}
