package models.phonepart;

import java.math.BigDecimal;

public class Screen extends PhonePart {

    public Screen() {
        super();
    }

    public Screen(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        super(deviceType, brand, model, partName, partCost);
    }

}
