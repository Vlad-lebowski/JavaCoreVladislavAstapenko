package com.company.homeworkSix.robot;

import java.util.List;
import java.util.Random;

public enum RobotBodyParts {
    LEFT_ARM,
    RIGHT_ARM,
    LEFT_LEG,
    RIGHT_LEG,
    BODY,
    HEAD;

    private static final List<RobotBodyParts> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static RobotBodyParts randomPart() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
