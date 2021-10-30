package com.company.homeworkSix;

public class EndOfWarFlag {
    private boolean isWarStillGoing = true;

    public void endWar() {
        this.isWarStillGoing = false;
    }

    public boolean checkIfWarIsStillGoing() {
        return this.isWarStillGoing;
    }
}
