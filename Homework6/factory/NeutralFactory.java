package com.company.homeworkSix.factory;

import com.company.homeworkSix.EndOfWarFlag;
import com.company.homeworkSix.robot.RobotBodyParts;

public class NeutralFactory implements Runnable {

    private final Storage storage;
    private int count = 0;
    private final EndOfWarFlag END_OF_WAR;

    public NeutralFactory(Storage storage) {
        this.storage = storage;
        this.END_OF_WAR = new EndOfWarFlag();
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (storage.getBODY_PARTS_LIST()) {
                    if (!END_OF_WAR.checkIfWarIsStillGoing()) {
                        return;
                    }
                    count++;

                    Thread.sleep(5000);
                    storage.getBODY_PARTS_LIST().add(RobotBodyParts.randomPart());
                    System.out.println("Factory produced: " + count);
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("I'm still learning :(");
        }
    }
}
