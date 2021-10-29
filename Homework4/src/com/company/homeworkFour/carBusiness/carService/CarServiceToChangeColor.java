package com.company.homeworkFour.carBusiness.carService;

import com.company.homeworkFour.car.Car;
import com.company.homeworkFour.carProperties.CarColor;

public class CarServiceToChangeColor extends CarService {

    public void changeCarColor(Car car, CarColor carColor){
        car.setCarColor(carColor);
    }

    public String getName() {
        return super.name;
    }
}
