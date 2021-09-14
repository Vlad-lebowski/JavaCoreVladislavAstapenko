package com.company.homeworkTwo;

public class Month {
    private int monthNumber;
    private String monthName;

    public String getMonthName(){
        return monthName;
    }
    public int getMonthNumber(){
        return monthNumber;
    }

    public void setMonthName(String monthName){
        this.monthName = monthName;
        switch (this.monthName){
            case "January":
                this.monthNumber = 1;
                break;
            case "February":
                this.monthNumber = 2;
                break;
            case "March":
                this.monthNumber = 3;
                break;
            case "April":
                this.monthNumber = 4;
                break;
            case "May":
                this.monthNumber = 5;
                break;
            case "June":
                this.monthNumber = 6;
                break;
            case "July":
                this.monthNumber = 7;
                break;
            case "August":
                this.monthNumber = 8;
                break;
            case "September":
                this.monthNumber = 9;
                break;
            case "October":
                this.monthNumber = 10;
                break;
            case "November":
                this.monthNumber = 11;
                break;
            case "December":
                this.monthNumber = 12;
                break;
            default:
                System.out.println("There is no such month");
        }

    }
    public void setMonthNumber(int monthNumber){
        this.monthNumber = monthNumber;
        switch (this.monthNumber){
            case 1:
                this.monthName = "January";
                break;
            case 2:
                this.monthName = "February";
                break;
            case 3:
                this.monthName = "March";
                break;
            case 4:
                this.monthName = "April";
                break;
            case 5:
                this.monthName = "May";
                break;
            case 6:
                this.monthName = "June";
                break;
            case 7:
                this.monthName = "July";
                break;
            case 8:
                this.monthName = "August";
                break;
            case 9:
                this.monthName = "September";
                break;
            case 10:
                this.monthName = "October";
                break;
            case 11:
                this.monthName = "November";
                break;
            case 12:
                this.monthName = "December";
                break;
            default:
                System.out.println("There is no such month");
        }
    }

    public void getMonthNumberFromMonthName(String monthName){
        this.monthName = monthName;
        switch (this.monthName){
            case "January":
                System.out.println("Number of " + monthName + " is 1");
                break;
            case "February":
                System.out.println("Number of " + monthName + " is 2");
                break;
            case "March":
                System.out.println("Number of " + monthName + " is 3");
                break;
            case "April":
                System.out.println("Number of " + monthName + " is 4");
                break;
            case "May":
                System.out.println("Number of " + monthName + " is 5");
                break;
            case "June":
                System.out.println("Number of " + monthName + " is 6");
                break;
            case "July":
                System.out.println("Number of " + monthName + " is 7");
                break;
            case "August":
                System.out.println("Number of " + monthName + " is 8");
                break;
            case "September":
                System.out.println("Number of " + monthName + " is 9");
                break;
            case "October":
                System.out.println("Number of " + monthName + " is 10");
                break;
            case "November":
                System.out.println("Number of " + monthName + " is 11");
                break;
            case "December":
                System.out.println("Number of " + monthName + " is 12");
                break;
            default:
                System.out.println("There is no such month");
        }
    }

    public void getMonthNameFromMonthNumber(int monthNumber){
        this.monthNumber = monthNumber;
        switch (this.monthNumber){
            case 1:
                System.out.println("Name of the month by the number " + monthNumber + " is January");
                break;
            case 2:
                System.out.println("Name of the month by the number " + monthNumber + " is February");
                break;
            case 3:
                System.out.println("Name of the month by the number " + monthNumber + " is March");
                break;
            case 4:
                System.out.println("Name of the month by the number " + monthNumber + " is April");
                break;
            case 5:
                System.out.println("Name of the month by the number " + monthNumber + " is May");
                break;
            case 6:
                System.out.println("Name of the month by the number " + monthNumber + " is June");
                break;
            case 7:
                System.out.println("Name of the month by the number " + monthNumber + " is July");
                break;
            case 8:
                System.out.println("Name of the month by the number " + monthNumber + " is August");
                break;
            case 9:
                System.out.println("Name of the month by the number " + monthNumber + " is September");
                break;
            case 10:
                System.out.println("Name of the month by the number " + monthNumber + " is October");
                break;
            case 11:
                System.out.println("Name of the month by the number " + monthNumber + " is November");
                break;
            case 12:
                System.out.println("Name of the month by the number " + monthNumber + " is December");
                break;
            default:
                System.out.println("There is no such month");
        }
    }
}
