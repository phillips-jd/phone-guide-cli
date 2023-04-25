package utilities;

import models.phone.*;
import models.phonepart.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class CsvImport {

    public static List<Phone> importDeviceSourceFileToList(File sourceFile) {
        List<Phone> supportedDeviceList = new ArrayList<>();
        try (Scanner sourceFileScanner = new Scanner(sourceFile)) {
            while (sourceFileScanner.hasNextLine()) {
                String sourceFileLine = sourceFileScanner.nextLine();
                String[] sourceFileStringToArray = sourceFileLine.split(",");
                String phoneType = sourceFileStringToArray[0];
                if (phoneType.equalsIgnoreCase("iphone")) {
                    supportedDeviceList.add(new iPhone(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                } else if (phoneType.equalsIgnoreCase("samsung galaxy")) {
                    supportedDeviceList.add(new SamsungGalaxy(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                } else if (phoneType.equalsIgnoreCase("google pixel")) {
                    supportedDeviceList.add(new GooglePixel(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                } else if (phoneType.equalsIgnoreCase("lg g series")) {
                    supportedDeviceList.add(new LGGSeries(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                } else if (phoneType.equalsIgnoreCase("lg stylo")) {
                    supportedDeviceList.add(new LGStylo(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                } else if (phoneType.equalsIgnoreCase("oneplus")) {
                    supportedDeviceList.add(new OnePlus(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Whoops, file not found during import.");
        }
        return supportedDeviceList;
    }

    public static Map<String, String> importDeviceSourceFileToMap(File sourceFile) {
        // use a treemap to sort the keys by natural order
        Map<String, String> supportedDeviceMap = new TreeMap<>();
        try (Scanner sourceFileScanner = new Scanner(sourceFile)) {
            while (sourceFileScanner.hasNextLine()) {
                String sourceFileLine = sourceFileScanner.nextLine();
                String[] sourceFileStringToArray = sourceFileLine.split(",");
                supportedDeviceMap.put((sourceFileStringToArray[2].toUpperCase()), sourceFileStringToArray[1].toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Whoops, file not found during import.");
        }
        return supportedDeviceMap;
    }

    public static List<PhonePart> importPartSourceFileToList(File sourceFile) {
        List<PhonePart> supportedPartList = new ArrayList<>();
        try (Scanner sourceFileScanner = new Scanner(sourceFile)) {
            while (sourceFileScanner.hasNextLine()) {
                String sourceFileLine = sourceFileScanner.nextLine();
                String[] sourceFileStringToArray = sourceFileLine.split(",");
                String partName = sourceFileStringToArray[3];
                if (partName.equalsIgnoreCase("screen")) {
                    supportedPartList.add(new Screen(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[4])));
                } else if (partName.equalsIgnoreCase("battery")) {
                    supportedPartList.add(new Battery(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[4])));
                } else if (partName.equalsIgnoreCase("charge port")) {
                    supportedPartList.add(new ChargePort(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[4])));
                } else if (partName.equalsIgnoreCase("back glass")) {
                    supportedPartList.add(new BackGlass(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[4])));
                } else if (partName.equalsIgnoreCase("rear camera lens")) {
                    supportedPartList.add(new RearCameraLens(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[4])));
                } else if (partName.equalsIgnoreCase("speaker")) {
                    supportedPartList.add(new Speaker(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[4])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Whoops, file not found during import.");
        }
        return supportedPartList;
    }

}
