package models;

import java.math.BigDecimal;

public class iPhone extends Phone {

    public iPhone () {
        super();
    }

    public iPhone (String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public iPhone (String deviceType, String brand, String model, String wirelessCarrier,
                   String condition, BigDecimal preownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, preownedMarketValue);
    }
}
