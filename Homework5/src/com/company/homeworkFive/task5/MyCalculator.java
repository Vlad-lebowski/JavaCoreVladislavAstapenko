package com.company.homeworkFive.task5;

import java.util.Scanner;

public class MyCalculator {

    public static void operationWithTwoNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        String firstInput = scanner.nextLine();
        while(isNotDouble(firstInput)){
            System.out.println("Your input is wrong. Try again: ");
            firstInput = scanner.nextLine();
        }
        double firstNumber = Double.parseDouble(firstInput);

        System.out.println("Enter operation (+-/*): ");
        String operationInput = scanner.nextLine();
        while (!operationInput.equals("+") && !operationInput.equals("-") && !operationInput.equals("/") && !operationInput.equals("*")){
            System.out.println("Your input is wrong. Try again: ");
            operationInput = scanner.nextLine();
        }

        System.out.println("Enter second number: ");
        String secondInput = scanner.nextLine();
        while(isNotDouble(secondInput)){
            System.out.println("Your input is wrong. Try again: ");
            secondInput = scanner.nextLine();
        }
        double secondNumber = Double.parseDouble(secondInput);

        double result;
        switch (operationInput) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                result = firstNumber * secondNumber;
                break;
        }
        System.out.println("Result: " + result);
    }

    private static boolean isNotDouble(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
