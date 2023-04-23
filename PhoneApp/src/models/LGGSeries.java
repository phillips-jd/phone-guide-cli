package models;

import java.math.BigDecimal;

public class LGGSeries extends Phone{

    public LGGSeries () {
        super();
    }

    public LGGSeries (String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public LGGSeries (String deviceType, String brand, String model, String wirelessCarrier,
                   String condition, BigDecimal preownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, preownedMarketValue);
    }

}
