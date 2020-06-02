package CalculatorClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PrintingManager {

    static void printingResults(double result, ArrayList<Double> listOfDigits, String symbolOfMathematicalOperation) {
        List<String> listOfDigitsInString = listOfDigits.stream().map(Object::toString).collect(Collectors.toList());
        System.out.println("Your result:" + System.lineSeparator() + String.join((" " + symbolOfMathematicalOperation + " "), listOfDigitsInString) + " = " + result);
    }

}