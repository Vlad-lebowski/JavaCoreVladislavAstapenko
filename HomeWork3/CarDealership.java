package com.company.homeworkThree;

import java.time.Year;

public class CarDealership implements ChangeCarProperties{
    private int dealershipStock;
    private Car[] stock;

    public CarDealership(int dealershipStock){
        this.dealershipStock = dealershipStock;
        this.stock = new Car[dealershipStock];
    }

    public void askServiceToChangeCarColor (Car car, CarService carService, CarColor carColor){
        for (Car value : this.stock) {
            if (value.equals(car)) {
                carService.changeCarColor(car, carColor);
                return;
            }
        }
        System.out.println("This is the car of this dealership!");
    }

    public void askServiceToChangeWheelSize (Car car, CarService carService, WheelSize wheelSize){
        for (Car value : this.stock) {
            if (value.equals(car)) {
                carService.changeWheelSize(car, wheelSize);
                return;
            }
        }
        System.out.println("This is the car of this dealership!");
    }

    public Car orderCarFromCarFactory(CarFactory carFactory, CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year){
        Car car = carFactory.createNewCarForDealership(carModel, engineVolume, wheelSize, carColor, year);
        for (int m = 0; m < stock.length; m++) {
            if (stock[m] == null) {
                stock[m] = car;
                return car;
            } else if (m == stock.length - 1) {
                System.out.println("We got the car, but the stock is full! We need to sell some of them!");
                return car;
            }
        }
        return car;
    }


    public Car[] getStock() {
        return stock;
    }
    public int getDealershipStock() {
        return dealershipStock;
    }
}
