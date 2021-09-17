package com.company.homeworkTwo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Box {

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Box(int x, int y, int z){
        if (x > 0 && y > 0 && z > 0){
            this.x = x;
            this.y = y;
            this.z = z;
            if (x == y && x == z){
                System.out.println("The box is a cube.");
            } else {
                System.out.println("This is just a regular box.");
            }
        } else {
            System.out.println("What are you, some kind of a joker?");
        }
    }

    public Box(int x){
        if (x > 0) {
            this.x = x;
            this.y = x;
            this.z = x;
            System.out.println("The box is a cube.");
        } else {
            System.out.println("Yes, very funny.");
        }
    }

    public Box(int x, int y){
        if (x > 0 && y > 0){
            this.x = x;
            this.y = y;
            System.out.println("This is an envelope!");
        } else {
            System.out.println("Stop it, alright?");
        }
    }

    public
    Box (String box){
        Pattern pattern = Pattern.compile("Box\\[[0-9]*]");
        Matcher matcher = pattern.matcher(box);
        Pattern secondPattern = Pattern.compile("Box\\[[0-9]*,[0-9]*]");
        Matcher secondMatcher = secondPattern.matcher(box);
        Pattern thirdPattern = Pattern.compile("Box\\[[0-9]*,[0-9]*,[0-9]*]");
        Matcher thirdMatcher = thirdPattern.matcher(box);
        if(matcher.find()){
            Pattern innerPattern = Pattern.compile("([0-9]+)");
            Matcher innerMatcher = innerPattern.matcher(box);
            innerMatcher.find();
            int size = Integer.parseInt(box.substring(innerMatcher.start(), innerMatcher.end()));
            this.x = size;
            this.y = size;
            this.z = size;
            System.out.println("The box is a cube.");
        } else if(secondMatcher.find()){
            Pattern innerPattern = Pattern.compile("([0-9]+)");
            Matcher innerMatcher = innerPattern.matcher(box);
            innerMatcher.find();
            int[] twoSizes = new int[2];
            for (int i = 0; i < 2; i++){
                twoSizes[i] = Integer.parseInt(box.substring(innerMatcher.start(), innerMatcher.end()));
            }
            this.x = twoSizes[0];
            this.y = twoSizes[1];
            System.out.println("This is an envelope!");
        } else if(thirdMatcher.find()){
            Pattern innerPattern = Pattern.compile("([0-9]+)");
            Matcher innerMatcher = innerPattern.matcher(box);
            int[] threeSizes = new int[3];
            for (int i = 0; i < 3; i++){
                innerMatcher.find();
                threeSizes[i] = Integer.parseInt(box.substring(innerMatcher.start(), innerMatcher.end()));
            }
            this.x = threeSizes[0];
            this.y = threeSizes[1];
            this.z = threeSizes[2];
            if (this.x == this.y && this.x == this.z){
                System.out.println("The box is a cube.");
            } else {
                System.out.println("This is just a regular box.");
            }
        } else {
            System.out.println("There can't be such box!");
        }
    }
}
