package models;

import java.math.BigDecimal;

public class LGStylo extends Phone{

    public LGStylo () {
        super();
    }

    public LGStylo (String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public LGStylo (String deviceType, String brand, String model, String wirelessCarrier,
                      String condition, BigDecimal preownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, preownedMarketValue);
    }

}
