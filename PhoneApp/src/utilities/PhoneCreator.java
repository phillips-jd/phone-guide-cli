package utilities;

import models.phone.*;

import java.util.Map;

public class PhoneCreator {

    public PhoneCreator() {

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

    public static void setDeviceModel(Map<String, String> supportedDeviceMap, String userModel, Phone userPhone) {
        if(supportedDeviceMap.containsKey(userModel.toUpperCase())) {
            userPhone.setModel(userModel.toUpperCase());
        }
    }

    public static void setDeviceCondition(String userCondition, Phone userPhone) {
        if(userCondition.equals("1")) {
            userPhone.setCondition("Fair");
        } else if(userCondition.equals("2")) {
            userPhone.setCondition("Good");
        } else if(userCondition.equals("3")) {
            userPhone.setCondition("Excellent");
        }
    }

    public static void setDeviceWirelessCarrier(String userWirelessCarrier, Phone userPhone) {
        if(userWirelessCarrier.equals("1")) {
            userPhone.setWirelessCarrier("Verizon");
        } else if(userWirelessCarrier.equals("2")) {
            userPhone.setWirelessCarrier("AT&T");
        } else if(userWirelessCarrier.equals("3")) {
            userPhone.setWirelessCarrier("T-Mobile");
        } else if(userWirelessCarrier.equals("4")) {
            userPhone.setWirelessCarrier("Unlocked");
        }
    }

}
