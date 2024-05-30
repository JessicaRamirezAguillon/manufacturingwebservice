package com.example.manufacturingwebservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionHistoryDTO {
    private Integer transactionID;
    private Integer productID;
    private Integer referenceOrderID;
    private Integer referenceOrderLineID;
    private LocalDateTime transactionDate;
    private String transactionType;
    private Integer quantity;
    private BigDecimal actualCost;
    private LocalDateTime modifiedDate;

    // Getters and Setters
    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getReferenceOrderID() {
        return referenceOrderID;
    }

    public void setReferenceOrderID(Integer referenceOrderID) {
        this.referenceOrderID = referenceOrderID;
    }

    public Integer getReferenceOrderLineID() {
        return referenceOrderLineID;
    }

    public void setReferenceOrderLineID(Integer referenceOrderLineID) {
        this.referenceOrderLineID = referenceOrderLineID;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
