package com.company.homeworkSix.countries;

import com.company.homeworkSix.factory.NeutralFactory;
import com.company.homeworkSix.robot.Robot;
import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstCountry implements Runnable{
    private final List<Robot> ROBOT_ARMY;
    private final List<RobotBodyParts> STORAGE_1;
    public static boolean needMoreTroops;
    private static int serialNumber;

    public FirstCountry() {
        this.ROBOT_ARMY = new ArrayList<>();
        this.STORAGE_1 = new ArrayList<>();
        needMoreTroops = true;
        serialNumber = 0;
    }

    @Override
    public void run() {
        try {
            while (needMoreTroops) {
                synchronized (NeutralFactory.BODY_PARTS_LIST) {
                    Iterator<RobotBodyParts> iterator = NeutralFactory.BODY_PARTS_LIST.iterator();
                    while (iterator.hasNext()) {
                        RobotBodyParts part = iterator.next();
                        if(!STORAGE_1.contains(part)) {
                            STORAGE_1.add(part);
                            iterator.remove();
                        }
                    }
                    if (STORAGE_1.contains(RobotBodyParts.LEFT_ARM) && STORAGE_1.contains(RobotBodyParts.RIGHT_ARM) &&
                            STORAGE_1.contains(RobotBodyParts.LEFT_LEG) && STORAGE_1.contains(RobotBodyParts.RIGHT_LEG) &&
                            STORAGE_1.contains(RobotBodyParts.BODY) && STORAGE_1.contains(RobotBodyParts.HEAD)) {
                        ROBOT_ARMY.add(new Robot(++serialNumber));
                        STORAGE_1.clear();
                    }

                    Thread.sleep(500);

                    if (ROBOT_ARMY.size() == 10) {
                        System.out.println("FIRST COUNTRY WON!!!!!");
                        System.out.println(ROBOT_ARMY);
                        SecondCountry.needMoreTroops_2 = false;
                        needMoreTroops = false;
                    }
                    NeutralFactory.BODY_PARTS_LIST.notify();
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("First county exception. Sorry :((");
        }
    }
}
