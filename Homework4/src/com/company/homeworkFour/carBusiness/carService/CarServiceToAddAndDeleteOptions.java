package com.company.homeworkFour.carBusiness.carService;

import com.company.homeworkFour.car.Car;
import com.company.homeworkFour.carProperties.options.Optionable;

public class CarServiceToAddAndDeleteOptions extends CarService {

    public void addOption(Car car, Optionable option) {
        car.addOption(option);
    }

    public void deleteOption(Car car, Optionable option) {
        car.deleteOption(option);
    }

    public String getName() {
        return super.name;
    }
}
