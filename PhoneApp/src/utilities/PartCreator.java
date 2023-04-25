package utilities;

import models.phone.*;
import models.phonepart.*;

import java.util.Map;

public class PartCreator {

    public PartCreator() {

    }

    public static PhonePart createUserPartForRepairQuote(String partName) {
        PhonePart newUserPart = null;
        if (partName.equalsIgnoreCase("screen")) {
            newUserPart = new Screen();
        } else if (partName.equalsIgnoreCase("battery")) {
            newUserPart = new Battery();
        } else if (partName.equalsIgnoreCase("charge port")) {
            newUserPart = new ChargePort();
        } else if (partName.equalsIgnoreCase("back glass")) {
            newUserPart = new BackGlass();
        } else if (partName.equalsIgnoreCase("rear camera lens")) {
            newUserPart = new RearCameraLens();
        } else if (partName.equalsIgnoreCase("speaker")) {
            newUserPart = new Speaker();
        }
        return newUserPart;
    }

    public static void setPartDeviceTypeAndBrand(String deviceType, PhonePart userPart) {
        if(deviceType.equalsIgnoreCase("iphone")) {
            userPart.setDeviceType("iPhone");
            userPart.setBrand("Apple");
        } else if(deviceType.equalsIgnoreCase("samsung")) {
            userPart.setDeviceType("Samsung Galaxy");
            userPart.setBrand("Samsung");
        } else if(deviceType.equalsIgnoreCase("google")) {
            userPart.setDeviceType("Google Pixel");
            userPart.setBrand("Google");
        } else if(deviceType.equalsIgnoreCase("oneplus")) {
            userPart.setDeviceType("OnePlus");
            userPart.setBrand("OnePlus");
        } else if(deviceType.equalsIgnoreCase("lg g series")) {
            userPart.setDeviceType("LG G Series");
            userPart.setBrand("LG");
        } else if(deviceType.equalsIgnoreCase("lg stylo")) {
            userPart.setDeviceType("LG Stylo");
            userPart.setBrand("LG");
        }
    }

    public static void setPartModel(Map<String, String> supportedDeviceMap, String userModel, PhonePart userPart) {
        if(supportedDeviceMap.containsKey(userModel.toUpperCase())) {
            userPart.setModel(userModel.toUpperCase());
        }
    }

}
