package utilities;

import models.Phone;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PhoneLookUp {

    private List<Phone> phoneList;
    private Phone userPhone;

    public PhoneLookUp() {

    }

    public static BigDecimal getMarketValue(List<Phone> phoneList, Phone userPhone) {
        BigDecimal marketValue = new BigDecimal("0");
        for(Phone currentPhone : phoneList) {
            if(currentPhone.getDeviceType().equalsIgnoreCase(userPhone.getDeviceType()) &&
            currentPhone.getBrand().equalsIgnoreCase(userPhone.getBrand()) &&
            currentPhone.getModel().equalsIgnoreCase(userPhone.getModel()) &&
            currentPhone.getWirelessCarrier().equalsIgnoreCase(userPhone.getWirelessCarrier()) &&
            currentPhone.getCondition().equalsIgnoreCase(userPhone.getCondition())) {
                marketValue = currentPhone.getPreownedMarketValue();
                marketValue = marketValue.setScale(2, RoundingMode.HALF_UP);
            }
        }
        return marketValue;
    }


}
