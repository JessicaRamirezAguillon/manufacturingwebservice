package com.example.manufacturingwebservice.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "WorkOrder", schema = "Production")
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkOrderID", nullable = false)
    private Integer workOrderID;

    @Column(name = "ProductID", nullable = false)
    private Integer productID;

    @Column(name = "OrderQty", nullable = false)
    private Integer orderQty;

    @Column(name = "StockedQty", nullable = false, insertable = false, updatable = false)
    private Integer stockedQty;

    @Column(name = "ScrappedQty", nullable = false)
    private Short scrappedQty;

    @Column(name = "StartDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "DueDate", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "ScrapReasonID")
    private Short scrapReasonID;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "workOrderID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkOrderRouting> workOrderRouting;

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

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Integer getStockedQty() {
        return stockedQty;
    }

    public void setStockedQty(Integer stockedQty) {
        this.stockedQty = stockedQty;
    }

    public Short getScrappedQty() {
        return scrappedQty;
    }

    public void setScrappedQty(Short scrappedQty) {
        this.scrappedQty = scrappedQty;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Short getScrapReasonID() {
        return scrapReasonID;
    }

    public void setScrapReasonID(Short scrapReasonID) {
        this.scrapReasonID = scrapReasonID;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}