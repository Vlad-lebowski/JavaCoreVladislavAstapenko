package com.company.homeworkSix.factory;

import com.company.homeworkSix.robot.RobotBodyParts;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final List<RobotBodyParts> BODY_PARTS_LIST = new ArrayList<>();

    public List<RobotBodyParts> getBODY_PARTS_LIST() {
        return BODY_PARTS_LIST;
    }
}
