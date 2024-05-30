package com.example.manufacturingwebservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WorkOrderRoutingDTO {
    private Integer workOrderID;
    private Integer productID;
    private Short operationSequence;
    private Short locationID;
    private LocalDateTime scheduledStartDate;
    private LocalDateTime scheduledEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private BigDecimal actualResourceHrs;
    private BigDecimal plannedCost;
    private BigDecimal actualCost;
    private LocalDateTime modifiedDate;

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

    public Short getLocationID() {
        return locationID;
    }

    public void setLocationID(Short locationID) {
        this.locationID = locationID;
    }

    public LocalDateTime getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(LocalDateTime scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public LocalDateTime getScheduledEndDate() {
        return scheduledEndDate;
    }

    public void setScheduledEndDate(LocalDateTime scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    public LocalDateTime getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(LocalDateTime actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public LocalDateTime getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(LocalDateTime actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public BigDecimal getActualResourceHrs() {
        return actualResourceHrs;
    }

    public void setActualResourceHrs(BigDecimal actualResourceHrs) {
        this.actualResourceHrs = actualResourceHrs;
    }

    public BigDecimal getPlannedCost() {
        return plannedCost;
    }

    public void setPlannedCost(BigDecimal plannedCost) {
        this.plannedCost = plannedCost;
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
