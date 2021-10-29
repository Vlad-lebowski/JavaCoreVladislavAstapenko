package com.company.homeworkFour.car;

import com.company.homeworkFour.carProperties.CarModel;
import com.company.homeworkFour.carProperties.EngineVolume;
import com.company.homeworkFour.carProperties.options.Options;
import com.company.homeworkFour.carProperties.TypeOfDrive;

import java.time.Year;

public class PassengerCar extends Car {

    private TypeOfDrive typeOfDrive = TypeOfDrive.TWO_WHEEL_DRIVE;

    public PassengerCar(CarModel carModel, Year yearOfIssue, EngineVolume engineVolume) {
        super(carModel, yearOfIssue, engineVolume);
        this.options = new Options();
    }

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(TypeOfDrive typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
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
                ", typeOfDrive=" + typeOfDrive +
                '}';
    }
}
