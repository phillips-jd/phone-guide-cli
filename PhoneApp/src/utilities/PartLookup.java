package utilities;

import models.phone.Phone;
import models.phonepart.PhonePart;

import java.util.List;

public class PartLookup {

    public PartLookup() {

    }

    public static PhonePart checkPartListForMatch(List<PhonePart> supportedPartList, PhonePart userPart) {
        PhonePart matchingPart = null;
        for(PhonePart currentPart : supportedPartList) {
            if (currentPart.getDeviceType().equalsIgnoreCase(userPart.getDeviceType()) &&
                    currentPart.getBrand().equalsIgnoreCase(userPart.getBrand()) &&
                    currentPart.getModel().equalsIgnoreCase(userPart.getModel()) &&
                    currentPart.getPartName().equalsIgnoreCase(userPart.getPartName())) {
                matchingPart = currentPart;
            }
        }
        return matchingPart;
    }

}
