package com.company.homeworkSix.robot;

public class Robot {
    private final int SERIAL_NUMBER;

    public Robot(int SERIAL_NUMBER) {
        this.SERIAL_NUMBER = SERIAL_NUMBER;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "SERIAL_NUMBER=" + SERIAL_NUMBER +
                '}';
    }
}
