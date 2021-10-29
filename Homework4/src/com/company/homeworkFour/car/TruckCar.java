package com.company.homeworkFour.car;

import com.company.homeworkFour.carProperties.CarModel;
import com.company.homeworkFour.carProperties.EngineVolume;
import com.company.homeworkFour.carProperties.options.Options;

import java.time.Year;

public class TruckCar extends Car {

    private int numberOfAxles = 4;

    public TruckCar(CarModel carModel, Year yearOfIssue, EngineVolume engineVolume) {
        super(carModel, yearOfIssue, engineVolume);
        this.options = new Options();
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        if (numberOfAxles > 1 && numberOfAxles < 6) {
            this.numberOfAxles = numberOfAxles;
        }
    }

    @Override
    public String toString() {
        return "TruckCar{" +
                "carColor=" + super.getCarColor() +
                ", carModel=" + super.getCarModel() +
                ", yearOfIssue=" + super.getYearOfIssue() +
                ", wheelSize=" + super.getWheelSize() +
                ", engineVolume=" + super.getEngineVolume() +
                ", options=" + options.getOptionList() +
                ", numberOfAxles=" + numberOfAxles +
                '}';
    }
}
