package com.example.manufacturingwebservice.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ScrapReason", schema = "Production")
public class ScrapReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScrapReasonID", nullable = false)
    private Short scrapReasonID;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "scrapReasonID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkOrder> workOrder;

    // Getters and Setters
    public Short getScrapReasonID() {
        return scrapReasonID;
    }

    public void setScrapReasonID(Short scrapReasonID) {
        this.scrapReasonID = scrapReasonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
