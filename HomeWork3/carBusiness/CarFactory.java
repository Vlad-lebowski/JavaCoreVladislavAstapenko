package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;
import com.company.homeworkThree.carProperties.CarColor;
import com.company.homeworkThree.carProperties.CarModel;
import com.company.homeworkThree.carProperties.EngineVolume;
import com.company.homeworkThree.carProperties.WheelSize;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class CarFactory{
    private final List<CarModel> carModels;
    private final List<EngineVolume> engineVolumes;
    private final List<CarColor> carColors;
    private final List<WheelSize> wheelSizes;
    private final CarWarehouse carWarehouse;

    public CarWarehouse getCarWarehouse() {
        return carWarehouse;
    }

    public CarFactory(CarModel[] carModels, EngineVolume[] engineVolumes, CarColor[] carColors, WheelSize[] wheelSizes){
        this.carModels = Arrays.asList(carModels);
        this.engineVolumes = Arrays.asList(engineVolumes);
        this.carColors = Arrays.asList(carColors);
        this.wheelSizes = Arrays.asList(wheelSizes);
        this.carWarehouse = new CarWarehouse();
        for (int i = 0; i < 5; i++){
            Car newCar = new Car(this.carModels.get(0), Year.now(), this.engineVolumes.get(0));
            newCar.setCarColor(this.carColors.get(0));
            newCar.setWheelSize(this.wheelSizes.get(0));
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
            car = new Car(this.carModels.get(0), Year.now(), this.engineVolumes.get(0));
            car.setCarColor(this.carColors.get(0));
            car.setWheelSize(this.wheelSizes.get(0));
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
            car = new Car(this.carModels.get(0), Year.now(), this.engineVolumes.get(0));
            car.setCarColor(this.carColors.get(0));
            car.setWheelSize(this.wheelSizes.get(0));
        }
        return car;
    }

    private boolean checkIfFactoryCanMakeThisCar(Car car){ //check if we can make this car
        return this.carColors.contains(car.getCarColor()) &&
                this.wheelSizes.contains(car.getWheelSize()) &&
                this.engineVolumes.contains(car.getEngineVolume()) &&
                this.carModels.contains(car.getCarModel());
    }

    public void printPossibleCarModels(){
        System.out.println(this.carModels);
    }
    public void printPossibleEngineVolumes(){
        System.out.println(this.engineVolumes);
    }
    public void printPossibleCarColors(){
        System.out.println(this.carColors);
    }
    public void printPossibleWheelSizes(){
        System.out.println(this.wheelSizes);
    }


    public List<WheelSize> getWheelSizes() {
        return wheelSizes;
    }

    public List<CarColor> getCarColors() {
        return carColors;
    }

    public List<EngineVolume> getEngineVolumes() {
        return engineVolumes;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }
}
