package com.company.homeworkTwo;

public class FiveNumbers {
    private int[] fiveNumbersArray = new int[5];
    private static int numberOfNumbers = 0;

    public void storeNumber(int number){
        fiveNumbersArray[numberOfNumbers] = number;
        numberOfNumbers++;
        if (numberOfNumbers > 4){
            numberOfNumbers = 0;
        }
    }

    public double averageOfFiveNumbers(){
        double sum = 0;
        for (int number : fiveNumbersArray) {
            sum += number;
        }
        return sum / 5;
    }
}
