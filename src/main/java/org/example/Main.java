package org.example;

import java.math.BigDecimal;
import java.util.*;

public class Main {


    static SimpleCalculator simpleCalculator = new SimpleCalculator();
    static ScientificCalculator scientificCalculator = new ScientificCalculator();
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        new UserInterface();

        // écrire une fonction avec 3 arguments : le nombre 1, l'opérateur et le nombre 2
        // faire un switch pour faire l'opération adéquate en fonction de l'opérateur

        BigDecimal number1;
        BigDecimal number2 = null;
        String operator;

        Scanner scanner = new Scanner(System.in);
        List<String> twiceNumberCalculationOperator = Arrays.asList("+", "-", "*", "/", "p");
        List<String> ScientificOperator = Arrays.asList("r", "s", "p");



        doSimpleCalculation(simpleCalculator, userInterface.getClickedButtonValue(), userInterface.getClickedButtonValue(), userInterface.getClickedButtonValue().toString());
        System.out.println(userInterface.getClickedButtonValue());
        do {


            number1 = readNumber(scanner, "Enter a number : ");
            scanner.nextLine();
            operator = readOperator(scanner);
            if (twiceNumberCalculationOperator.contains(operator)) {
                number2 = readNumber(scanner, "Enter a second number : ");
                scanner.nextLine();
            }
            BigDecimal result = ScientificOperator.contains(operator)
                    ? doScientificCalculation(scientificCalculator, number1, number2, operator)
                    : doSimpleCalculation(simpleCalculator, number1, number2, operator);
            System.out.println("The result is : " + result);
        } while (askToContinue(scanner));
    }


    // to read a number
    private static BigDecimal readNumber(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.println(message);
                return scanner.nextBigDecimal();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number");
                scanner.nextLine();
            }
        }
    }

    // to read an operator (r = square root ; c = square ; e = pow
    private static String readOperator(Scanner scanner) {
        
        Set<String> validOperator = new HashSet<>(Arrays.asList("+", "-", "*", "/", "r", "s", "p"));
        String operator;
        do {
            System.out.println("Which operator + - * / r s p");
            operator = scanner.nextLine();
        } while (!validOperator.contains(operator));
        return operator;
    }

    // to calculate a simple operation
    private static BigDecimal doSimpleCalculation(SimpleCalculation simpleCalculation, BigDecimal number1, BigDecimal number2, String operator) {
        switch (operator) {
            case "+":
                return simpleCalculation.additionner(number1, number2);
            case "-":
                return simpleCalculation.soustraire(number1, number2);
            case "*":
                return simpleCalculation.multiplier(number1, number2);
            case "/":
                return simpleCalculation.diviser(number1, number2);
            default:
                throw new IllegalArgumentException("Unknown operator : " + operator);
        }
    }
    // to calculate a scientific operation
    private static BigDecimal doScientificCalculation(ScientificCalculation scientificCalculation, BigDecimal number1, BigDecimal number2, String operator) {
        switch (operator) {
            case "r":
                return scientificCalculation.racineCarree(number1);
            case "s":
                return scientificCalculation.eleverAuCarre(number1);
            case "p":
                return scientificCalculation.exponentiation(number1, number2.intValue());
            default:
                throw new IllegalArgumentException("Unknown operator : " + operator);
        }
    }
    // ask to user if he wants to start a new operation
    private static boolean askToContinue(Scanner scanner) {
        System.out.println("Do you want to do a new operation ? (y/n)");
        String response = scanner.nextLine();
        return "y".equals(response);
    }

}