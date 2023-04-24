package models;

import java.math.BigDecimal;

public class iPhone extends Phone {

    public iPhone() {
        super();
    }

    public iPhone(String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public iPhone(String deviceType, String brand, String model, String wirelessCarrier,
                   String condition, BigDecimal averagePreownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue);
    }

    public iPhone(String deviceType, String brand, String model, String wirelessCarrier,
                  String condition, BigDecimal averagePreownedMarketValue,
                  BigDecimal swappaMarketValue, BigDecimal ebayMarketValue, BigDecimal gazelleMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue, swappaMarketValue, ebayMarketValue, gazelleMarketValue);
    }
}
