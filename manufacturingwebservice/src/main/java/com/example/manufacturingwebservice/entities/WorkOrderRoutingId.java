package com.example.manufacturingwebservice.entities;

import java.io.Serializable;
import java.util.Objects;

public class WorkOrderRoutingId implements Serializable {
    private Integer workOrderID;
    private Integer productID;
    private Short operationSequence;

    // Default constructor
    public WorkOrderRoutingId() {
    }

    // Constructor
    public WorkOrderRoutingId(Integer workOrderID, Integer productID, Short operationSequence) {
        this.workOrderID = workOrderID;
        this.productID = productID;
        this.operationSequence = operationSequence;
    }

    // Getters and Setters
    public Integer getWorkOrderID() {
        return workOrderID;
    }

    public void setWorkOrderID(Integer workOrderID) {
        this.workOrderID = workOrderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Short getOperationSequence() {
        return operationSequence;
    }

    public void setOperationSequence(Short operationSequence) {
        this.operationSequence = operationSequence;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOrderRoutingId that = (WorkOrderRoutingId) o;
        return Objects.equals(workOrderID, that.workOrderID) && Objects.equals(productID, that.productID) && Objects.equals(operationSequence, that.operationSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workOrderID, productID, operationSequence);
    }
}
