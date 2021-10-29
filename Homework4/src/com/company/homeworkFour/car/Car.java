package com.company.homeworkFour.car;

import com.company.homeworkFour.carProperties.*;
import com.company.homeworkFour.carProperties.options.Optionable;
import com.company.homeworkFour.carProperties.options.Options;

import java.time.Year;

public abstract class Car {
    private CarColor carColor;
    private final CarModel carModel;
    private final Year yearOfIssue;
    private WheelSize wheelSize;
    private final EngineVolume engineVolume;
    protected Options options;

    public Options getOptions() {
        return options;
    }

    public Car(CarModel carModel, Year yearOfIssue, EngineVolume engineVolume){
        this.carModel = carModel;
        this.yearOfIssue = yearOfIssue;
        this.engineVolume = engineVolume;
        this.options = new Options();
    }

    public CarColor getCarColor(){
        return this.carColor;
    }

    public void setCarColor(CarColor carColor){
        this.carColor = carColor;
    }

    public EngineVolume getEngineVolume() {
        return engineVolume;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public Year getYearOfIssue() {
        return yearOfIssue;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carColor=" + carColor +
                ", carModel=" + carModel +
                ", yearOfIssue=" + yearOfIssue +
                ", wheelSize=" + wheelSize +
                ", engineVolume=" + engineVolume +
                ", options=" + options.getOptionList() +
                '}';
    }

    public void addOption(Optionable option) {
        this.options.addOption(option);
    }

    public void deleteOption(Optionable option) {
        this.options.deleteOptions(option);
    }
}
