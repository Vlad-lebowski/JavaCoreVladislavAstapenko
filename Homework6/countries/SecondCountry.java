package com.company.homeworkSix.countries;

import com.company.homeworkSix.factory.NeutralFactory;
import com.company.homeworkSix.robot.Robot;
import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecondCountry implements Runnable {
    private final List<Robot> ROBOT_ARMY;
    private final List<RobotBodyParts> STORAGE_2;
    public static boolean needMoreTroops_2;
    private static int serialNumber;

    public SecondCountry() {
        this.ROBOT_ARMY = new ArrayList<>();
        this.STORAGE_2 = new ArrayList<>();
        needMoreTroops_2 = true;
        serialNumber = 0;
    }

    @Override
    public void run() {
        try {
            while (needMoreTroops_2) {
                synchronized (NeutralFactory.BODY_PARTS_LIST) {
                    Iterator<RobotBodyParts> iterator = NeutralFactory.BODY_PARTS_LIST.iterator();
                    while (iterator.hasNext()) {
                        RobotBodyParts part = iterator.next();
                        if(!STORAGE_2.contains(part)) {
                            STORAGE_2.add(part);
                            iterator.remove();
                        }
                    }
                    if (STORAGE_2.contains(RobotBodyParts.LEFT_ARM) && STORAGE_2.contains(RobotBodyParts.RIGHT_ARM) &&
                            STORAGE_2.contains(RobotBodyParts.LEFT_LEG) && STORAGE_2.contains(RobotBodyParts.RIGHT_LEG) &&
                            STORAGE_2.contains(RobotBodyParts.BODY) && STORAGE_2.contains(RobotBodyParts.HEAD)) {
                        ROBOT_ARMY.add(new Robot(++serialNumber));
                        STORAGE_2.clear();
                    }

                    Thread.sleep(500);

                    if (ROBOT_ARMY.size() == 10) {
                        System.out.println("SECOND COUNTRY WON!!!!!");
                        System.out.println(ROBOT_ARMY);
                        FirstCountry.needMoreTroops = false;
                        needMoreTroops_2 = false;
                    }
                    NeutralFactory.BODY_PARTS_LIST.notify();
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("First county exception. Sorry :((");
        }
    }
}
