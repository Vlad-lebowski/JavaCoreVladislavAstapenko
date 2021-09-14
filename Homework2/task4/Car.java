package com.company.homeworkTwo;

public class Car {

    private CarLabel carLabel;
    private String color;

    public Car(CarLabel carLabel){
        this.carLabel = carLabel;
        switch (carLabel){
            case AUDI:
                this.color = "Blue";
                break;
            case BMW:
                this.color = "Orange";
                break;
            case KIA:
                this.color = "Yellow";
            default:
                System.out.println("We don't have that car.");
        }
    }

    public void changeColor(String color){
        if (this.carLabel == CarLabel.AUDI){
            switch (color){
                case "Blue":
                    this.color = "Blue";
                    break;
                case "Red":
                    this.color = "Red";
                    break;
                case "Green":
                    this.color = "Green";
                    break;
                default:
                    System.out.println("Sorry, can't do that.");
            }
        }
        if (this.carLabel == CarLabel.BMW){
            switch (color){
                case "Orange":
                    this.color = "Orange";
                    break;
                case "Black":
                    this.color = "Black";
                    break;
                case "Purple":
                    this.color = "Purple";
                    break;
                default:
                    System.out.println("Sorry, can't do that.");
            }
        }
        if (this.carLabel == CarLabel.KIA){
            switch (color){
                case "Yellow":
                    this.color = "Yellow";
                    break;
                case "Gray":
                    this.color = "Gray";
                    break;
                case "White":
                    this.color = "White";
                    break;
                default:
                    System.out.println("Sorry, can't do that.");
            }
        }
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
