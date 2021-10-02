package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;
import com.company.homeworkThree.carProperties.CarColor;
import com.company.homeworkThree.carProperties.CarModel;
import com.company.homeworkThree.carProperties.EngineVolume;
import com.company.homeworkThree.carProperties.WheelSize;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class CarDealership{
    private List<Car> stock = new ArrayList<>();

    public CarDealership(){
    }

    public void sellCar (Car car){
        for (Car value : this.stock) {
            if (value.equals(car)) {
                this.stock.remove(car);
                return;
            }
        }
        System.out.println("This is the car of this dealership!");
    }

    public Car orderCarFromCarFactory(CarFactory carFactory, CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year){
        Car car = carFactory.createNewCarForDealership(carModel, engineVolume, wheelSize, carColor, year);
        stock.add(car);
        return car;
    }

    public List<Car> getStock() {
        return stock;
    }
}
