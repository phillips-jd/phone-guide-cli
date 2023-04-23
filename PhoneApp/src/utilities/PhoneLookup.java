package utilities;

import models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PhoneLookup {


    public PhoneLookup() {

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

    public static Phone createUserPhone(String deviceType) {
        Phone newUserPhone = null;
        if(deviceType.equalsIgnoreCase("iphone")) {
            newUserPhone = new iPhone();
        } else if(deviceType.equalsIgnoreCase("samsung galaxy")) {
            newUserPhone = new SamsungGalaxy();
        } else if(deviceType.equalsIgnoreCase("google pixel")) {
            newUserPhone = new GooglePixel();
        } else if(deviceType.equalsIgnoreCase("oneplus")) {
            newUserPhone = new OnePlus();
        } else if(deviceType.equalsIgnoreCase("lg g series")) {
            newUserPhone = new LGGSeries();
        } else if(deviceType.equalsIgnoreCase("lg stylo")) {
            newUserPhone = new LGStylo();
        }
        return newUserPhone;
    }

    public static void setDeviceTypeAndBrand(String deviceType, Phone userPhone) {
        if(deviceType.equalsIgnoreCase("iphone")) {
            userPhone.setDeviceType("iPhone");
            userPhone.setBrand("Apple");
        } else if(deviceType.equalsIgnoreCase("samsung")) {
            userPhone.setDeviceType("Samsung Galaxy");
            userPhone.setBrand("Samsung");
        } else if(deviceType.equalsIgnoreCase("google")) {
            userPhone.setDeviceType("Google Pixel");
            userPhone.setBrand("Google");
        } else if(deviceType.equalsIgnoreCase("oneplus")) {
            userPhone.setDeviceType("OnePlus");
            userPhone.setBrand("OnePlus");
        } else if(deviceType.equalsIgnoreCase("lg g series")) {
            userPhone.setDeviceType("LG G Series");
            userPhone.setBrand("LG");
        } else if(deviceType.equalsIgnoreCase("lg stylo")) {
            userPhone.setDeviceType("LG Stylo");
            userPhone.setBrand("LG");
        }
    }


}
