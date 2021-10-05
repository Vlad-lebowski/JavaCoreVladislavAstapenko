package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;

public class CarClient {
    private Car car;

    public void buyCar (Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
