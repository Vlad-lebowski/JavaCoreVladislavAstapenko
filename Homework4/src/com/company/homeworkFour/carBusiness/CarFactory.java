package com.company.homeworkFour.carBusiness;

import com.company.homeworkFour.car.Car;
import com.company.homeworkFour.carProperties.CarColor;
import com.company.homeworkFour.carProperties.CarModel;
import com.company.homeworkFour.carProperties.EngineVolume;
import com.company.homeworkFour.carProperties.WheelSize;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class CarFactory<T extends Car>  {
    private final List<CarModel> carModels;
    private final List<EngineVolume> engineVolumes;
    private final List<CarColor> carColors;
    private final List<WheelSize> wheelSizes;
    private final CarWarehouse<T> carWarehouse;
    private final Class<T> tClass;
    private final Constructor<?> constructor;

    public CarWarehouse<T> getCarWarehouse() {
        return carWarehouse;
    }

    public CarFactory(CarModel[] carModels, EngineVolume[] engineVolumes, CarColor[] carColors, WheelSize[] wheelSizes, Class<T> tClass) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        this.carModels = Arrays.asList(carModels);
        this.engineVolumes = Arrays.asList(engineVolumes);
        this.carColors = Arrays.asList(carColors);
        this.wheelSizes = Arrays.asList(wheelSizes);
        this.carWarehouse = new CarWarehouse<>();
        this.tClass = tClass;
        constructor = tClass.getConstructor(CarModel.class, Year.class, EngineVolume.class);
        for (int i = 0; i < 5; i++){
            T newCar = tClass.cast(constructor.newInstance(this.carModels.get(0), Year.now(), this.engineVolumes.get(0)));
            newCar.setCarColor(this.carColors.get(0));
            newCar.setWheelSize(this.wheelSizes.get(0));
            this.carWarehouse.addCarToWarehouse(newCar);
        }
    }

    public T createCarForWarehouse(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        T car = tClass.cast(constructor.newInstance(carModel, Year.now(), engineVolume));
        car.setCarColor(carColor);
        car.setWheelSize(wheelSize);
        if (checkIfFactoryCanMakeThisCar(car)) {
            System.out.println("Look, we can't do that, but here's some basic car!");
            car = tClass.cast(constructor.newInstance(this.carModels.get(0), Year.now(), this.engineVolumes.get(0)));
            car.setCarColor(this.carColors.get(0));
            car.setWheelSize(this.wheelSizes.get(0));
        }
        this.carWarehouse.addCarToWarehouse(car);
        return tClass.cast(car);
    }

    public T createNewCarForDealership(CarModel carModel, EngineVolume engineVolume, WheelSize wheelSize, CarColor carColor, Year year) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        T car = tClass.cast(constructor.newInstance(carModel, year, engineVolume));
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
        if (checkIfFactoryCanMakeThisCar(car)) {
            System.out.println("Look, this factory don't make such cars, but here's some basic car!");
            car = tClass.cast(constructor.newInstance(this.carModels.get(0), Year.now(), this.engineVolumes.get(0)));
            car.setCarColor(this.carColors.get(0));
            car.setWheelSize(this.wheelSizes.get(0));
        }
        return car;
    }

    private boolean checkIfFactoryCanMakeThisCar(Car car){ //check if we can make this car
        return !this.carColors.contains(car.getCarColor()) ||
                !this.wheelSizes.contains(car.getWheelSize()) ||
                !this.engineVolumes.contains(car.getEngineVolume()) ||
                !this.carModels.contains(car.getCarModel());
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
