package models.phonepart;

import java.math.BigDecimal;

public class Battery extends PhonePart {

    public Battery() {
        super();
    }

    public Battery(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        super(deviceType, brand, model, partName, partCost);
    }

}
