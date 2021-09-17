package com.company.homeworkTwo;

import static com.company.homeworkTwo.CarLabel.*;

public enum CarColor {
    BLUE(AUDI),
    RED(AUDI),
    GREEN(AUDI),
    ORANGE(BMW),
    BLACK(BMW),
    PURPLE(BMW),
    YELLOW(KIA),
    GRAY(KIA),
    WHITE(KIA);

    private CarLabel carLabel;
    public CarLabel getCarLabel(){
        return this.carLabel;
    }
    CarColor (CarLabel carLabel){
        this.carLabel = carLabel;
    }
}
