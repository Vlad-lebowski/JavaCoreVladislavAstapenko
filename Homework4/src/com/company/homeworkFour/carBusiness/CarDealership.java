package com.company.homeworkFour.carBusiness;

import com.company.homeworkFour.car.Car;
import com.company.homeworkFour.carBusiness.carService.CarServiceToAddAndDeleteOptions;
import com.company.homeworkFour.carBusiness.carService.CarServiceToChangeColor;
import com.company.homeworkFour.carBusiness.carService.CarServiceToChangeWheelSize;
import com.company.homeworkFour.carProperties.CarColor;
import com.company.homeworkFour.carProperties.CarModel;
import com.company.homeworkFour.carProperties.EngineVolume;
import com.company.homeworkFour.carProperties.WheelSize;
import com.company.homeworkFour.carProperties.options.Optionable;

import java.lang.reflect.InvocationTargetException;
import java.time.Year;

public class CarDealership {

    public CarDealership(){
    }

    public <T extends Car> T orderCarFromCarFactory(CarFactory<T> carFactory, CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return carFactory.createNewCarForDealership(carModel, engineVolume, wheelSize, carColor, year);
    }

    public void changeColor (Car car, CarColor color, CarServiceToChangeColor carService) {
        carService.changeCarColor(car, color);
    }

    public void changeWheels (Car car, WheelSize wheelSize, CarServiceToChangeWheelSize carService) {
        carService.changeWheelSize(car, wheelSize);
    }

    public void addOption(Car car, Optionable option, CarServiceToAddAndDeleteOptions carService) {
        carService.addOption(car, option);
    }

    public void deleteOption(Car car, Optionable option, CarServiceToAddAndDeleteOptions carService) {
        carService.deleteOption(car, option);
    }

}
