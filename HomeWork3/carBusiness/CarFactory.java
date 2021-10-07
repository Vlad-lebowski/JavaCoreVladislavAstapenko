package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;
import com.company.homeworkThree.carProperties.CarColor;
import com.company.homeworkThree.carProperties.CarModel;
import com.company.homeworkThree.carProperties.EngineVolume;
import com.company.homeworkThree.carProperties.WheelSize;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory{
    private final CarModel[] carModels;
    private final EngineVolume[] engineVolumes;
    private final CarColor[] carColors;
    private final WheelSize[] wheelSizes;
    private final CarWarehouse carWarehouse;

    public CarWarehouse getCarWarehouse() {
        return carWarehouse;
    }

    public CarFactory(CarModel[] carModels, EngineVolume[] engineVolumes, CarColor[] carColors, WheelSize[] wheelSizes){
        this.carModels = carModels;
        this.engineVolumes = engineVolumes;
        this.carColors = carColors;
        this.wheelSizes = wheelSizes;
        this.carWarehouse = new CarWarehouse();
        for (int i = 0; i < 5; i++){
            Car newCar = new Car(this.carModels[0], Year.now(), this.engineVolumes[0]);
            newCar.setCarColor(this.carColors[0]);
            newCar.setWheelSize(this.wheelSizes[0]);
            this.carWarehouse.addCarToWarehouse(newCar);
        }
    }

    public Car createCarForWarehouse(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor){
        Car car = new Car(carModel, Year.now(), engineVolume);
        car.setCarColor(carColor);
        car.setWheelSize(wheelSize);
        if (checkIfFactoryCanMakeThisCar(car)){
            this.carWarehouse.addCarToWarehouse(car);
        } else {
            System.out.println("Look, we can't do that, but here's some basic car!");
            car = new Car(this.carModels[0], Year.now(), this.engineVolumes[0]);
            car.setCarColor(this.carColors[0]);
            car.setWheelSize(this.wheelSizes[0]);
        }
        return car;
    }

    public Car createNewCarForDealership(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year){
        Car car = new Car(carModel, year, engineVolume);
        car.setCarColor(carColor);
        car.setWheelSize(wheelSize);
        if (carWarehouse.hasSameCar(car)){
            return carWarehouse.takeSimilarCar(car);
        }
        if (carWarehouse.hasCarWithSimilarUnchangeableProperties(car)){
            car = carWarehouse.takeCarWithSimilarUnchangeableProperties(car);
            for (CarColor color : carColors){
                if (color.equals(carColor)){
                    car.setCarColor(carColor);
                }
            }
            for (WheelSize size : wheelSizes){
                if (size.equals(wheelSize)){
                    car.setWheelSize(wheelSize);
                }
            }
            return car;
        }
        if (!checkIfFactoryCanMakeThisCar(car)) {
            System.out.println("Look, this factory don't make such cars, but here's some basic car!");
            car = new Car(this.carModels[0], Year.now(), this.engineVolumes[0]);
            car.setCarColor(this.carColors[0]);
            car.setWheelSize(this.wheelSizes[0]);
        }
        return car;
    }

    private boolean checkIfFactoryCanMakeThisCar(Car car){ //check if we can make this car
        for (CarModel model : this.carModels) {
            if (model.equals(car.getCarModel())) {
                for (EngineVolume volume : this.engineVolumes) {
                    if (volume.equals(car.getEngineVolume())) {
                        for (WheelSize size : this.wheelSizes) {
                            if (size.equals(car.getWheelSize())) {
                                for (CarColor color : this.carColors) {
                                    if (color.equals(car.getCarColor())) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void printPossibleCarModels(){
        System.out.println(Arrays.toString(this.carModels));
    }
    public void printPossibleEngineVolumes(){
        System.out.println(Arrays.toString(this.engineVolumes));
    }
    public void printPossibleCarColors(){
        System.out.println(Arrays.toString(this.carColors));
    }
    public void printPossibleWheelSizes(){
        System.out.println(Arrays.toString(this.wheelSizes));
    }


    public WheelSize[] getWheelSizes() {
        return wheelSizes;
    }

    public CarColor[] getCarColors() {
        return carColors;
    }

    public EngineVolume[] getEngineVolumes() {
        return engineVolumes;
    }

    public CarModel[] getCarModels() {
        return carModels;
    }
}
