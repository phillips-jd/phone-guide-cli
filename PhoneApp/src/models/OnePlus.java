package models;

import java.math.BigDecimal;

public class OnePlus extends Phone{

    public OnePlus () {
        super();
    }

    public OnePlus (String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public OnePlus (String deviceType, String brand, String model, String wirelessCarrier,
                    String condition, BigDecimal preownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, preownedMarketValue);
    }

}
