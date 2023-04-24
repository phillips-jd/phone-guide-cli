package models;

import interfaces.Repairable;

import java.math.BigDecimal;

public abstract class Phone implements Repairable {

    // Properties
    private String deviceType;
    private String brand;
    private String model;
    private String wirelessCarrier;
    private String condition;
    private boolean isBroken = false;
    private boolean isRepairable = true;
    private BigDecimal preownedMarketValue;
    private BigDecimal repairCost;



    // Constructors
    public Phone () {

    }
    public Phone (String deviceType, String brand, String model) {
        this.deviceType = deviceType;
        this.brand = brand;
        this.model = model;
        this.wirelessCarrier = "unlocked";
    }

    public Phone (String deviceType, String brand, String model, String wirelessCarrier,
                  String condition, BigDecimal preownedMarketValue) {
        this(deviceType, brand, model);
        this.wirelessCarrier = wirelessCarrier;
        this.condition = condition;
        this.preownedMarketValue = preownedMarketValue;
    }


    // Getters and Setters

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

    public String getWirelessCarrier() {
        return wirelessCarrier;
    }

    public void setWirelessCarrier(String wirelessCarrier) {
        this.wirelessCarrier = wirelessCarrier;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getPreownedMarketValue() {
        return preownedMarketValue;
    }

    public void setPreownedMarketValue(BigDecimal preownedMarketValue) {
        this.preownedMarketValue = preownedMarketValue;
    }

    // Methods
    @Override
    public String toString() {
        String phoneString =
                "\n------------------------" +
                "\nDevice Details" +
                "\n------------------------" +
                "\nBrand: " + this.brand +
                "\nModel: " + this.model +
                "\nWireless Carrier: " + this.wirelessCarrier +
                "\nCondition: " + this.condition;
        return phoneString;
    }


}
