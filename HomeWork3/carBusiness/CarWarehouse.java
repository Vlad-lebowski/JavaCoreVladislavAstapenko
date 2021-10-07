package com.company.homeworkThree.carBusiness;

import com.company.homeworkThree.car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarWarehouse {
    private final List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public CarWarehouse() {
        cars = new ArrayList<>();
    }

    public void addCarToWarehouse(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public boolean hasSameCar(Car car) {
        for (Car carSearch : cars) {
            if (carSearch.getCarColor().equals(car.getCarColor()) &&
                    carSearch.getCarModel().equals(car.getCarModel()) &&
                    carSearch.getEngineVolume().equals(car.getEngineVolume()) &&
                    carSearch.getWheelSize().equals(car.getWheelSize()) &&
                    carSearch.getYearOfIssue().equals(car.getYearOfIssue())) {
                return true;
            }
        }
        return false;
    }

    public Car takeSimilarCar(Car car){
        for (Car carSearch : cars) {
            if (carSearch.getCarColor().equals(car.getCarColor()) &&
                    carSearch.getCarModel().equals(car.getCarModel()) &&
                    carSearch.getEngineVolume().equals(car.getEngineVolume()) &&
                    carSearch.getWheelSize().equals(car.getWheelSize()) &&
                    carSearch.getYearOfIssue().equals(car.getYearOfIssue())) {
                Car returnCar = carSearch;
                cars.remove(carSearch);
                return returnCar;
            }
        }
        return null;
    }

    public boolean hasCarWithSimilarUnchangeableProperties(Car car) {
        for (Car carSearch : cars){
            if (carSearch.getCarModel().equals(car.getCarModel()) &&          //check if we have similar car depending on
                    carSearch.getEngineVolume().equals(car.getEngineVolume()) &&     //unchangeable qualities
                    carSearch.getYearOfIssue().equals(car.getYearOfIssue())){
                return true;
            }
        }
        return false;
    }

    public Car takeCarWithSimilarUnchangeableProperties(Car car) {
        for (Car carSearch : cars){
            if (carSearch.getCarModel().equals(car.getCarModel()) &&          //check if we have similar car depending on
                    carSearch.getEngineVolume().equals(car.getEngineVolume()) &&     //unchangeable qualities
                    carSearch.getYearOfIssue().equals(car.getYearOfIssue())){
                Car returnCar = carSearch;
                cars.remove(carSearch);
                return returnCar;
            }
        }
        return null;
    }
}
