package CalculatorClasses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private ArrayList<Double> listOfDigits = new ArrayList<>();

    @Test
    void executingActionsAddition() {
        listOfDigits.add(2.0);
        listOfDigits.add(3.0);
        listOfDigits.add(5.0);
        assertEquals(10, Calculator.executingActions("+", listOfDigits));
    }

    @Test
    void executingActionsSubtraction() {
        listOfDigits.add(2.0);
        listOfDigits.add(3.0);
        listOfDigits.add(5.0);
        assertEquals(-6, Calculator.executingActions("-", listOfDigits));
    }

    @Test
    void executingActionsMultiplication() {
        listOfDigits.add(2.0);
        listOfDigits.add(3.0);
        listOfDigits.add(5.0);
        assertEquals(30, Calculator.executingActions("*", listOfDigits));
    }

    @Test
    void executingActionsDivision() {
        listOfDigits.add(300.0);
        listOfDigits.add(3.0);
        listOfDigits.add(5.0);
        assertEquals(20, Calculator.executingActions("/", listOfDigits));
    }

}