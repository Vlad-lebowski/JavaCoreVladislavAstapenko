package com.company.homeworkTwo;

public class Car {

    private CarLabel carLabel;
    private String color;

    public Car(CarLabel carLabel){
        this.carLabel = carLabel;
    }

    public void changeColor(String color){
        for (int i = 0; i < CarColor.values().length; i++){
            if (CarColor.values()[i].getCarLabel() == this.carLabel && CarColor.values()[i].toString().equals(color)){
                this.color = color;
                return;
            }
        }
        System.out.println("We can't do this color.");
    }

    public CarLabel getCarLabel() {
        return carLabel;
    }

    public String getColor() {

        return color;
    }

    public void describeCar(){
        System.out.println("Label is " + carLabel + ". Color is " + color);
    }

}
