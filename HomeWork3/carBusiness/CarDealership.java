package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;
import com.company.homeworkThree.carProperties.CarColor;
import com.company.homeworkThree.carProperties.CarModel;
import com.company.homeworkThree.carProperties.EngineVolume;
import com.company.homeworkThree.carProperties.WheelSize;

import java.time.Year;

public class CarDealership{
    private final CarWarehouse carWarehouse;

    public CarDealership(CarWarehouse carWarehouse){
        this.carWarehouse = carWarehouse;
    }

    public void sellCar (Car car, CarClient carClient){
        if (this.carWarehouse.hasSameCar(car)){
            carClient.buyCar(this.carWarehouse.takeSimilarCar(car));
        }
    }

    public Car orderCarFromCarFactory(CarFactory carFactory, CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year){
        Car car = carFactory.createNewCarForDealership(carModel, engineVolume, wheelSize, carColor, year);
        carWarehouse.addCarToWarehouse(car);
        return car;
    }
}
