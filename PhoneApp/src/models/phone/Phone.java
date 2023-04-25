package models.phone;

import java.math.BigDecimal;

public abstract class Phone {

    // Properties
    private String deviceType;
    private String brand;
    private String model;
    private String wirelessCarrier;
    private String condition;
    private BigDecimal averagePreownedMarketValue;
    private BigDecimal swappaMarketValue;
    private BigDecimal ebayMarketValue;
    private BigDecimal gazelleMarketValue;



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
                  String condition, BigDecimal averagePreownedMarketValue) {
        this(deviceType, brand, model);
        this.wirelessCarrier = wirelessCarrier;
        this.condition = condition;
        this.averagePreownedMarketValue = averagePreownedMarketValue;
    }

    public Phone (String deviceType, String brand, String model, String wirelessCarrier,
                  String condition, BigDecimal averagePreownedMarketValue,
                  BigDecimal swappaMarketValue, BigDecimal ebayMarketValue, BigDecimal gazelleMarketValue) {
        this(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue);
        this.swappaMarketValue = swappaMarketValue;
        this.ebayMarketValue = ebayMarketValue;
        this.gazelleMarketValue = gazelleMarketValue;
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

    public BigDecimal getAveragePreownedMarketValue() {
        return averagePreownedMarketValue;
    }

    public void setAveragePreownedMarketValue(BigDecimal preownedMarketValue) {
        this.averagePreownedMarketValue = preownedMarketValue;
    }

    public BigDecimal getSwappaMarketValue() {
        return swappaMarketValue;
    }

    public void setSwappaMarketValue(BigDecimal swappaMarketValue) {
        this.swappaMarketValue = swappaMarketValue;
    }

    public BigDecimal getEbayMarketValue() {
        return ebayMarketValue;
    }

    public void setEbayMarketValue(BigDecimal ebayMarketValue) {
        this.ebayMarketValue = ebayMarketValue;
    }

    public BigDecimal getGazelleMarketValue() {
        return gazelleMarketValue;
    }

    public void setGazelleMarketValue(BigDecimal gazelleMarketValue) {
        this.gazelleMarketValue = gazelleMarketValue;
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
