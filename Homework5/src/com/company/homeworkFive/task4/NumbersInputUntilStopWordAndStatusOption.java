package com.company.homeworkFive.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumbersInputUntilStopWordAndStatusOption {

    public static void inputNumbersUntilStopWordWithStatusOption(){
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
        System.out.println("Enter another number or word 'Stop' or 'Status' option: ");
        String finalInput = scanner.nextLine();
        while (finalInput.equalsIgnoreCase("status")){
            Collections.sort(doubleList);
            System.out.println(doubleList);
            System.out.println("Enter another number or word 'Stop' or 'Status' option:");
            finalInput = scanner.nextLine();
        }

        outerLoop: while (!finalInput.equalsIgnoreCase("Stop")){
            while (isNotDouble(finalInput)){
                System.out.println("Your input is wrong. Try again:");
                finalInput = scanner.nextLine();
                if (finalInput.equalsIgnoreCase("Stop")){
                    break outerLoop;
                }
                while (finalInput.equalsIgnoreCase("status")){
                    Collections.sort(doubleList);
                    System.out.println(doubleList);
                    System.out.println("Enter another number or word 'Stop' or 'Status' option:");
                    finalInput = scanner.nextLine();
                    if (finalInput.equalsIgnoreCase("Stop")){
                        break outerLoop;
                    }
                }
            }
            number = Double.parseDouble(finalInput);
            doubleList.add(number);
            System.out.println("Enter another number or word 'Stop' or 'Status' option:");
            finalInput = scanner.nextLine();
            while (finalInput.equalsIgnoreCase("status")){
                Collections.sort(doubleList);
                System.out.println(doubleList);
                System.out.println("Enter another number or word 'Stop' or 'Status' option:");
                finalInput = scanner.nextLine();
                if (finalInput.equalsIgnoreCase("Stop")){
                    break outerLoop;
                }
            }
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
