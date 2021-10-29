package com.company.homeworkFour.carBusiness.carService;

import com.company.homeworkFour.car.Car;
import com.company.homeworkFour.carProperties.CarColor;
import com.company.homeworkFour.carProperties.WheelSize;
import com.company.homeworkFour.carProperties.options.Optionable;

public abstract class CarService {
    void changeCarColor(Car car, CarColor carColor){
        car.setCarColor(carColor);
    }

    void changeWheelSize(Car car, WheelSize wheelSize){
        car.setWheelSize(wheelSize);
    }

    void addOption(Car car, Optionable option) {
        car.addOption(option);
    }

    void deleteOption(Car car, Optionable option) {
        car.deleteOption(option);
    }
}
