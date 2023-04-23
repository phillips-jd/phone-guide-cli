package ui;

import java.util.Scanner;

public class UserInput {

    private static Scanner userInputScanner = new Scanner(System.in);

    public static String getUserInput() {
        String userInput = userInputScanner.nextLine();
        return userInput;
    }

}
