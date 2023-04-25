package ui;

import models.phone.Phone;
import models.phonepart.PhonePart;
import utilities.PartLookup;
import utilities.PhoneLookup;
import utilities.RepairPriceCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserOutput {

    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -------------- General/Shared menus, pages and messages
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------

    public static void displayHomePage() {
        System.out.println("********************************************");
        System.out.println("***************** Welcome! *****************");
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Thank you for choosing PhoneGuide, where we guide you" +
                          "\nthrough selling, buying and/or repairing your device!");
        System.out.println();
        System.out.println("Please select one of the following options: ");
        System.out.println();
        System.out.println("(1) Looking to sell? See what your phone is worth today!");
        System.out.println("(2) [COMING SOON] Looking to buy? Explore your options!");
        System.out.println("(3) Broken phone? Get a repair estimate!");
        System.out.println("(4) Exit");
        System.out.println();
    }

    public static void displaySupportedDeviceType(List<Phone> supportedDeviceList) {
        System.out.println();
        System.out.println("Below is a list of device types currently supported by this program: ");
        System.out.println();
        List<String> deviceTypeList = new ArrayList<>();
        for (Phone currentPhone : supportedDeviceList) {
            if(deviceTypeList.contains(currentPhone.getDeviceType())) {
                continue;
            } else {
                deviceTypeList.add(currentPhone.getDeviceType());
            }
        }
        for (String currentDeviceType : deviceTypeList) {
            System.out.println(currentDeviceType);
        }
        System.out.println();
    }

    public static void displaySupportedDeviceMap(Map<String, String> supportedDeviceMap) {
        System.out.println();
        System.out.println("Below is a list of devices currently supported by this program: ");
        System.out.println();
        for (Map.Entry<String, String> currentItem : supportedDeviceMap.entrySet()) {
            System.out.printf("%-10s %-30s%n", currentItem.getValue(), currentItem.getKey());
        }
        System.out.println();
    }

    public static void displayDeviceTypeSelectionPage() {
        System.out.println();
        System.out.println("For a list of the types of phones currently supported by this program, enter \"type list\" or simply \"list\".");
        System.out.println("You can enter \"exit\" if you would like to return to the home page.");
        System.out.println();
        System.out.println("If you would like to proceed and know the type of device you want to select, please enter it below.");
        System.out.println("Example: \"iPhone\"");
        System.out.println();
    }

    public static void displayDeviceModelSelectionPage() {
        System.out.println();
        System.out.println("For a list of device models currently supported by this program, enter \"device list\" or simply \"list\".");
        System.out.println("You can enter \"exit\" if you would like to return to the home page.");
        System.out.println();
        System.out.println("If you would like to proceed and know the type of device you want to select, please enter it below.");
        System.out.println("Example: \"iPhone 11\"");
        System.out.println();
    }

    public static void displayInvalidInputMessage(String acceptableInputs) {
        System.out.println();
        System.out.println("*******************************************************");
        System.out.println("INVALID INPUT");
        System.out.println(acceptableInputs);
        System.out.println("*******************************************************");
        System.out.println();
    }

    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -------------- Sell menus, pages and messages
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------

    public static void displayDeviceCarrierSelectionPage() {
        System.out.println();
        System.out.println("Next, we'll need to know whether your device is unlocked or tied to a specific carrier.");
        System.out.println("Please select one of the options below. If you're unsure or your carrier is not listed, select the \"unlocked\" option.");
        System.out.println();
        System.out.println("(1) Verizon");
        System.out.println("(2) AT&T");
        System.out.println("(3) T-Mobile");
        System.out.println("(4) Unlocked");
        System.out.println("(5) Exit");
        System.out.println();
    }

    public static void displayFunctionCheckPageIfSelling() {
        System.out.println();
        System.out.println("We're going to need to check a few things before getting your device's market value.");
        System.out.println("First off, is the device fully-functional? Here are some things to check for: ");
        System.out.println();
        System.out.println("1. The device turns on");
        System.out.println("2. No visible signs of liquid damage");
        System.out.println("3. No visible signs of damage to the screen");
        System.out.println("4. Power, volume, mute and/or home button(s) operate without issue");
        System.out.println("5. Both the front and rear camera(s) are working");
        System.out.println("6. Your microphone and speakers sound clear when making calls, playing music, etc.");
        System.out.println();
        System.out.println("If your device fails to meet any of the above criteria, then you'll need to have it repaired before selling it.");
        System.out.println("If your device meets the above criteria, then proceed to the next menu.");
        System.out.println("Please select one of the options below: ");
        System.out.println();
        System.out.println("(1) My device failed to meet one or more of the above criteria. Return to the home page.");
        System.out.println("(2) My device passed the above criteria. Proceed to the next step.");
        System.out.println();
    }

    public static void displayDeviceConditionPageForSelling() {
        System.out.println();
        System.out.println("Let's get the condition of the device you're looking to sell.");
        System.out.println("Please select one of the conditions below: ");
        System.out.println();
        System.out.println("(1) Fair");
        System.out.println("(2) Good");
        System.out.println("(3) Excellent");
        System.out.println("(4) Exit");
        System.out.println();
        System.out.println("Here's a short description for each condition if you're having trouble deciding: ");
        System.out.println();
        System.out.println("Fair:       Device is functional but shows aggressive signs of wear and tear; scratches on the screen,");
        System.out.println("            dents or scratches on the frame, and/or small chips on the back glass or rear camera lens.");
        System.out.println();
        System.out.println("Good:       Device is functional but shows mild signs of wear and tear; light scratches on the screen,");
        System.out.println("            light scratches on the frame but no dents, scratches on the back glass but no chips.");
        System.out.println();
        System.out.println("Excellent:  Device is functional and shows trivial signs of wear and tear; little to no signs of");
        System.out.println("            scratches on the screen, frame, back glass or rear camera lens. Could be described as mint.");
        System.out.println();
    }

    public static void displayDeviceMarketValuePage(List<Phone> supportedDeviceList, Phone userPhone) {
        System.out.println();
        System.out.println("Thanks for the information! The market value for the device you selected is below: ");
        System.out.println();
        System.out.println(userPhone);
        System.out.println();
        System.out.println("Average market value: $" + PhoneLookup.getMarketValue(supportedDeviceList, userPhone));
        System.out.println("Swappa market value: $" + PhoneLookup.getSwappaValue(supportedDeviceList, userPhone));
        System.out.println("eBay market value: $" + PhoneLookup.getEbayValue(supportedDeviceList, userPhone));
        System.out.println("Gazelle market value: $" + PhoneLookup.getGazelleValue(supportedDeviceList, userPhone));
        System.out.println();
        System.out.println("When you're ready, press any button to return to the home page.");
        System.out.println();
    }

    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -------------- Repair menus, pages and messages
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------

    public static void displaySupportedRepairTypes(List<String> supportedRepairList) {
        System.out.println();
        System.out.println("Below is a list of repair types currently supported by this program: ");
        System.out.println();
        for (String currentString : supportedRepairList) {
            System.out.println(currentString);
        }
        System.out.println();
    }

    public static void displayRepairSelectionPage() {
        System.out.println();
        System.out.println("For a list of repairs currently supported by this program, enter \"repair list\" or simply \"list\".");
        System.out.println("You can enter \"exit\" if you would like to return to the home page.");
        System.out.println();
        System.out.println("If you would like to proceed and know the type of repair you want to select, please enter it below.");
        System.out.println("Example: \"screen\"");
        System.out.println();
    }

    public static void displayRepairQuotePage(PhonePart userPart) {
        System.out.println();
        System.out.println("Thanks for the information! Based on the information provided, here's a repair quote: ");
        System.out.println();
        System.out.println(userPart);
        System.out.println();
        System.out.println("Repair quote: $" + RepairPriceCalculator.calculateRepairQuote(userPart));
        System.out.println();
        System.out.println("This quote was calculated based on the following: ");
        System.out.println();
        System.out.printf("%-15s %5s%n", "Part cost: ", "$" + RepairPriceCalculator.getPartCost());
        System.out.printf("%-15s %5s%n", "Labor expense: ", "$" + RepairPriceCalculator.getLaborExpense());
        System.out.printf("%-15s %5s%n", "Repair margin: ", "$" + RepairPriceCalculator.getRepairMargin());
        System.out.printf("%-15s %5s%n", "Part markup: ", "$" + RepairPriceCalculator.getPartMarkup());
        System.out.printf("%-15s %5s%n", "Royalty: ", "$" + RepairPriceCalculator.getRepairPrice().subtract(RepairPriceCalculator.getPartCost())
                .subtract(RepairPriceCalculator.getLaborExpense()).subtract(RepairPriceCalculator.getRepairMargin())
                .subtract(RepairPriceCalculator.getPartMarkup()));
        System.out.println();
        System.out.println("When you're ready, press any button to return to the home page.");
        System.out.println();
    }



}
