package com.company.homeworkFive.task9;

import java.io.Serializable;

public class Box implements Serializable {
    private final double height;
    private final double width;
    private final double length;

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", weight=" + width +
                ", length=" + length +
                '}';
    }

    public Box(double height, double weight, double length) {
        this.height = height;
        this.width = weight;
        this.length = length;
    }
}
