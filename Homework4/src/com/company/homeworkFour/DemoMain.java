package com.company.homeworkFour;

import com.company.homeworkFour.car.PassengerCar;
import com.company.homeworkFour.car.TruckCar;
import com.company.homeworkFour.car.VanCar;
import com.company.homeworkFour.carBusiness.CarDealership;
import com.company.homeworkFour.carBusiness.CarFactory;
import com.company.homeworkFour.carBusiness.carService.CarServiceToAddAndDeleteOptions;
import com.company.homeworkFour.carBusiness.carService.CarServiceToChangeColor;
import com.company.homeworkFour.carBusiness.carService.CarServiceToChangeWheelSize;
import com.company.homeworkFour.carProperties.CarColor;
import com.company.homeworkFour.carProperties.CarModel;
import com.company.homeworkFour.carProperties.EngineVolume;
import com.company.homeworkFour.carProperties.WheelSize;
import com.company.homeworkFour.carProperties.options.Navigator;

import java.lang.reflect.InvocationTargetException;
import java.time.Year;

public class DemoMain {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        CarFactory<PassengerCar> carFactory1 = new CarFactory<>(new CarModel[]{CarModel.BMW}, new EngineVolume[]{EngineVolume.V3, EngineVolume.V5},
                new CarColor[]{CarColor.RED, CarColor.BLACK, CarColor.BLUE},
                new WheelSize[]{WheelSize.SIZE135, WheelSize.SIZE155, WheelSize.SIZE305}, PassengerCar.class);

        CarFactory<TruckCar> carFactory2 = new CarFactory<>(new CarModel[]{CarModel.CHEVROLET}, new EngineVolume[]{EngineVolume.V4, EngineVolume.V6},
                new CarColor[]{CarColor.GRAY, CarColor.GREEN, CarColor.RED},
                new WheelSize[]{WheelSize.SIZE235, WheelSize.SIZE145, WheelSize.SIZE315}, TruckCar.class);

        CarFactory<VanCar> carFactory3 = new CarFactory<>(new CarModel[]{CarModel.FERRARI}, new EngineVolume[]{EngineVolume.V8, EngineVolume.V9},
                new CarColor[]{CarColor.YELLOW, CarColor.PURPLE, CarColor.ORANGE},
                new WheelSize[]{WheelSize.SIZE365, WheelSize.SIZE345, WheelSize.SIZE200}, VanCar.class);

        CarServiceToAddAndDeleteOptions service1 = new CarServiceToAddAndDeleteOptions();
        CarServiceToChangeWheelSize service2 = new CarServiceToChangeWheelSize();
        CarServiceToChangeColor service3 = new CarServiceToChangeColor();

        CarDealership carDealership = new CarDealership();

        PassengerCar car1 = carDealership.orderCarFromCarFactory(carFactory1, CarModel.BMW, EngineVolume.V3, WheelSize.SIZE135, CarColor.BLACK, Year.now());
        System.out.println(car1);
        service1.addOption(car1, new Navigator());
        car1.getOptions().getOptionList().get(0).activateOption(); // LOL! That looks bad!
        System.out.println(car1);
        service1.deleteOption(car1, car1.getOptions().getOptionList().get(0));
        System.out.println(car1);













//        carFactory.printPossibleCarModels();
//        carFactory.printPossibleEngineVolumes();
//        carFactory.printPossibleCarColors();
//        carFactory.printPossibleWheelSizes();
//
//        Car newCar = carFactory.createCarForWarehouse(CarModel.BMW, EngineVolume.V5, WheelSize.SIZE305, CarColor.BLACK);
//
//        CarDealership carDealership = new CarDealership();
//        CarServiceToChangeColor carService = new CarServiceToChangeColor();
//        CarServiceToChangeWheelSize carService2 = new CarServiceToChangeWheelSize();
//        System.out.println(carFactory.getCarWarehouse().getCars());
//
//        Car firstOrderCar = carDealership.orderCarFromCarFactory(carFactory, CarModel.BMW, EngineVolume.V5,             //ordered a car that was
//                WheelSize.SIZE305, CarColor.BLACK, Year.of(2021));                                                      //in the warehouse
//
//
//        System.out.println(carFactory.getCarWarehouse().getCars());
//
//        carService.changeCarColor(firstOrderCar, CarColor.PURPLE);
//        carService2.changeWheelSize(firstOrderCar, WheelSize.SIZE190);
//
//
//        CarColor[] carColors = {CarColor.WHITE, CarColor.BLUE, CarColor.BLACK};
//        List<CarColor> carColorList = Arrays.asList(carColors);
//        if (carColorList.contains(CarColor.WHITE)){
//            System.out.println(true);
//        }
    }
}
