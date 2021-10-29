package com.company.homeworkSix.countries;

import com.company.homeworkSix.factory.NeutralFactory;
import com.company.homeworkSix.robot.Robot;
import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Country implements Runnable{
    private final List<Robot> ROBOT_ARMY;
    private final List<RobotBodyParts> STORAGE_1;
    private final NeutralFactory neutralFactory;

    private Country secondCountry;

    public void setSecondCountry(Country secondCountry) {
        this.secondCountry = secondCountry;
    }

    public boolean isNeedMoreTroops() {
        return !needMoreTroops;
    }

    private boolean needMoreTroops;
    private int serialNumber;

    public Country(NeutralFactory neutralFactory) {
        this.ROBOT_ARMY = new ArrayList<>();
        this.STORAGE_1 = new ArrayList<>();
        this.neutralFactory = neutralFactory;
        needMoreTroops = true;
        serialNumber = 0;
    }

    @Override
    public void run() {
        try {
            while (needMoreTroops) {
                synchronized (this.neutralFactory.getBODY_PARTS_LIST()) {
                    Iterator<RobotBodyParts> iterator = this.neutralFactory.getBODY_PARTS_LIST().iterator();
                    while (iterator.hasNext()) {
                        RobotBodyParts part = iterator.next();
                        if(!STORAGE_1.contains(part)) {
                            STORAGE_1.add(part);
                            iterator.remove();
                            System.out.println(Thread.currentThread().getName() + " Current number of details: " + this.neutralFactory.getBODY_PARTS_LIST().size());
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
                        System.out.println(Thread.currentThread().getName() + " COUNTRY WON!!!!!");
                        System.out.println(ROBOT_ARMY);
                        needMoreTroops = false;
                        secondCountry.needMoreTroops = false;
                    }
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("First country exception. Sorry :((");
        }
    }
}
