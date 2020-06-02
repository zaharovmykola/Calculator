package CalculatorClasses;

import java.util.ArrayList;

class Calculator {
    static void exactlyCalculation(String symbolOfMathematicalOperation, String quantityOfArguments) {
        if (quantityOfArguments.equals("1") || quantityOfArguments.equals("2")) {
            calculationForKnownAmountOfArguments(symbolOfMathematicalOperation, quantityOfArguments);
        } else if (quantityOfArguments.equals("3")) {
            calculationForUnknownAmountOfArguments(symbolOfMathematicalOperation);
        }
    }

    ///////////////////////////////////////////////////////////////////// for known amount of digits and for two digits
    private static void calculationForKnownAmountOfArguments(String symbolOfMathematicalOperation, String quantityOfArgumentsLikeString) {
        int amountOfArgumentsLikeInteger = ("1".equals(quantityOfArgumentsLikeString)) ? 2 : CalculatorClasses.ConsoleManager.getNumberForArguments();  //  class ConsoleManager
        ArrayList<Double> listOfKnownQuantityOfDigits = CalculatorClasses.ConsoleManager.getListOfKnownQuantityOfDigits(amountOfArgumentsLikeInteger, symbolOfMathematicalOperation);  //  class ConsoleManager
        double result = executingActions(symbolOfMathematicalOperation, listOfKnownQuantityOfDigits);
        CalculatorClasses.PrintingManager.printingResults(result, listOfKnownQuantityOfDigits, symbolOfMathematicalOperation);
    }

    /////////////////////////////////////////////////////////////////////////////////////  for unknown amount of digits
    private static void calculationForUnknownAmountOfArguments(String symbolOfMathematicalOperation) {
        ArrayList<Double> listOfUnknownQuantityOfDigits = CalculatorClasses.ConsoleManager.getListOfUnknownQuantityOfDigits(symbolOfMathematicalOperation);  //  class ConsoleManager
        double result = executingActions(symbolOfMathematicalOperation, listOfUnknownQuantityOfDigits);
        CalculatorClasses.PrintingManager.printingResults(result, listOfUnknownQuantityOfDigits, symbolOfMathematicalOperation);
    }

    ////////////////////////////////////////////////////////////////// general for known and unknown quantity of digits
    static double executingActions(String symbolOfMathematicalOperation, ArrayList<Double> listOfDigits) {
        double result = listOfDigits.get(0);
        for (int i = 1; i < listOfDigits.size(); i++) {
            if (symbolOfMathematicalOperation.equals("+")) {
                result += listOfDigits.get(i);
            } else if (symbolOfMathematicalOperation.equals("-")) {
                result -= listOfDigits.get(i);
            } else if (symbolOfMathematicalOperation.equals("*")) {
                result *= listOfDigits.get(i);
            } else {
                result /= listOfDigits.get(i);
            }
        }
        return result;
    }

}