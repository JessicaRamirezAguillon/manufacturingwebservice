package com.example.manufacturingwebservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LocationDTO {
    private Short locationID;
    private String name;
    private BigDecimal costRate;
    private BigDecimal availability;
    private LocalDateTime modifiedDate;

    // Getters and Setters

    public Short getLocationID() {
        return locationID;
    }

    public void setLocationID(Short locationID) {
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCostRate() {
        return costRate;
    }

    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    public BigDecimal getAvailability() {
        return availability;
    }

    public void setAvailability(BigDecimal availability) {
        this.availability = availability;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
