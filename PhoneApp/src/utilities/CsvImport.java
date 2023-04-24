package utilities;

import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class CsvImport {

    public CsvImport() {

    }

    public List<Phone> importSourceFileToList(File sourceFile) {
        List<Phone> supportedDeviceList = new ArrayList<>();
        try(Scanner sourceFileScanner = new Scanner(sourceFile)) {
            while(sourceFileScanner.hasNextLine()) {
                String sourceFileLine = sourceFileScanner.nextLine();
                String[] sourceFileStringToArray = sourceFileLine.split(",");
                String phoneType = sourceFileStringToArray[0];
                if(phoneType.equalsIgnoreCase("iphone")) {
                    supportedDeviceList.add(new iPhone(sourceFileStringToArray[0].toUpperCase(), sourceFileStringToArray[1].toUpperCase(),
                            sourceFileStringToArray[2].toUpperCase(), sourceFileStringToArray[3].toUpperCase(), sourceFileStringToArray[4].toUpperCase(),
                            new BigDecimal(sourceFileStringToArray[5]), new BigDecimal(sourceFileStringToArray[6]),
                            new BigDecimal(sourceFileStringToArray[7]), new BigDecimal(sourceFileStringToArray[8])));
                } // else if(phoneType.equalsIgnoreCase("samsung galaxy")) {
//                    supportedDeviceList.add(new SamsungGalaxy(sourceFileStringToArray[0], sourceFileStringToArray[1], sourceFileStringToArray[2], sourceFileStringToArray[3],
//                    sourceFileStringToArray[4], new BigDecimal(sourceFileStringToArray[5])));
//                } else if(phoneType.equalsIgnoreCase("google pixel")) {
//                    supportedDeviceList.add(new GooglePixel(sourceFileStringToArray[0], sourceFileStringToArray[1], sourceFileStringToArray[2], sourceFileStringToArray[3],
//                    sourceFileStringToArray[4], new BigDecimal(sourceFileStringToArray[5])));
//                } else if(phoneType.equalsIgnoreCase("lg g series")) {
//                    supportedDeviceList.add(new LGGSeries(sourceFileStringToArray[0], sourceFileStringToArray[1], sourceFileStringToArray[2], sourceFileStringToArray[3],
//                    sourceFileStringToArray[4], new BigDecimal(sourceFileStringToArray[5])));
//                } else if(phoneType.equalsIgnoreCase("lg stylo")) {
//                    supportedDeviceList.add(new LGStylo(sourceFileStringToArray[0], sourceFileStringToArray[1], sourceFileStringToArray[2], sourceFileStringToArray[3],
//                    sourceFileStringToArray[4], new BigDecimal(sourceFileStringToArray[5])));
//                } else if(phoneType.equalsIgnoreCase("oneplus")) {
//                    supportedDeviceList.add(new OnePlus(sourceFileStringToArray[0], sourceFileStringToArray[1], sourceFileStringToArray[2], sourceFileStringToArray[3],
//                    sourceFileStringToArray[4], new BigDecimal(sourceFileStringToArray[5])));
//                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Whoops, file not found during import.");
        }
        return supportedDeviceList;
    }

    public Map<String, String> importSourceFileToMap(File sourceFile) {
        // use a treemap to sort the keys by natural order
        Map<String, String> supportedDeviceMap = new TreeMap<>();
        try(Scanner sourceFileScanner = new Scanner(sourceFile)) {
            while(sourceFileScanner.hasNextLine()) {
                String sourceFileLine = sourceFileScanner.nextLine();
                String[] sourceFileStringToArray = sourceFileLine.split(",");
                supportedDeviceMap.put((sourceFileStringToArray[2].toUpperCase()), sourceFileStringToArray[1].toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Whoops, file not found during import.");
        }
        return supportedDeviceMap;
    }

}
