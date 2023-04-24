package application;

import models.Phone;
import models.iPhone;
import ui.UserInput;
import ui.UserOutput;
import utilities.CsvImport;
import utilities.PhoneCreator;
import utilities.PhoneLookup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneGuide {

    private boolean exitLoop = false;
    String userInput = "";

    public void run() {

        CsvImport sourceFileImport = new CsvImport();
        String filePath = "phone.csv";
        File sourceFile = new File(filePath);
        List<Phone> supportedDeviceList = sourceFileImport.importSourceFileToList(sourceFile);
        Map<String, String> supportedDeviceMap = sourceFileImport.importSourceFileToMap(sourceFile);
        List<String> supportedDeviceTypeList = createSupportedDeviceTypeList(supportedDeviceList);

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
                                                            UserOutput.displayDeviceMarketValuePage();
                                                            System.out.println(userDevice);
                                                            System.out.println();
                                                            System.out.println("Market value: $" + PhoneLookup.getMarketValue(supportedDeviceList, userDevice));
                                                            System.out.println();
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
                // the section belows deals with the selling process
            } else if(userInput.equals("2")) {

                // the section belows deals with the repair quote process
            } else if(userInput.equals("3")) {

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
        return supportedDeviceTypeList;
    }


}

