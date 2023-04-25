package models.phonepart;

import java.math.BigDecimal;

public class BackGlass extends PhonePart {

    public BackGlass() {
        super();
    }

    public BackGlass(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        super(deviceType, brand, model, partName, partCost);
    }

}
