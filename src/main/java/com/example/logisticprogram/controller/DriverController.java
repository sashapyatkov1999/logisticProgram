package com.example.logisticprogram.controller;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.dto.request.car.CarNumberRequest;
import com.example.logisticprogram.dto.request.car.CarRequest;
import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.dto.request.driver.DriverFindByNameRequest;
import com.example.logisticprogram.dto.request.driver.DriverRequest;
import com.example.logisticprogram.dto.request.driverstatus.DriverStatusRequest;
import com.example.logisticprogram.dto.request.user.UserRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final DriverService service;
    public static final String CAR_GET_BY_NUMBER = "/api/v1/car/find-by-number";//работает
    public static final String CAR_DELETE = "/api/v1/car/delete";//еще не попробовал
    public static final String DRIVER_GET = "/api/v1/driver/get";//работает
    public static final String DRIVER_DELETE = "/api/v1/driver/delete";
    public static final String DRIVER_ADD = "/api/v1/driver/add";
    public static final String DRIVER_GET_ALL = "/api/v1/driver/get-all";//работает
    public static final String DRIVER_EDIT = "/api/v1/driver/edit";//ошибки
    public static final String DRIVER_STATUS_GET = "/api/v1/driver-status/get";
    public static final String DRIVER_STATUS_GET_ALL = "/api/v1/driver-status/get-all";
    public static final String CAR_ADD = "/api/v1/car/add";
    public static final String CAR_GET = "/api/v1/car/get";
    public static final String CAR_GET_ALL = "/api/v1/car/get-all";
    public static final String CAR_EDIT = "/api/v1/car/edit";
    private static final String USER_IS_DRIVER = "/api/v1/user/user-is-driver";
    private static final String CAR_GET_BY_DRIVER = "/api/v1/car/get-by-driver";


    @PostMapping(
            value = CAR_GET_BY_NUMBER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<CarResponse> findByNumber(@RequestBody CarNumberRequest request){
        return service.getCarByNumber(request);
    }

    @PostMapping(
            value = DRIVER_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public DriverResponse getDriver(@RequestBody DriverRequest request){
        return service.getDriver(request);
    }

    @PostMapping(
            value = DRIVER_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteDriver(@RequestBody DriverRequest request){
        service.deleteDriver(request);
    }
    @PostMapping(
            value = USER_IS_DRIVER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public DriverResponse isUserDriver(@RequestBody UserRequest request){
        return service.isUserDriver(request);
    }
    @PostMapping(
            value = DRIVER_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public DriverResponse addDriver(@RequestBody DriverAddRequest request){
        return    service.addDriver(request);
    }

    @PostMapping(
            value = DRIVER_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<DriverResponse> getAllDrivers(){
        return service.getAllDrivers();
    }

    @PostMapping(
            value = DRIVER_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public DriverResponse editDriver(@RequestBody DriverAddRequest request){
        return service.editDriver(request);
    }

    @PostMapping(
            value = DRIVER_STATUS_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public DriverStatusResponse getDriverStatus(@RequestBody DriverStatusRequest request){
        return service.getDriverStatus(request);
    }

    @PostMapping(
            value = CAR_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<CarResponse> getAllCars(){
        return service.getAllCars();
    }

    @PostMapping(
            value = CAR_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public CarResponse carAdd(@RequestBody CarAddRequest request){
        return  service.addCar(request);
    }

    @PostMapping(
            value = DRIVER_STATUS_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<DriverStatusResponse> getAllDriverStatuses(){
        return service.getAllDriverStatuses();
    }

    @PostMapping(
            value = CAR_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public CarResponse getCar(@RequestBody CarRequest request){
        return service.getCar(request);
    }

    @PostMapping(
            value = CAR_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public Long editCar(@RequestBody CarAddRequest request){
        return service.editCar(request);
    }
    @PostMapping(
            value = CAR_GET_BY_DRIVER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<CarResponse> getCarByDriver(@RequestBody DriverFindByNameRequest request){
        return service.getCarByDriver(request);
    }
    @PostMapping(
            value = CAR_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void  deleteCar(@RequestBody CarRequest request){
        service.deleteCar(request);
    }
}

