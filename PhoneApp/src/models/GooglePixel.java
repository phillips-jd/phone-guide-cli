package models;

import java.math.BigDecimal;

public class GooglePixel extends Phone{

    public GooglePixel () {
        super();
    }

    public GooglePixel (String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public GooglePixel (String deviceType, String brand, String model, String wirelessCarrier,
                   String condition, BigDecimal preownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, preownedMarketValue);
    }

}
