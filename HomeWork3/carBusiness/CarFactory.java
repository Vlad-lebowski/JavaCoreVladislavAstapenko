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
    private final List<Car> warehouse = new ArrayList<>();

    public CarFactory(CarModel[] carModels, EngineVolume[] engineVolumes, CarColor[] carColors, WheelSize[] wheelSizes){
        this.carModels = carModels;
        this.engineVolumes = engineVolumes;
        this.carColors = carColors;
        this.wheelSizes = wheelSizes;
        for (int i = 0; i < 5; i++){
            this.warehouse.add(i, new Car(this.carModels[0], Year.now(), this.engineVolumes[0]));
            this.warehouse.get(i).setCarColor(this.carColors[0]);
            this.warehouse.get(i).setWheelSize(this.wheelSizes[0]);
        }
    }

    public Car createCarForWarehouse(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor){
        Car car = new Car(carModel, Year.now(), engineVolume);
        car.setCarColor(carColor);
        car.setWheelSize(wheelSize);
        if (checkIfFactoryCanMakeThisCar(car)){
            warehouse.add(car);
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
        Car newCar = chooseTheSameOrSimilarCarFromWarehouse(car);
        if (newCar != null){
            return newCar;
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

    private Car chooseTheSameOrSimilarCarFromWarehouse (Car car){
        for (Car carSearch : warehouse){
            if (carSearch.getCarColor().equals(car.getCarColor()) &&
                    carSearch.getCarModel().equals(car.getCarModel()) &&
                    carSearch.getEngineVolume().equals(car.getEngineVolume()) &&
                    carSearch.getWheelSize().equals(car.getWheelSize()) &&
                    carSearch.getYearOfIssue().equals(car.getYearOfIssue())){
                warehouse.remove(carSearch);
                return car;
            } else if (carSearch.getCarModel().equals(car.getCarModel()) &&          //check if we have similar car depending on
                    carSearch.getEngineVolume().equals(car.getEngineVolume()) &&     //unchangeable qualities
                    carSearch.getYearOfIssue().equals(car.getYearOfIssue())){
                Car extra = carSearch;
                extra.setCarColor(this.carColors[0]);
                extra.setWheelSize(this.wheelSizes[0]);
                for (CarColor color : this.carColors) {
                    if (color.equals(car.getCarColor())) {
                        extra.setCarColor(color);
                        break;
                    }
                }
                for (WheelSize size : this.wheelSizes) {
                    if (size.equals(car.getWheelSize())) {
                        extra.setWheelSize(size);
                        break;
                    }
                }
                warehouse.remove(carSearch);
                return extra;
            }
        }
        return null;
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

    public List<Car> getWarehouse() {
        return warehouse;
    }
}
