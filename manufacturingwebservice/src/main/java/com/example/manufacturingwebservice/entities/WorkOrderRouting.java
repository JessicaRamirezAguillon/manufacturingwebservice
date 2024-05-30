package com.example.manufacturingwebservice.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "WorkOrderRouting", schema = "Production")
@IdClass(WorkOrderRoutingId.class)
public class WorkOrderRouting {

    @Id
    @Column(name = "WorkOrderID", nullable = false)
    private Integer workOrderID;

    @Id
    @Column(name = "ProductID", nullable = false)
    private Integer productID;

    @Id
    @Column(name = "OperationSequence", nullable = false)
    private Short operationSequence;

    @Column(name = "LocationID", nullable = false)
    private Short locationID;

    @Column(name = "ScheduledStartDate", nullable = false)
    private LocalDateTime scheduledStartDate;

    @Column(name = "ScheduledEndDate", nullable = false)
    private LocalDateTime scheduledEndDate;

    @Column(name = "ActualStartDate")
    private LocalDateTime actualStartDate;

    @Column(name = "ActualEndDate")
    private LocalDateTime actualEndDate;

    @Column(name = "ActualResourceHrs", precision = 9, scale = 4)
    private BigDecimal actualResourceHrs;

    @Column(name = "PlannedCost")
    private BigDecimal plannedCost;

    @Column(name = "ActualCost")
    private BigDecimal actualCost;

    @Column(name = "ModifiedDate", nullable = false)
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
