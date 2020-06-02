import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line = " ";
        while (!"0".equals(line)) {
            System.out.println("\n\nCALCULATOR\nPlease, choose operation type:\n\"+\" : Addition\n\"-\" : Subtraction" +
                    "\n\"*\" : Multiplication\n\"/\" : Division\n\"0\" - Close application\nPlease, insert your choise here: ");
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine();
            switch (line) {
                case "+":
                case "-":
                case "*":
                case "/":
                    calculateMenu(line);
                    break;
                case "0":
                    System.err.println("You have chosen EXIT");
                    break;
                default:
                    System.err.println("!!! You have entered wrong symbol. Please try again.");
                    break;
            }
        }
    }

    public static void calculateMenu(String line) {
        String quantity = chooseAmountOfArguments();
        switch (quantity) {
            case "1":
            case "2":
            case "3":
                exactlyCalculation(line, quantity);
                break;
            case "4":
                System.err.println("You have chosen EXIT");
                System.exit(0);   // break is not mandatory here?
        }
    }

    public static String chooseAmountOfArguments() {
        System.out.println("\n\nPlease, choose amount of inserted arguments: \n\"1\" - Two (for example 2 + 2)" +
                "\n\"2\" - More than two (for example 2 + 2 + 2 + 2 + 2 for 5 arguments)" +
                "\n\"3\" - Unknown (arguments are inserting without limitation)\n\"4\" - Close application");
        System.out.println("Please, insert your choise here: ");
        Scanner scannerQuantity = new Scanner(System.in);
        String quantity = scannerQuantity.nextLine();
        if ("1".equals(quantity) || "2".equals(quantity) || "3".equals(quantity) || "4".equals(quantity)) {
            return quantity;
        } else {
            System.err.println("!!! You have entered wrong symbol. Please try again.");
            return chooseAmountOfArguments();
        }
    }

    public static void exactlyCalculation(String line, String quantity) {
        double result = 0;
        if (quantity.equals("1")) {  // only two arguments
            double number1 = getDigits(0);
            double number2 = getDigits(1);
            if (line.equals("+")) {
                result = number1 + number2;
                System.out.println("Your result:\n" + number1 + " + " + number2 + " = " + result);
            } else if (line.equals("-")) {
                result = number1 - number2;
                System.out.println("Your result:\n" + number1 + " - " + number2 + " = " + result);
            } else if (line.equals("*")) {
                result = number1 * number2;
                System.out.println("Your result:\n" + number1 + " * " + number2 + " = " + result);
            } else if (line.equals("/")) {
                if (number2 == 0) {
                    System.err.println("There is NO result - you can not divide on ZERO!");
                } else {
                    result = number1 / number2;
                    System.out.println("Your result:\n" + number1 + " / " + number2 + " = " + result);
                }
            }
        } else if (quantity.equals("2")) {   // known amount of arguments
            int arguments = getArguments();
            ArrayList<Double> digits = new ArrayList<>();
            if (line.equals("+")) {
                for (int i = 0; i < arguments; i++) {
                    double number = getDigits(i);
                    result += number;
                    digits.add(number);
                }
                PrintResults(result, arguments, digits, '+');
            } else if (line.equals("-") || line.equals("*") || line.equals("/")) {
                result = getDigits(0);
                digits.add(result);
                double number = 0;
                for (int i = 1; i < arguments; i++) {
                    number = getDigits(i);
                    if (line.equals("-")) {
                        result -= number;
                    } else if (line.equals("*")) {
                        result *= number;
                    } else if (line.equals("/")) {
                        if (number == 0) {
                            System.err.println("There is NO result - you can not divide on ZERO!");
                            break;
                        } else {
                            result /= number;
                        }
                    }
                    digits.add(number);
                }
                if (line.equals("-")) {
                    PrintResults(result, arguments, digits, '-');
                } else if (line.equals("*")) {
                    PrintResults(result, arguments, digits, '*');
                } else if (line.equals("/") && number != 0) {
                    PrintResults(result, arguments, digits, '/');
                }
            }
        } else if (quantity.equals("3")) {  // unknown amount of arguments
            int i = 0, amountOfDidits = 0;
            ArrayList<Double> digits = new ArrayList<>();
            String number = null;
            while (!"X".equals(number)) {  //???  I do not know why next does not work here now - { || (i >= 1 && "0".equals(number) && line.equals("/"))  }
                number = getDigitsUnknown(i);
                if ( i >= 1 && "0".equals(number) && line.equals("/")) {
                    break;
                } else if (!"X".equals(number)) {
                    if (line.equals("+")) {
                        result += Double.parseDouble(number);
                    } else if (line.equals("-") && (i == 0) || line.equals("*") && (i == 0) || line.equals("/") && (i == 0)) {
                        result = Double.parseDouble(number);
                    }
                    if (line.equals("-") && (i > 0)) {
                        result -= Double.parseDouble(number);
                    } else if (line.equals("*") && (i > 0)) {
                        result *= Double.parseDouble(number);
                    } else if (line.equals("/") && (i > 0)) {
                        result /= Double.parseDouble(number);
                    }
                    digits.add(Double.parseDouble(number));
                    i++;
                    amountOfDidits++;
                }
            }
            if ( (i == 0 || i == 1) && "X".equals(number)) {
                System.err.println("There is NO result - you entered symbol \"X\" for finishing at the very beginning! " +
                        "- Please, enter at least 2 arguments");
            } else if (i >= 1 && "0".equals(number) && line.equals("/")) {
                System.err.println("There is NO result - you can not divide on ZERO!");
            } else {
                if (line.equals("+")) {
                    PrintResults(result, amountOfDidits, digits, '+');
                } else if (line.equals("-")) {
                    PrintResults(result, amountOfDidits, digits, '-');
                } else if (line.equals("*")) {
                    PrintResults(result, amountOfDidits, digits, '*');
                } else if (line.equals("/")) {
                    PrintResults(result, amountOfDidits, digits, '/');
                }
            }
        }
    }

    public static double getDigits(int i) {
        System.out.println("Please insert " + (i + 1) + "st argument here: ");
        Scanner scannerDigits = new Scanner(System.in);
        try {
            return scannerDigits.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("You have entered wrong symbols. Please, enter only digits and try again.");
            return getDigits(i);
        }
    }

    public static int getArguments() {
        System.out.println("Please, enter amount of arguments");
        Scanner scannerDigits = new Scanner(System.in);
        try {
            int valueOfArgument = scannerDigits.nextInt();
            if (valueOfArgument < 0) {
                System.err.println("You have entered NEGATIVE integer. Please, enter only POSITIVE integer and try again.");
                return getArguments();
            } else if (valueOfArgument == 0 || valueOfArgument == 1) {
                System.err.println("You chosen 0 or 1 arguments! Please, enter only positive integer > 1.");
                return getArguments();
            }
            return valueOfArgument;
        } catch (InputMismatchException e) {
            System.err.println("You have entered wrong symbols. Please, enter only INTEGER and try again.");
            return getArguments();
        }
    }

    public static String getDigitsUnknown(int i) {
        System.out.println("Please insert " + (i + 1) + "st argument here: (insert \"X\" to finish inserting)");
        Scanner scannerDigits = new Scanner(System.in);
        try {
            String number = scannerDigits.nextLine();
            if (!"X".equals(number)) {
                Double.parseDouble(number);
            }
            return number;
        } catch (NumberFormatException e) {
            System.err.println("You have entered wrong symbols. Please, enter only digits or symbol \"X\" for finishing and try again.");
            return getDigitsUnknown(i);
        }
    }

    public static void PrintResults(double result, int arguments, ArrayList<Double> digits, char aryphSymbol) {
        System.out.println("Your result:");
        for (int i = 0; i < arguments; i++) {
            System.out.print(digits.get(i));
            if (i != (arguments - 1)) {
                System.out.print(" " + aryphSymbol + " ");
            }
        }
        System.out.print(" = " + result);
    }
}