package models.phonepart;

import java.math.BigDecimal;

public class Speaker extends PhonePart {

    public Speaker() {
        super();
    }
    public Speaker(String deviceType, String brand, String model,
                     String partName, BigDecimal partCost) {
        super(deviceType, brand, model, partName, partCost);
    }

}
