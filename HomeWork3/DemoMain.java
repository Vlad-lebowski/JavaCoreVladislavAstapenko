package com.company.homeworkThree;

import java.time.Year;

public class DemoMain {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory(new CarModel[]{CarModel.BMW, CarModel.AUDI}, new EngineVolume[]{EngineVolume.V3, EngineVolume.V5},
                new CarColor[]{CarColor.RED, CarColor.BLACK, CarColor.BLUE},
                new WheelSize[]{WheelSize.SIZE135, WheelSize.SIZE155, WheelSize.SIZE305},
                250);
        carFactory.printPossibleCarModels();
        carFactory.printPossibleEngineVolumes();
        carFactory.printPossibleCarColors();
        carFactory.printPossibleWheelSizes();

        Car newCar = carFactory.createCarForWarehouse(CarModel.BMW, EngineVolume.V5, WheelSize.SIZE305, CarColor.BLACK);//create new car and check
        System.out.println(carFactory.getWarehouse()[5]);                                                               //if it is in the warehouse

        CarDealership carDealership = new CarDealership(100);
        CarService carService = new CarService();

        Car firstOrderCar = carDealership.orderCarFromCarFactory(carFactory, CarModel.BMW, EngineVolume.V5,             //ordered a car that was
                WheelSize.SIZE305, CarColor.BLACK, Year.of(2021));                                                      //in the warehouse

        System.out.println(carDealership.getStock()[0]);                                                                //check if car is in the
                                                                                                                        //stock
        if (carFactory.getWarehouse()[5] == null){
            System.out.println("We sold the car!");
        }

        carDealership.askServiceToChangeCarColor(firstOrderCar, carService, CarColor.PURPLE);
        System.out.println(firstOrderCar.getCarColor());

        carDealership.askServiceToChangeWheelSize(firstOrderCar, carService, WheelSize.SIZE190);
        System.out.println(firstOrderCar.getWheelSize());
    }
}
