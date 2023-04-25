package models.phonepart;

import java.math.BigDecimal;

public class ChargePort extends PhonePart {

    public ChargePort() {
        super();
    }

    public ChargePort(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        super(deviceType, brand, model, partName, partCost);
    }

}
