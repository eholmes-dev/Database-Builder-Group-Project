package group8.ordersystemdatabasebuilder.ui;

import java.util.Scanner;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class UIHelper {
        /**
     * Prompts the user for a String. Shows the error message if the String is
     * blank.
     *
     * @param prompt the prompt for input
     * @param errorMessage the blank input error message
     * @return the user String
     */
    public static String getUserString(String prompt, String errorMessage) {
        String userInput = null;
        Scanner in = new Scanner(System.in);
        boolean needed = true;
        while (needed) {
            System.out.print(prompt + " ");
            userInput = in.nextLine().trim();
            if (!userInput.isBlank()) {
                needed = false;
            } else {
                UIHelper.showErrorMessage(errorMessage);
            }
        }
        return userInput;
    }
        /**
     * Display an error message and ask that the user acknowledge.
     *
     * @param errorMessage the text of the error message
     */
    public static void showErrorMessage(String errorMessage) {
        System.out.println("\nERROR: " + errorMessage);
        pressEnterToContinue();
    }
    
        /**
     * Prints "Press Enter to Continue" and then waits till the user presses
     * enter.
     */
    public static void pressEnterToContinue() {
        System.out.print("Press enter to continue: ");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
}
