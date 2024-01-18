package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.dto.request.car.CarNumberRequest;
import com.example.logisticprogram.dto.request.car.CarRequest;
import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.dto.request.driver.DriverRequest;
import com.example.logisticprogram.dto.request.driverstatus.DriverStatusRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.service.domain.CarDomainService;
import com.example.logisticprogram.service.domain.DriverDomainService;
import com.example.logisticprogram.service.domain.DriverStatusDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverDomainService driverDomainService;
    private final CarDomainService carDomainService;
    private final DriverStatusDomainService driverStatusDomainService;


    public List<CarResponse> getCarByNumber(CarNumberRequest numberRequest){
        return carDomainService.getCarByNumber(numberRequest);
    }

    public DriverResponse getDriver(DriverRequest request) {
        return  driverDomainService.getDriverById(request.getId());
    }

    public void deleteDriver(DriverRequest request) {
        driverDomainService.deleteDriver(request.getId());
    }
    public DriverResponse addDriver(DriverAddRequest request){
        var id = driverDomainService.addDriver(request);
        return  driverDomainService.getDriverById(id);
    }

    public List<DriverResponse> getAllDrivers(){
        return driverDomainService.getAllDrivers();
    }

    public DriverResponse editDriver(DriverAddRequest request){
        var id =driverDomainService.editDrivers(request);
        return driverDomainService.getDriverById(id);
    }

    public DriverStatusResponse getDriverStatus(DriverStatusRequest request){
        return driverStatusDomainService.getDriverStatusById(request.getId());
    }

    public List<DriverStatusResponse> getAllDriverStatuses(){
        return driverStatusDomainService.getAllDriverStatus();
    }

    public CarResponse addCar(CarAddRequest request){
        var id = carDomainService.addCar(request);
        return carDomainService.getCarById(id);
    }

    public CarResponse getCar(CarRequest request){
        return carDomainService.getCarById(request.getId());
    }

    public List<CarResponse> getAllCars(){
        return carDomainService.getAllCars();
    }

    public  void deleteCar(CarRequest request){
        carDomainService.deleteCar(request.getId());
    }

    public Long editCar(CarAddRequest request){
        return carDomainService.editCars(request);
    }

}