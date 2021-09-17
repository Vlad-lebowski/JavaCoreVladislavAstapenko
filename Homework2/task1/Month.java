package com.company.homeworkTwo;

public class Month {

    public void getMonthfromNumber (int monthNumber){
        MonthEnum month;
        for (int i = 0; i < MonthEnum.values().length; i++){
            if(MonthEnum.values()[i].getMonthNumber() == monthNumber){
                month = MonthEnum.values()[i];
                System.out.println("Your month is " + month + "!");
                return;
            }
        }
        System.out.println("There is no such month!");
    }

    public void getNumberFromMonth (MonthEnum monthEnum){
        int number;
        for (int i = 0; i < MonthEnum.values().length; i++){
            if(MonthEnum.values()[i]== monthEnum){
                number = MonthEnum.values()[i].getMonthNumber();
                System.out.println("Your month number is " + number + "!");
                return;
            }
        }
        System.out.println("There must be some mistake!");
    }
}
