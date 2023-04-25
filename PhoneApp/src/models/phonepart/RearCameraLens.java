package models.phonepart;

import java.math.BigDecimal;

public class RearCameraLens extends PhonePart {

    public RearCameraLens() {
        super();
    }

    public RearCameraLens(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        super(deviceType, brand, model, partName, partCost);
    }

}
