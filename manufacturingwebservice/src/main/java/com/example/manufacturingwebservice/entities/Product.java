package com.example.manufacturingwebservice.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product", schema = "Production")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID") 
    private int productId;

    @Column(name = "Name", nullable = false, length = 50) 
    private String name;

    @Column(name = "ProductNumber", nullable = false, length = 25) 
    private String productNumber;

    @Column(name = "MakeFlag", nullable = false) 
    private boolean makeFlag;

    @Column(name = "FinishedGoodsFlag", nullable = false) 
    private boolean finishedGoodsFlag;

    @Column(name = "Color", length = 15) 
    private String color;

    @Column(name = "SafetyStockLevel", nullable = false) 
    private short safetyStockLevel;

    @Column(name = "ReorderPoint", nullable = false) 
    private int reorderPoint;

    @Column(name = "StandardCost", nullable = false) 
    private BigDecimal standardCost;

    @Column(name = "ListPrice", nullable = false) 
    private BigDecimal listPrice;

    @Column(name = "Size", length = 5) 
    private String size;

    @Column(name = "SizeUnitMeasureCode", length = 3) 
    private String sizeUnitMeasureCode;

    @Column(name = "WeightUnitMeasureCode", length = 3) 
    private String weightUnitMeasureCode;

    @Column(name = "Weight", precision = 8, scale = 2) 
    private BigDecimal weight;

    @Column(name = "DaysToManufacture", nullable = false) 
    private int daysToManufacture;

    @Column(name = "ProductLine", length = 2) 
    private String productLine;

    @Column(name = "Class", length = 2) 
    private String clazz;

    @Column(name = "Style", length = 2) 
    private String style;

    @Column(name = "ProductSubcategoryID") 
    private Integer productSubcategoryId;

    @Column(name = "ProductModelID") 
    private Integer productModelId;

    @Column(name = "SellStartDate", nullable = false) 
    private LocalDateTime sellStartDate;

    @Column(name = "SellEndDate") 
    private LocalDateTime sellEndDate;

    @Column(name = "DiscontinuedDate") 
    private LocalDateTime discontinuedDate;

    @Column(name = "rowguid", nullable = false, columnDefinition = "uniqueidentifier") 
    private UUID rowguid;

    @Column(name = "ModifiedDate", nullable = false) 
    private LocalDateTime modifiedDate;
    
    @OneToMany(mappedBy = "productID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TransactionHistory> transactionHistory;

    @OneToMany(mappedBy = "productID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkOrder> workOrder;

    // Constructors, getters, and setters

    public Product() {}

    public Product(int productId, String name, String productNumber, boolean makeFlag, boolean finishedGoodsFlag, String color, short safetyStockLevel, int reorderPoint, BigDecimal standardCost, BigDecimal listPrice, String size, String sizeUnitMeasureCode, String weightUnitMeasureCode, BigDecimal weight, int daysToManufacture, String productLine, String clazz, String style, Integer productSubcategoryId, Integer productModelId, LocalDateTime sellStartDate, LocalDateTime sellEndDate, LocalDateTime discontinuedDate, UUID rowguid, LocalDateTime modifiedDate) {
        this.productId = productId;
        this.name = name;
        this.productNumber = productNumber;
        this.makeFlag = makeFlag;
        this.finishedGoodsFlag = finishedGoodsFlag;
        this.color = color;
        this.safetyStockLevel = safetyStockLevel;
        this.reorderPoint = reorderPoint;
        this.standardCost = standardCost;
        this.listPrice = listPrice;
        this.size = size;
        this.sizeUnitMeasureCode = sizeUnitMeasureCode;
        this.weightUnitMeasureCode = weightUnitMeasureCode;
        this.weight = weight;
        this.daysToManufacture = daysToManufacture;
        this.productLine = productLine;
        this.clazz = clazz;
        this.style = style;
        this.productSubcategoryId = productSubcategoryId;
        this.productModelId = productModelId;
        this.sellStartDate = sellStartDate;
        this.sellEndDate = sellEndDate;
        this.discontinuedDate = discontinuedDate;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public boolean isMakeFlag() {
        return makeFlag;
    }

    public void setMakeFlag(boolean makeFlag) {
        this.makeFlag = makeFlag;
    }

    public boolean isFinishedGoodsFlag() {
        return finishedGoodsFlag;
    }

    public void setFinishedGoodsFlag(boolean finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public void setSafetyStockLevel(short safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeUnitMeasureCode() {
        return sizeUnitMeasureCode;
    }

    public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) {
        this.sizeUnitMeasureCode = sizeUnitMeasureCode;
    }

    public String getWeightUnitMeasureCode() {
        return weightUnitMeasureCode;
    }

    public void setWeightUnitMeasureCode(String weightUnitMeasureCode) {
        this.weightUnitMeasureCode = weightUnitMeasureCode;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getDaysToManufacture() {
        return daysToManufacture;
    }

    public void setDaysToManufacture(int daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getProductSubcategoryId() {
        return productSubcategoryId;
    }

    public void setProductSubcategoryId(Integer productSubcategoryId) {
        this.productSubcategoryId = productSubcategoryId;
    }

    public Integer getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(Integer productModelId) {
        this.productModelId = productModelId;
    }

    public LocalDateTime getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(LocalDateTime sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public LocalDateTime getSellEndDate() {
        return sellEndDate;
    }

    public void setSellEndDate(LocalDateTime sellEndDate) {
        this.sellEndDate = sellEndDate;
    }

    public LocalDateTime getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(LocalDateTime discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public UUID getRowguid() {
        return rowguid;
    }

    public void setRowguid(UUID rowguid) {
        this.rowguid = rowguid;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

