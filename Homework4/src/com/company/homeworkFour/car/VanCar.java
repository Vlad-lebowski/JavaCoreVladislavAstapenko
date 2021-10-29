package com.company.homeworkFour.car;

import com.company.homeworkFour.carProperties.CarModel;
import com.company.homeworkFour.carProperties.EngineVolume;
import com.company.homeworkFour.carProperties.options.Options;

import java.time.Year;

public class VanCar extends Car {

    private int numberOfSeats = 6;

    public VanCar(CarModel carModel, Year yearOfIssue, EngineVolume engineVolume) {
        super(carModel, yearOfIssue, engineVolume);
        this.options = new Options();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats > 4 && numberOfSeats < 12) {
            this.numberOfSeats = numberOfSeats;
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
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
