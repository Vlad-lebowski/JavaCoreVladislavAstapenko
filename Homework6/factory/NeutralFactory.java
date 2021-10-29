package com.company.homeworkSix.factory;

import com.company.homeworkSix.countries.Country;
import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.List;

public class NeutralFactory implements Runnable {
    private final List<RobotBodyParts> BODY_PARTS_LIST = new ArrayList<>();
    private int count = 0;

    public List<RobotBodyParts> getBODY_PARTS_LIST() {
        return BODY_PARTS_LIST;
    }

    private Country firstCountry;
    private Country secondCountry;


    public void setFirstCountry(Country firstCountry) {
        this.firstCountry = firstCountry;
    }

    public void setSecondCountry(Country secondCountry) {
        this.secondCountry = secondCountry;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (BODY_PARTS_LIST) {
                    if (firstCountry.isNeedMoreTroops() || secondCountry.isNeedMoreTroops()) {
                        return;
                    }
                    count++;

                    Thread.sleep(5000);
                    BODY_PARTS_LIST.add(RobotBodyParts.randomPart());
                    System.out.println("Factory produced: " + count);
                    BODY_PARTS_LIST.notify();
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("I'm still learning :(");
        }
    }
}
