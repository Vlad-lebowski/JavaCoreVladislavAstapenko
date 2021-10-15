package com.company.homeworkFive.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersInputUntilStopWord {
    public static void inputNumbersUntilStopWord(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter at least one number:");
        String inputNumber = scanner.nextLine();
        while (isNotDouble(inputNumber)){
            System.out.println("Your input is wrong. Try again:");
            inputNumber = scanner.nextLine();
        }
        double number = Double.parseDouble(inputNumber);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(number);
        System.out.println("Enter another number or word 'Stop': ");
        String finalInput = scanner.nextLine();
        outerLoop: while (!finalInput.equalsIgnoreCase("Stop")){
            while (isNotDouble(finalInput)){
                System.out.println("Your input is wrong. Try again:");
                finalInput = scanner.nextLine();
                if (finalInput.equalsIgnoreCase("Stop")){
                    break outerLoop;
                }
            }
            System.out.println("Enter another number or word 'Stop': ");
            number = Double.parseDouble(finalInput);
            doubleList.add(number);
            finalInput = scanner.nextLine();
        }

        double averageNumber = doubleList.stream().mapToDouble(a -> a).average().orElse(0);
        System.out.println("Average of your numbers is: " + averageNumber);
        scanner.close();
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
