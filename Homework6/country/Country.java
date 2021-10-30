package com.company.homeworkSix.country;

import com.company.homeworkSix.EndOfWarFlag;
import com.company.homeworkSix.factory.Storage;
import com.company.homeworkSix.robot.Robot;
import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Country implements Runnable{
    private final List<Robot> ROBOT_ARMY;
    private final List<RobotBodyParts> STORAGE_OF_THE_COUNTRY;
    private final Storage NEUTRAL_STORAGE;

    private final EndOfWarFlag END_OF_WAR;
    private int serialNumber;

    public Country(Storage storage, EndOfWarFlag flag) {
        this.ROBOT_ARMY = new ArrayList<>();
        this.STORAGE_OF_THE_COUNTRY = new ArrayList<>();
        this.NEUTRAL_STORAGE = storage;
        serialNumber = 0;
        this.END_OF_WAR = flag;
    }

    @Override
    public void run() {
        try {
            while (END_OF_WAR.checkIfWarIsStillGoing()) {
                synchronized (NEUTRAL_STORAGE.getBODY_PARTS_LIST()) {
                    Iterator<RobotBodyParts> iterator = this.NEUTRAL_STORAGE.getBODY_PARTS_LIST().iterator();
                    while (iterator.hasNext()) {
                        RobotBodyParts part = iterator.next();
                        if(!STORAGE_OF_THE_COUNTRY.contains(part)) {
                            STORAGE_OF_THE_COUNTRY.add(part);
                            iterator.remove();
                            System.out.println(Thread.currentThread().getName() + " Current number of details: " + this.NEUTRAL_STORAGE.getBODY_PARTS_LIST().size());
                        }
                    }
                    if (STORAGE_OF_THE_COUNTRY.contains(RobotBodyParts.LEFT_ARM) && STORAGE_OF_THE_COUNTRY.contains(RobotBodyParts.RIGHT_ARM) &&
                            STORAGE_OF_THE_COUNTRY.contains(RobotBodyParts.LEFT_LEG) && STORAGE_OF_THE_COUNTRY.contains(RobotBodyParts.RIGHT_LEG) &&
                            STORAGE_OF_THE_COUNTRY.contains(RobotBodyParts.BODY) && STORAGE_OF_THE_COUNTRY.contains(RobotBodyParts.HEAD)) {
                        ROBOT_ARMY.add(new Robot(++serialNumber));
                        STORAGE_OF_THE_COUNTRY.clear();
                    }

                    Thread.sleep(500);

                    if (ROBOT_ARMY.size() == 20) {
                        System.out.println(Thread.currentThread().getName() + " COUNTRY WON!!!!!");
                        System.out.println(ROBOT_ARMY);
                        END_OF_WAR.endWar();
                    }
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("First country exception. Sorry :((");
        }
    }
}
