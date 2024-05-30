package com.example.manufacturingwebservice.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Location", schema = "Production")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false)
    private Short locationID;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "CostRate", nullable = false)
    private BigDecimal costRate;

    @Column(name = "Availability", nullable = false)
    private BigDecimal availability;

    @Column(name = "ModifiedDate", nullable = false)
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
