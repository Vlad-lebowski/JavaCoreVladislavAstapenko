package com.company.homeworkFour.carBusiness.carService;

import com.company.homeworkFour.car.Car;
import com.company.homeworkFour.carProperties.WheelSize;

public class CarServiceToChangeWheelSize extends CarService {

    public void changeWheelSize(Car car, WheelSize wheelSize){
        car.setWheelSize(wheelSize);
    }

    public String getName() {
        return super.name;
    }
}
