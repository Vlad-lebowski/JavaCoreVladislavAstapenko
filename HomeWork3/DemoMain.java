package com.company.homeworkThree;

import com.company.homeworkThree.car.Car;
import com.company.homeworkThree.carBusiness.*;
import com.company.homeworkThree.carProperties.CarColor;
import com.company.homeworkThree.carProperties.CarModel;
import com.company.homeworkThree.carProperties.EngineVolume;
import com.company.homeworkThree.carProperties.WheelSize;

import java.time.Year;

public class DemoMain {
    public static void main(String[] args) {
        CarWarehouse carWarehouse = new CarWarehouse();
        CarWarehouse carWarehouse1 = new CarWarehouse();

        CarFactory carFactory = new CarFactory(new CarModel[]{CarModel.BMW, CarModel.AUDI}, new EngineVolume[]{EngineVolume.V3, EngineVolume.V5},
                new CarColor[]{CarColor.RED, CarColor.BLACK, CarColor.BLUE},
                new WheelSize[]{WheelSize.SIZE135, WheelSize.SIZE155, WheelSize.SIZE305}, carWarehouse);
        carFactory.printPossibleCarModels();
        carFactory.printPossibleEngineVolumes();
        carFactory.printPossibleCarColors();
        carFactory.printPossibleWheelSizes();

        Car newCar = carFactory.createCarForWarehouse(CarModel.BMW, EngineVolume.V5, WheelSize.SIZE305, CarColor.BLACK);

        CarDealership carDealership = new CarDealership(carWarehouse1);
        CarService carService = new CarService();
        CarClient carClient = new CarClient();

        Car firstOrderCar = carDealership.orderCarFromCarFactory(carFactory, CarModel.BMW, EngineVolume.V5,             //ordered a car that was
                WheelSize.SIZE305, CarColor.BLACK, Year.of(2021));                                                      //in the warehouse


        carService.changeCarColor(firstOrderCar, CarColor.PURPLE);
        carService.changeWheelSize(firstOrderCar, WheelSize.SIZE190);

        System.out.println(carDealership.getStock());
        carDealership.sellCar(firstOrderCar, carClient);
        System.out.println(carDealership.getStock());
        System.out.println(carClient.getCar());
    }
}
