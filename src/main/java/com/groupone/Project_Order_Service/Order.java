package com.groupone.Project_Order_Service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString 
public class Order {
	@Id
    private String orderID;
    private String userId;
    private String stockSymbol;
    private int qty;
    private double totalPrice;
    private String status;
    private String orderType;

    // Constructors
    public Order() {}

    public Order(String orderID, String userId, String stockSymbol, int qty, double totalPrice, String status, String orderType) {
        this.orderID = orderID;
        this.userId = userId;
        this.stockSymbol = stockSymbol;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderType = orderType;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", userId='" + userId + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", qty=" + qty +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
