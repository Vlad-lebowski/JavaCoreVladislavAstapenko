package com.company.homeworkFour.carProperties.options;

public class CruiseControl implements Optionable {
    @Override
    public void activateOption() {
        System.out.println("I'm driving with constant speed!");
    }

    @Override
    public String toString() {
        return "CruiseControl{}";
    }
}
