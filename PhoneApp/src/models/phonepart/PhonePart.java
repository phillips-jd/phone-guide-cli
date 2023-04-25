package models.phonepart;

import utilities.PhoneCreator;

import java.math.BigDecimal;

public abstract class PhonePart {

    private String deviceType;
    private String brand;
    private String model;
    private String partName;
    private BigDecimal partCost;
    private boolean isBroken = false;
    private boolean isRepairable = true;

    public PhonePart() {

    }

    public PhonePart(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        this();
        this.deviceType = deviceType;
        this.brand = brand;
        this.model = model;
        this.partName = partName;
        this.partCost = partCost;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public BigDecimal getPartCost() {
        return partCost;
    }

    public void setPartCost(BigDecimal partCost) {
        this.partCost = partCost;
    }

    @Override
    public String toString() {
        String phonePartString =
                "\n------------------------" +
                "\nPart Details" +
                "\n------------------------" +
                "\nBrand: " + this.brand +
                "\nModel: " + this.model +
                "\nPart name: " + this.partName;
                // "\nPart cost: " + this.partCost;
        return phonePartString;
    }

}
