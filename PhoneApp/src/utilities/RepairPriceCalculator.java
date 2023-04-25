package utilities;

import models.phonepart.PhonePart;
import models.phonepart.Screen;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepairPriceCalculator {

    private static BigDecimal partCost;
    private static BigDecimal laborRatePerHour = new BigDecimal("15");
    private static BigDecimal laborExpense;
    private static BigDecimal repairMargin;
    private static BigDecimal repairPrice;
    private static BigDecimal partMarkup;
    private static final double ROYALTY_RATE = .06;
    private static final double PART_MARKUP_RATE = .03;

    public static double calculateLaborHoursPerRepair(PhonePart userPart) {
        double laborHoursPerRepair = 0;
        if(userPart.getPartName().equalsIgnoreCase("screen")) {
            laborHoursPerRepair = .5;
        } else if(userPart.getPartName().equalsIgnoreCase("battery")) {
            laborHoursPerRepair = .75;
        } else if(userPart.getPartName().equalsIgnoreCase("charge port")) {
            laborHoursPerRepair = .75;
        } else if(userPart.getPartName().equalsIgnoreCase("back glass")) {
            laborHoursPerRepair = 1;
        } else if(userPart.getPartName().equalsIgnoreCase("rear camera lens")) {
            laborHoursPerRepair = 1;
        } else if(userPart.getPartName().equalsIgnoreCase("speaker")) {
            laborHoursPerRepair = .75;
        }
        return laborHoursPerRepair;
    }

    public static BigDecimal calculateRepairMargin(PhonePart userPart) {
        BigDecimal repairMargin = new BigDecimal("0");
        if(userPart.getPartCost().compareTo(new BigDecimal("50")) <= 0) {
            repairMargin = new BigDecimal("55");
        } else if(userPart.getPartCost().compareTo(new BigDecimal("150")) <= 0) {
            repairMargin = new BigDecimal("65");
        } else if(userPart.getPartCost().compareTo(new BigDecimal("250")) < 0) {
            repairMargin = new BigDecimal("75");
        } else if(userPart.getPartCost().compareTo(new BigDecimal("250")) >= 0) {
            repairMargin = new BigDecimal("90");
        }
        return repairMargin;
    }

    public static BigDecimal calculateRepairQuote(PhonePart userPart) {
        partCost = userPart.getPartCost();
        laborExpense = laborRatePerHour.multiply(new BigDecimal(calculateLaborHoursPerRepair(userPart)));
        repairMargin = calculateRepairMargin(userPart);
        partMarkup = userPart.getPartCost().multiply(new BigDecimal(PART_MARKUP_RATE));
        BigDecimal cogsPlusMargin = partCost.add(laborExpense).add(repairMargin).add(partMarkup);
        repairPrice = cogsPlusMargin.divide(new BigDecimal(1 - ROYALTY_RATE), 0, RoundingMode.HALF_UP);
        return repairPrice;
    }

    public static void main(String[] args) {
        PhonePart testPart = new Screen();
        testPart.setPartCost(new BigDecimal("20"));
        testPart.setPartName("screen");
        BigDecimal test = calculateRepairQuote(testPart);
        System.out.println(test);

    }

}
