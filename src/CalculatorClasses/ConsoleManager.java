package CalculatorClasses;

import java.util.ArrayList;
import java.util.Scanner;

class ConsoleManager {

    ////////////////////////////////////////////////////////////////////////////////////////// getting symbols for menu
    static String getSymbolsForMenu() {
        boolean whileLoopIsWorking = true;
        Scanner scanner = new Scanner(System.in);
        String lineFromScanner = null;
        while (whileLoopIsWorking) {
            lineFromScanner = scanner.nextLine();
            if (lineFromScanner == null) {
                System.err.println("You have entered NO symbols. Please, enter again.");
            } else {
                whileLoopIsWorking = false;
            }
        }
        return lineFromScanner;
    }

    /////////////////////////////////////////////////////////////////////////////////////// getting digit for arguments
    static Integer getNumberForArguments() {
        boolean whileLoopIsWorking = true;
        Scanner scannerDigits = new Scanner(System.in);
        String lineFromScanner;
        int argument = 0;
        while (whileLoopIsWorking) {
            System.out.println("Please, enter amount of arguments");
            lineFromScanner = scannerDigits.nextLine();
            try {
                argument = Integer.parseInt(lineFromScanner);
                if (argument < 0) {
                    System.err.println("You have entered NEGATIVE integer." +
                            " Please, enter only POSITIVE integer and try again.");
                } else if (argument == 0 || argument == 1) {
                    System.err.println("You chosen 0 or 1 arguments! Please, enter only positive integer > 1.");
                } else {
                    whileLoopIsWorking = false;
                }
            } catch (NumberFormatException e) {
                System.err.println("You have entered wrong symbols. Please, enter only INTEGER and try again.");
            }
        }
        return argument;
    }

    /////////////////////////////////////////////////////////////// getting digits for List of known quantity of digits
    private static Double getNumbersForKnownQuantityOfDigits() {
        boolean whileLoopIsWorking = true;
        Scanner scannerDigits = new Scanner(System.in);
        String lineFromScanner;
        double ourNumber = 0.0;
        while (whileLoopIsWorking) {
            lineFromScanner = scannerDigits.nextLine();
            try {
                ourNumber = Double.parseDouble(lineFromScanner);
                whileLoopIsWorking = false;
            } catch (NumberFormatException e) {
                System.err.println("You have entered wrong symbols. Please, enter only digits and try again.");
            }
        }
        return ourNumber;
    }

    ///////////////////////////////////////////////////////////// getting digits for List of unknown quantity of digits
    private static String getNumbersForUnknownQuantityOfDigits() {
        boolean whileLoopIsWorking = true;
        Scanner scannerDigits = new Scanner(System.in);
        String lineFromScanner = null;
        while (whileLoopIsWorking) {
            try {
                lineFromScanner = scannerDigits.nextLine();
                if (!"X".equals(lineFromScanner)) {
                    Double.parseDouble(lineFromScanner);
                }
                whileLoopIsWorking = false;
            } catch (NumberFormatException e) {
                System.err.println("You have entered wrong symbols." +
                        " Please, enter only digits or symbol \"X\" for finishing and try again.");
            }
        }
        return lineFromScanner;
    }

    /////////////////////////////////////////////////////////////// getting digits for List of known quantity of digits
    static ArrayList<Double> getListOfKnownQuantityOfDigits(int quantityOfDigits, String line) {  // in case of division
        ArrayList<Double> listOfKnownQuantityOfDigits = new ArrayList<>();
        double ourDigit;
        int i = 0;
        while (i < quantityOfDigits) {
            System.out.println("Please insert argument number " + (i + 1) + " here: ");
            ourDigit = getNumbersForKnownQuantityOfDigits();
            if (i >= 1 && ourDigit == 0 && "/".equals(line)) {
                System.err.println("There is NO result - you can not divide on ZERO! " +
                        "Please, do not enter ZERO (0) - try again.");
                continue;
            }
            listOfKnownQuantityOfDigits.add(ourDigit);
            i++;
        }
        return listOfKnownQuantityOfDigits;
    }

    ///////////////////////////////////////////////////////////// getting digits for List of unknown quantity of digits
    static ArrayList<Double> getListOfUnknownQuantityOfDigits(String line) {
        ArrayList<Double> listOfUnknownQuantityOfDigits = new ArrayList<>();
        ArrayList<String> listOfStringsFromScanner = new ArrayList<>();
        int i = 0;
        String lineFromScanner;
        boolean whileLoopIsWorking = true;
        while (whileLoopIsWorking) {
            System.out.println("Please insert argument number " + (i + 1) + " here: (insert \"X\" to finish inserting)");
            lineFromScanner = getNumbersForUnknownQuantityOfDigits();
            if (i >= 1 && "0".equals(lineFromScanner) && "/".equals(line)) {
                System.err.println("There is NO result - you can not divide on ZERO! " +
                        "Please, do not enter ZERO (0) - try again.");
                continue;
            } else if (!"X".equals(lineFromScanner)) {
                listOfStringsFromScanner.add(lineFromScanner);
            } else if (i == 0 || i == 1) {
                System.err.println("There is NO result - you entered symbol \"X\" for finishing at the very beginning! " +
                        "- Please, enter at least 2 arguments");
                continue;
            } else {
                whileLoopIsWorking = false;
            }
            i++;
        }
        for (String ourLineFromListOfStrings : listOfStringsFromScanner) {
            listOfUnknownQuantityOfDigits.add(Double.parseDouble(ourLineFromListOfStrings));
        }
        return listOfUnknownQuantityOfDigits;
    }

}