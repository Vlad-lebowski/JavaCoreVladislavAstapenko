package com.company.homeworkSix.factory;

import com.company.homeworkSix.countries.FirstCountry;
import com.company.homeworkSix.countries.SecondCountry;
import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.List;

public class NeutralFactory implements Runnable {
    public static final List<RobotBodyParts> BODY_PARTS_LIST = new ArrayList<>();
    private static int count = 0;

    @Override
    public void run() {
        while (true){
            try {
                if (!FirstCountry.needMoreTroops || !SecondCountry.needMoreTroops_2) {
                    return;
                }
                count++;
                synchronized (BODY_PARTS_LIST) {
                    Thread.sleep(1000);
                    BODY_PARTS_LIST.add(RobotBodyParts.randomPart());
                    System.out.println("Factory produced: " + count);
                    BODY_PARTS_LIST.notify();
                }
            } catch (InterruptedException exception) {
                System.out.println("I'm still learning :(");
            }
        }
    }
}
