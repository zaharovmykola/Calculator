package CalculatorClasses;

class Menu {

    static void mainMenu() {
        String symbolOfMathematicalOperation = " ";
        boolean menuWorking = true;
        while (menuWorking) {
            System.out.println("\n\nCALCULATOR" +
                    "\nPlease, choose operation type:" +
                    "\n\"+\" : Addition" +
                    "\n\"-\" : Subtraction" +
                    "\n\"*\" : Multiplication" +
                    "\n\"/\" : Division" +
                    "\n\"0\" - Close application" +
                    "\nPlease, insert your choise here: ");
            symbolOfMathematicalOperation = CalculatorClasses.ConsoleManager.getSymbolsForMenu(); // class ScannerForCalculator   MENU
            switch (symbolOfMathematicalOperation) {
                case "+":
                case "-":
                case "*":
                case "/":
                    innerMenu(symbolOfMathematicalOperation);
                    break;
                case "0":
                    System.err.println("You have chosen EXIT");
                    menuWorking = false;
                    break;
                default:
                    System.err.println("!!! You have entered wrong symbol. Please try again.");
                    break;
            }
        }
    }

    private static void innerMenu(String symbolOfMathematicalOperation) {
        String quantityOfArguments = chooseAmountOfArgumentsForInnerMenu();
        switch (quantityOfArguments) {
            case "1":
            case "2":
            case "3":
                Calculator.exactlyCalculation(symbolOfMathematicalOperation, quantityOfArguments); // class Calculation
                break;
            case "4":
                System.err.println("You have chosen EXIT");
                System.exit(0);
        }
    }

    private static String chooseAmountOfArgumentsForInnerMenu() {
        boolean whileLoopIsWorking = true;
        String quantityOfArguments = null;
        while (whileLoopIsWorking) {
            System.out.println("\n\nPlease, choose amount of inserted arguments: " +
                    "\n\"1\" - Two (for example 2 + 2)" +
                    "\n\"2\" - More than two (for example 2 + 2 + 2 + 2 + 2 for 5 arguments)" +
                    "\n\"3\" - Unknown (arguments are inserting without limitation)" +
                    "\n\"4\" - Close application");
            System.out.println("Please, insert your choiсe here: ");
            quantityOfArguments = CalculatorClasses.ConsoleManager.getSymbolsForMenu(); // class ScannerForCalculator   MENU
            if ("1".equals(quantityOfArguments) || "2".equals(quantityOfArguments) || "3".equals(quantityOfArguments) || "4".equals(quantityOfArguments)) {
                whileLoopIsWorking = false;
            } else {
                System.err.println("!!! You have entered wrong symbol. Please try again.");
            }
        }
        return quantityOfArguments;
    }
}