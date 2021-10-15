package com.company.homeworkFive.task10;

import java.io.Serializable;

public class Box implements Serializable, Comparable<Box> {
    private final double height;
    private final double width;
    private final double length;
    private final double volume;

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", weight=" + width +
                ", length=" + length +
                '}';
    }

    public double getVolume() {
        return volume;
    }

    public Box(double height, double weight, double length) {
        this.height = height;
        this.width = weight;
        this.length = length;
        this.volume = this.height * this.width * this.length;
    }

    @Override
    public int compareTo(Box o) {
        return Double.compare(volume, o.volume);
    }
}
