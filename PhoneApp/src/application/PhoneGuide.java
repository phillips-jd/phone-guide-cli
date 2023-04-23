package application;

import models.Phone;
import models.iPhone;
import ui.UserInput;
import ui.UserOutput;
import utilities.CsvImport;

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
        String supportedDeviceTypesString = "iphone";
        String userDeviceType;
        String userBrand;
        String userModel;
        String userCondition;
        String userWirelessCarrier;
        Phone userDevice;

        while(!exitLoop) {
            UserOutput.displayHomePage();
            userInput = UserInput.getUserInput();
            if(userInput.equalsIgnoreCase("4")) {
                exitLoop = true;
            } else if(userInput.equals("1")) {
                while(!exitLoop) {
                    UserOutput.displayDeviceTypeSelectionPage();
                    userInput = UserInput.getUserInput();
                    if(userInput.equalsIgnoreCase("type list") || userInput.equalsIgnoreCase("list")) {
                        UserOutput.displaySupportedDeviceType(supportedDeviceList);
                    } else if(userInput.equalsIgnoreCase("exit")) {
                        exitLoop = true;
                    } else if(supportedDeviceTypesString.contains(userInput.toLowerCase())) {
                        // set the device type based on input
                        // just doing iphone for now
                        if(userInput.equalsIgnoreCase("iphone")) {
                            userDeviceType = "iPhone";
                            userBrand = "Apple";
                        }
                        while (!exitLoop) {
                            UserOutput.displayDeviceModelSelectionPage();
                            userInput = UserInput.getUserInput();
                            if (userInput.equalsIgnoreCase("device list") || userInput.equalsIgnoreCase("list")) {
                                UserOutput.displaySupportedDeviceMap(supportedDeviceMap);
                            } else if(userInput.equalsIgnoreCase("exit")) {
                                exitLoop = true;
                                // ******************
                                // bug here
                                // ******************
                            } else if(supportedDeviceMap.containsKey(userInput.toUpperCase())) {
                                userModel = userInput;
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
                                                if(userInput.equals("1")) {
                                                    userCondition = "Fair";
                                                } else if(userInput.equals("2")) {
                                                    userCondition = "Good";
                                                } else if(userInput.equals("3")) {
                                                    userCondition = "Excellent";
                                                }
                                                while(!exitLoop) {
                                                    UserOutput.displayDeviceCarrierSelectionPage();
                                                    userInput = UserInput.getUserInput();
                                                    if(userInput.equals("1")) {
                                                        userWirelessCarrier = "Verizon";
                                                    } else if(userInput.equals("2")) {
                                                        userWirelessCarrier = "AT&T";
                                                    } else if(userInput.equals("3")) {
                                                        userWirelessCarrier = "T-Mobile";
                                                    } else if(userInput.equals("4")) {
                                                        userWirelessCarrier = "Unlocked";
                                                    } else if(userInput.equals("5")) {
                                                        exitLoop = true;
                                                    } else {
                                                        UserOutput.displayInvalidInputMessage("Please enter 1, 2, 3, or 4 for device carrier, or enter 5 to exit to the home page.");
                                                    }
                                                }
                                            } else if(userInput.equals("4")) {
                                                exitLoop = true;
                                            } else {
                                                UserOutput.displayInvalidInputMessage("Please enter 1, 2, or 3 for device condition, or enter 4 to exit to the home page.");
                                            }
                                        }
                                    } else {
                                        UserOutput.displayInvalidInputMessage("Please enter 1 to go back to the home page, or enter 2 to proceed to the next step.");
                                    }
                                }
                            } else {
                                UserOutput.displayInvalidInputMessage("Please ask for the supported device model list, enter the device model you want to select or exit to the home page.");
                            }
                        }
                    } else {
                        UserOutput.displayInvalidInputMessage("Please ask for the supported device type list, enter the device type you want to select or exit to the home page.");
                    }
                }
                exitLoop = false;
            }
            // exitLoop = false;
        }

    }
}

