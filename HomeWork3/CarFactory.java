package com.company.homeworkThree;

import java.time.Year;
import java.util.Arrays;

public class CarFactory implements ChangeCarProperties{
    private CarModel[] carModels;
    private EngineVolume[] engineVolumes;
    private CarColor[] carColors;
    private WheelSize[] wheelSizes;
    private int wareHouseSize;
    private Car[] warehouse;

    public CarFactory(CarModel[] carModels, EngineVolume[] engineVolumes, CarColor[] carColors, WheelSize[] wheelSizes, int wareHouseSize){
        this.carModels = carModels;
        this.engineVolumes = engineVolumes;
        this.carColors = carColors;
        this.wheelSizes = wheelSizes;
        this.wareHouseSize = wareHouseSize;
        this.warehouse = new Car[wareHouseSize];
        for (int i = 0; i < 5; i++){
            this.warehouse[i] = new Car(this.carModels[0], Year.now(), this.engineVolumes[0]);
            this.warehouse[i].setCarColor(this.carColors[0]);
            this.warehouse[i].setWheelSize(this.wheelSizes[0]);
        }
    }

    public Car createCarForWarehouse(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor){
        for (CarModel model : this.carModels) { //check if we can make this car
            if (model.equals(carModel)) {
                for (EngineVolume volume : this.engineVolumes) {
                    if (volume.equals(engineVolume)) {
                        for (WheelSize size : this.wheelSizes) {
                            if (size.equals(wheelSize)) {
                                for (CarColor color : this.carColors) {
                                    if (color.equals(carColor)) {
                                        Car car = new Car(carModel, Year.now(), engineVolume);
                                        car.setCarColor(carColor);
                                        car.setWheelSize(wheelSize);
                                        for (int m = 0; m < warehouse.length; m++) { //put new car in the warehouse
                                            if (warehouse[m] == null) {
                                                warehouse[m] = car;
                                                return car;
                                            } else if (m == warehouse.length - 1) {
                                                System.out.println("We made the car, but the warehouse is full!");
                                                return car;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Look, we can't do that, but here's some basic car!");
        Car car = new Car(this.carModels[0], Year.now(), this.engineVolumes[0]);
        car.setCarColor(this.carColors[0]);
        car.setWheelSize(this.wheelSizes[0]);
        return car;
    }

    public Car createNewCarForDealership(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year){
        Car car;
        for (int i = 0; i < this.warehouse.length; i++) {                   //go to warehouse
            if (warehouse[i].getCarColor().equals(carColor) && //see if we have the exact same car in the warehouse
                    warehouse[i].getCarModel().equals(carModel) &&
                    warehouse[i].getEngineVolume().equals(engineVolume) &&
                    warehouse[i].getWheelSize().equals(wheelSize) &&
                    warehouse[i].getYearOfIssue().equals(year)) {
                car = warehouse[i];
                warehouse[i] = null;                           //we sold the car
                return car;
            } else if (warehouse[i].getCarModel().equals(carModel) &&          //check if we have similar car depending on
                    warehouse[i].getEngineVolume().equals(engineVolume) &&     //unchangeable qualities
                    warehouse[i].getYearOfIssue().equals(year)){
                car = warehouse[i];
                for (CarColor color : this.carColors) {
                    if (color.equals(carColor)) {
                        car.setCarColor(carColor);
                        break;
                    }
                }
                for (WheelSize size : this.wheelSizes) {
                    if (size.equals(wheelSize)) {
                        car.setWheelSize(wheelSize);
                        break;
                    }
                }
                warehouse[i] = null;                           //we sold the car
                return car;
            }
        }
        for (CarModel model : this.carModels) { //see if we can make a new car with this specs
            if (model.equals(carModel)) {
                for (EngineVolume volume : this.engineVolumes) {
                    if (volume.equals(engineVolume)) {
                        for (WheelSize size : this.wheelSizes) {
                            if (size.equals(wheelSize)) {
                                for (CarColor color : this.carColors) {
                                    if (color.equals(carColor)) {
                                        car = new Car(carModel, Year.now(), engineVolume);
                                        car.setCarColor(carColor);
                                        car.setWheelSize(wheelSize);
                                        return car;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Look, this factory don't make such cars, but here's some basic car!");
        car = new Car(this.carModels[0], Year.now(), this.engineVolumes[0]);
        car.setCarColor(this.carColors[0]);
        car.setWheelSize(this.wheelSizes[0]);
        return car;
    }

    public void askServiceToChangeCarColor (Car car, CarService carService, CarColor carColor){
        for (Car value : this.warehouse) {
            if (value.equals(car)) {
                carService.changeCarColor(car, carColor);
                return;
            }
        }
        System.out.println("This is the car of this factory!");
    }

    public void askServiceToChangeWheelSize (Car car, CarService carService, WheelSize wheelSize){
        for (Car value : this.warehouse) {
            if (value.equals(car)) {
                carService.changeWheelSize(car, wheelSize);
                return;
            }
        }
        System.out.println("This is the car of this factory!");
    }

    public void printPossibleCarModels(){
        System.out.println(Arrays.toString(this.carModels));
    }
    public void printPossibleEngineVolumes(){
        System.out.println(Arrays.toString(this.engineVolumes));
    }
    public void printPossibleCarColors(){
        System.out.println(Arrays.toString(this.carColors));
    }
    public void printPossibleWheelSizes(){
        System.out.println(Arrays.toString(this.wheelSizes));
    }

    public Car[] getWarehouse() {
        return warehouse;
    }

    public int getWareHouseSize() {
        return wareHouseSize;
    }

    public WheelSize[] getWheelSizes() {
        return wheelSizes;
    }

    public CarColor[] getCarColors() {
        return carColors;
    }

    public EngineVolume[] getEngineVolumes() {
        return engineVolumes;
    }

    public CarModel[] getCarModels() {
        return carModels;
    }
}
