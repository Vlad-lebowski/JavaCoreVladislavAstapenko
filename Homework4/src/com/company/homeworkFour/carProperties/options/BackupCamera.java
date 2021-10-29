package com.company.homeworkFour.carProperties.options;

public class BackupCamera implements Optionable {
    @Override
    public void activateOption() {
        System.out.println("Backup camera activated!");
    }

    @Override
    public String toString() {
        return "BackupCamera{}";
    }
}
