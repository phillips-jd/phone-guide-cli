package application;

import models.phone.Phone;
import models.phonepart.PhonePart;
import ui.UserInput;
import ui.UserOutput;
import utilities.CsvImport;
import utilities.PartCreator;
import utilities.PartLookup;
import utilities.PhoneCreator;

import java.io.File;
import java.util.*;

public class PhoneGuide {

    private boolean exitLoop = false;
    String userInput = "";

    public void run() {

        String filePathForDevices = "phone.csv";
        File deviceSourceFile = new File(filePathForDevices);
        List<Phone> supportedDeviceList = CsvImport.importDeviceSourceFileToList(deviceSourceFile);
        Map<String, String> supportedDeviceMap = CsvImport.importDeviceSourceFileToMap(deviceSourceFile);
        List<String> supportedDeviceTypeList = createSupportedDeviceTypeList(supportedDeviceList);

        String filePathForParts = "repair.csv";
        File partSourceFile = new File(filePathForParts);
        List<PhonePart> supportedPartList = CsvImport.importPartSourceFileToList(partSourceFile);
        List<String> supportedRepairList = createSupportedRepairList(supportedPartList);

        while(!exitLoop) {
            UserOutput.displayHomePage();
            userInput = UserInput.getUserInput();
            if(userInput.equalsIgnoreCase("4")) {
                exitLoop = true;
                // the section belows deals with the selling process
            } else if(userInput.equals("1")) {
                while(!exitLoop) {
                    UserOutput.displayDeviceTypeSelectionPage();
                    userInput = UserInput.getUserInput();
                    if(userInput.equalsIgnoreCase("type list") || userInput.equalsIgnoreCase("list")) {
                        UserOutput.displaySupportedDeviceType(supportedDeviceList);
                    } else if(userInput.equalsIgnoreCase("exit")) {
                        exitLoop = true;
                    } else if(supportedDeviceTypeList.contains(userInput.toUpperCase())) {
                        Phone userDevice = PhoneCreator.createUserPhone(userInput);
                        PhoneCreator.setDeviceTypeAndBrand(userInput, userDevice);
                        while (!exitLoop) {
                            UserOutput.displayDeviceModelSelectionPage();
                            userInput = UserInput.getUserInput();
                            if (userInput.equalsIgnoreCase("device list") || userInput.equalsIgnoreCase("list")) {
                                UserOutput.displaySupportedDeviceMap(supportedDeviceMap);
                            } else if(userInput.equalsIgnoreCase("exit")) {
                                exitLoop = true;
                            } else if(supportedDeviceMap.containsKey(userInput.toUpperCase())) {
                                PhoneCreator.setDeviceModel(supportedDeviceMap, userInput, userDevice);
                                while(!exitLoop) {
                                    UserOutput.displayFunctionCheckPageIfSelling();
                                    userInput = UserInput.getUserInput();
                                    if(userInput.equals("1")) {
                                        exitLoop = true;
                                    } else if(userInput.equals("2")) {
                                        while(!exitLoop) {
                                            UserOutput.displayDeviceConditionPageForSelling();
                                            userInput = UserInput.getUserInput();
                                            if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) {
                                                PhoneCreator.setDeviceCondition(userInput, userDevice);
                                                while(!exitLoop) {
                                                    UserOutput.displayDeviceCarrierSelectionPage();
                                                    userInput = UserInput.getUserInput();
                                                    if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) {
                                                        PhoneCreator.setDeviceWirelessCarrier(userInput, userDevice);
                                                        while(!exitLoop) {
                                                            UserOutput.displayDeviceMarketValuePage(supportedDeviceList, userDevice);
                                                            exitLoop = true;
                                                        }
                                                    } else if(userInput.equals("5")) {
                                                        exitLoop = true;
                                                    } else {
                                                        UserOutput.displayInvalidInputMessage("Enter 1, 2, 3, or 4 for device carrier" +
                                                                                             "\nEnter 5 to exit to the home page");
                                                    }
                                                }
                                            } else if(userInput.equals("4")) {
                                                exitLoop = true;
                                            } else {
                                                UserOutput.displayInvalidInputMessage("Enter 1, 2, or 3 for device condition" +
                                                                                     "\nEnter 4 to exit to the home page");
                                            }
                                        }
                                    } else {
                                        UserOutput.displayInvalidInputMessage("Enter 1 to go back to the home page" +
                                                                             "\nEnter 2 to proceed to the next step");
                                    }
                                }
                            } else {
                                UserOutput.displayInvalidInputMessage("Enter \"device list\" or \"list\" for the supported device model list" +
                                                                     "\nEnter the device model you want to select" +
                                                                     "\nEnter \"exit\" to go back to the home page");
                            }
                        }
                    } else {
                        UserOutput.displayInvalidInputMessage("Enter \"type list\" or \"list\" for the supported device type list" +
                                                             "\nEnter the device type you want to select" +
                                                             "\nEnter \"exit\" to go back to the home page");
                    }
                }
                exitLoop = false;
                // the section belows deals with the buying process
                // scope change: create a list of phones for comparison?
            } else if(userInput.equals("2")) {

                // the section belows deals with the repair quote process
            } else if(userInput.equals("3")) {
                while (!exitLoop) {
                    UserOutput.displayRepairSelectionPage();
                    userInput = UserInput.getUserInput();
                    if (userInput.equalsIgnoreCase("repair list") || userInput.equalsIgnoreCase("list")) {
                        UserOutput.displaySupportedRepairTypes(supportedRepairList);
                    } else if (userInput.equalsIgnoreCase("exit")) {
                        exitLoop = true;
                    } else if (supportedRepairList.contains(userInput.toUpperCase())) {
                        PhonePart userPart = PartCreator.createUserPartForRepairQuote(userInput);
                        while (!exitLoop) {
                            UserOutput.displayDeviceTypeSelectionPage();
                            userInput = UserInput.getUserInput();
                            if (userInput.equalsIgnoreCase("type list") || userInput.equalsIgnoreCase("list")) {
                                UserOutput.displaySupportedDeviceType(supportedDeviceList);
                            } else if (userInput.equalsIgnoreCase("exit")) {
                                exitLoop = true;
                            } else if (supportedDeviceTypeList.contains(userInput.toUpperCase())) {
                                PartCreator.setPartDeviceTypeAndBrand(userInput, userPart);
                                while (!exitLoop) {
                                    UserOutput.displayDeviceModelSelectionPage();
                                    userInput = UserInput.getUserInput();
                                    if (userInput.equalsIgnoreCase("device list") || userInput.equalsIgnoreCase("list")) {
                                        UserOutput.displaySupportedDeviceMap(supportedDeviceMap);
                                    } else if (userInput.equalsIgnoreCase("exit")) {
                                        exitLoop = true;
                                    } else if (supportedDeviceMap.containsKey(userInput.toUpperCase())) {
                                        PartCreator.setPartModel(supportedDeviceMap, userInput, userPart);
                                        while (!exitLoop) {
                                            UserOutput.displayRepairQuote(PartLookup.checkPartListForMatch(supportedPartList, userPart));
                                            exitLoop = true;
                                        }
                                    } else {
                                        UserOutput.displayInvalidInputMessage("Enter \"device list\" or \"list\" for the supported device model list" +
                                                "\nEnter the device model you want to select" +
                                                "\nEnter \"exit\" to go back to the home page");
                                    }
                                }
                            } else {
                                UserOutput.displayInvalidInputMessage("Enter \"type list\" or \"list\" for the supported device type list" +
                                        "\nEnter the device type you want to select" +
                                        "\nEnter \"exit\" to go back to the home page");
                            }
                        }
                    } else {
                        UserOutput.displayInvalidInputMessage("Enter \"repair list\" or \"list\" for the supported repair list" +
                                "\nEnter the repair you want to select" +
                                "\nEnter \"exit\" to go back to the home page");
                    }
                }
                exitLoop = false;
            } else {
                UserOutput.displayInvalidInputMessage("Enter 1 to check the market value of your device" +
                                                     "\nEnter 2 to check the market value of a device you would like to purchase" +
                                                     "\nEnter 3 to receive a repair quote" +
                                                     "\nEnter 4 to exit the program");
            }
        }
    }

    // purpose of this method is to create a list of device types without duplicates
    // this list is used to compare the user's input on the "displayDeviceTypeSelectionPage"
            // if the list contains the user's input, they can proceed to the next step
    // supportedDeviceList has hundreds of the same device type due to different models
    // Ex: Device Type: iPhone includes iPhone 11, iPhone 12, etc.
    public static List<String> createSupportedDeviceTypeList(List<Phone> supportedDeviceList) {
        List<String> supportedDeviceTypeList = new ArrayList<>();
        for(Phone currentPhone : supportedDeviceList) {
            if(supportedDeviceTypeList.contains(currentPhone.getDeviceType())) {
                continue;
            } else {
                supportedDeviceTypeList.add(currentPhone.getDeviceType());
            }
        }
        Collections.sort(supportedDeviceTypeList);
        return supportedDeviceTypeList;
    }

    // purpose of this method is to create a list of supported repairs without duplicates
    // this list is used to compare the user's input on the "displayRepairTypeSelectionPage"
    // if the list contains the user's input, they can proceed to the next step
    // supportedPartList has hundreds of the same part type due to different models
    // Ex: PhonePart: Screen includes iPhone 11 screens, iPhone 12 screens, etc.
    public static List<String> createSupportedRepairList(List<PhonePart> supportedPartList) {
        List<String> supportedRepairList = new ArrayList<>();
        for(PhonePart currentPart : supportedPartList) {
            if(supportedRepairList.contains(currentPart.getPartName())) {
                continue;
            } else {
                supportedRepairList.add(currentPart.getPartName());
            }
        }
        Collections.sort(supportedRepairList);
        return supportedRepairList;
    }


}

