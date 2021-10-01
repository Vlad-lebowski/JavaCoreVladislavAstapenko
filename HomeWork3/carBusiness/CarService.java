package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;
import com.company.homeworkThree.carProperties.CarColor;
import com.company.homeworkThree.carProperties.WheelSize;

public class CarService {
    public void changeCarColor (Car car, CarColor carColor){
        car.setCarColor(carColor);
    }

    public void changeWheelSize(Car car, WheelSize wheelSize){
        car.setWheelSize(wheelSize);
    }
}
