package models.phone;

import java.math.BigDecimal;

public class LGGSeries extends Phone {

    public LGGSeries() {
        super();
    }

    public LGGSeries(String deviceType, String brand, String model) {
        super(deviceType, brand, model);
    }

    public LGGSeries(String deviceType, String brand, String model, String wirelessCarrier,
                   String condition, BigDecimal averagePreownedMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue);
    }

    public LGGSeries(String deviceType, String brand, String model, String wirelessCarrier,
                   String condition, BigDecimal averagePreownedMarketValue,
                   BigDecimal swappaMarketValue, BigDecimal ebayMarketValue, BigDecimal gazelleMarketValue) {
        super(deviceType, brand, model, wirelessCarrier, condition, averagePreownedMarketValue, swappaMarketValue, ebayMarketValue, gazelleMarketValue);
    }

}
