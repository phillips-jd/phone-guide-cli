package models;

import java.math.BigDecimal;

public class GooglePixel extends Phone{

    public GooglePixel() {
        super();
    }

    public GooglePixel(String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public GooglePixel(String deviceType, String brand, String model, String wirelessCarrier,
                  String condition, BigDecimal averagePreownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue);
    }

    public GooglePixel(String deviceType, String brand, String model, String wirelessCarrier,
                  String condition, BigDecimal averagePreownedMarketValue,
                  BigDecimal swappaMarketValue, BigDecimal ebayMarketValue, BigDecimal gazelleMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue, swappaMarketValue, ebayMarketValue, gazelleMarketValue);
    }

}
