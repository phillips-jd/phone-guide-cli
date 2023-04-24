package utilities;

import models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PhoneLookup {


    public PhoneLookup() {

    }

    public static Phone checkDeviceListForMatch(List<Phone> phoneList, Phone userPhone) {
        Phone matchingDevice = null;
        for(Phone currentPhone : phoneList) {
            if (currentPhone.getDeviceType().equalsIgnoreCase(userPhone.getDeviceType()) &&
                    currentPhone.getBrand().equalsIgnoreCase(userPhone.getBrand()) &&
                    currentPhone.getModel().equalsIgnoreCase(userPhone.getModel()) &&
                    currentPhone.getWirelessCarrier().equalsIgnoreCase(userPhone.getWirelessCarrier()) &&
                    currentPhone.getCondition().equalsIgnoreCase(userPhone.getCondition())) {
                matchingDevice = currentPhone;
            }
        }
        return matchingDevice;
    }

    public static BigDecimal getMarketValue(List<Phone> phoneList, Phone userPhone) {
        BigDecimal marketValue = new BigDecimal("0");
        if(checkDeviceListForMatch(phoneList, userPhone) != null) {
            userPhone = checkDeviceListForMatch(phoneList, userPhone);
            marketValue = userPhone.getAveragePreownedMarketValue();
            marketValue = marketValue.setScale(2, RoundingMode.HALF_UP);
        }
        return marketValue;
    }

    public static BigDecimal getSwappaValue(List<Phone> phoneList, Phone userPhone) {
        BigDecimal swappaValue = new BigDecimal("0");
        if(checkDeviceListForMatch(phoneList, userPhone) != null) {
            userPhone = checkDeviceListForMatch(phoneList, userPhone);
            swappaValue = userPhone.getSwappaMarketValue();
            swappaValue = swappaValue.setScale(2, RoundingMode.HALF_UP);
        }
        return swappaValue;
    }

    public static BigDecimal getEbayValue(List<Phone> phoneList, Phone userPhone) {
        BigDecimal ebayValue = new BigDecimal("0");
        if(checkDeviceListForMatch(phoneList, userPhone) != null) {
            userPhone = checkDeviceListForMatch(phoneList, userPhone);
            ebayValue = userPhone.getEbayMarketValue();
            ebayValue = ebayValue.setScale(2, RoundingMode.HALF_UP);
        }
        return ebayValue;
    }

    public static BigDecimal getGazelleValue(List<Phone> phoneList, Phone userPhone) {
        BigDecimal gazelleValue = new BigDecimal("0");
        if(checkDeviceListForMatch(phoneList, userPhone) != null) {
            userPhone = checkDeviceListForMatch(phoneList, userPhone);
            gazelleValue = userPhone.getGazelleMarketValue();
            gazelleValue = gazelleValue.setScale(2, RoundingMode.HALF_UP);
        }
        return gazelleValue;
    }
}
