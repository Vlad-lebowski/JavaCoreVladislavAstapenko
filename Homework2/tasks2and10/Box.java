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
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Box(int x){
        this.x = x;
        this.y = x;
        this.z = x;
    }

    public Box(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void typeOfBox(){
        if(this.x > 0 && this.x == this.y && this.x == this.z){
            System.out.println("The box is a cube.");
        } else if (this.x > 0 && this.y > 0 && this.z > 0 && x != y){
            System.out.println("This is just a regular box.");
        } else if ((this.x > 0 && this.y > 0 && this.z == 0) || (this.x > 0 && this.y == 0 && this.z > 0) ||
                (this.x == 0 && this.y > 0 && this.z > 0)){
            System.out.println("This is an envelope!");
        } else {
            System.out.println("I don't know what the hell this is, but this is definitely not a box!");
        }

    }

    public Box (String box){
        Pattern pattern = Pattern.compile("Box\\[[0-9]*]");
        Matcher matcher = pattern.matcher(box);
        if(matcher.find()){
            Pattern innerPattern = Pattern.compile("([0-9]+)");
            Matcher innerMatcher = innerPattern.matcher(box);
            innerMatcher.find();
            int size = Integer.parseInt(box.substring(innerMatcher.start(), innerMatcher.end()));
            this.x = size;
            this.y = size;
            this.z = size;
        }
        Pattern secondPattern = Pattern.compile("Box\\[[0-9]*,[0-9]*]");
        Matcher secondMatcher = secondPattern.matcher(box);
        if(secondMatcher.find()){
            Pattern innerPattern = Pattern.compile("([0-9]+)");
            Matcher innerMatcher = innerPattern.matcher(box);
            innerMatcher.find();
            int[] twoSizes = new int[2];
            for (int i = 0; i < 2; i++){
                twoSizes[i] = Integer.parseInt(box.substring(innerMatcher.start(), innerMatcher.end()));
            }
            this.x = twoSizes[0];
            this.y = twoSizes[1];
        }
        Pattern thirdPattern = Pattern.compile("Box\\[[0-9]*,[0-9]*,[0-9]*]");
        Matcher thirdMatcher = thirdPattern.matcher(box);
        if(thirdMatcher.find()){
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
        }
    }
}
