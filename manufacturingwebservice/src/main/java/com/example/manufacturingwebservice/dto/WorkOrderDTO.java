package com.example.manufacturingwebservice.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class WorkOrderDTO {
    private Integer workOrderID;
    private Integer productID;
    private Integer orderQty;
    private Integer stockedQty;
    private Short scrappedQty;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime dueDate;
    private Short scrapReasonID;
    private LocalDateTime modifiedDate;
    private Set<WorkOrderRoutingDTO> workOrderRoutings;

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

    public Set<WorkOrderRoutingDTO> getWorkOrderRoutings() {
        return workOrderRoutings;
    }

    public void setWorkOrderRoutings(Set<WorkOrderRoutingDTO> workOrderRoutings) {
        this.workOrderRoutings = workOrderRoutings;
    }
}
