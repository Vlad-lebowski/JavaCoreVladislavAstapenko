package com.company.homeworkFive.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringInputOutput {
    public static void readStringsAndPrintThem(){
        System.out.println("Enter some strings:");
        List<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.isEmpty()){
            stringList.add(input);
            input = scanner.nextLine();
        }
        if(!stringList.isEmpty()){
            System.out.println("Your strings:");
            for (String output:
                    stringList) {
                System.out.println(output);
            }
        }
        System.out.println(stringList);
        scanner.close();
    }
}
