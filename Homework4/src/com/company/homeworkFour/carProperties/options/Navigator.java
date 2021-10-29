package com.company.homeworkFour.carProperties.options;

public class Navigator implements Optionable {
    @Override
    public void activateOption() {
        System.out.println("Let's make a route!");
    }

    @Override
    public String toString() {
        return "Navigator{}";
    }
}
