package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.dto.request.car.CarNumberRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.mapper.car.CarMapper;
import com.example.logisticprogram.mapper.car.CarMerger;
import com.example.logisticprogram.mapper.car.CarResponseMapper;
import com.example.logisticprogram.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CarDomainServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private CarMerger carMerger;
    @Mock
    private CarResponseMapper carResponseMapper;
    @Mock
    private CarMapper carMapper;
    @InjectMocks
    private CarDomainService service;

    private final CarResponse carResponse = new CarResponse();

    private final CarAddRequest carAddRequestAdd = new CarAddRequest();
    private final List<Car> cars = new ArrayList<>();
    private final Car car = new Car(1L);
    private final List<CarResponse> carResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final CarNumberRequest numberRequest = new CarNumberRequest();



    @Test
    void getCarTest() {

        when(carResponseMapper.from((Car) any())).thenReturn(getCarResponse());
        when(carRepository.getReferenceById(anyLong())).thenReturn(getCar());

        var result = service.getCarById(ID);

        assertNotNull(result);

        verify(carRepository).getReferenceById(anyLong());
        verify(carResponseMapper).from((Car) any());
        verifyNoMoreInteractions(carRepository, carResponseMapper);
        verifyNoInteractions(carMapper);
    }

    @Test
    void getAllCarsTest() {
        cars.add(new Car(1L));
        cars.add(new Car(2L));
        carResponses.add(new CarResponse());
        carResponses.add(new CarResponse());

        when(carRepository.findAll()).thenReturn(cars);
        when(carResponseMapper.from(cars)).thenReturn(carResponses);

        List<CarResponse> result = service.getAllCars();

        assertEquals(carResponses, result);
        assertNotNull(result);
        verify(carRepository).findAll();
        verify(carResponseMapper).from(cars);

        verifyNoMoreInteractions(carRepository, carResponseMapper);
        verifyNoInteractions(carMapper);
    }

    @Test
    void deleteCarTest() {
        service.deleteCar(ID);
        verify(carRepository).deleteById(ID);

        verifyNoMoreInteractions(carRepository, carResponseMapper);
        verifyNoInteractions(carMapper);
    }

    @Test
    void addCarTest() {
        when(carMapper.from(carAddRequestAdd)).thenReturn(car);
        when(carRepository.save(car)).thenReturn(car);
        Long id = service.addCar(carAddRequestAdd);
        assertEquals(car.getId(), id.longValue());
        verify(carMapper).from(carAddRequestAdd);
        verify(carRepository).save(car);
        verifyNoMoreInteractions(carRepository, carResponseMapper);
    }

    @Test
    void editCarsTest(){
        carAddRequestAdd.setId(1L);
        car.setId(1L);

        when(carRepository.getReferenceById(carAddRequestAdd.getId())).thenReturn(car);
        when(carMerger.merge(car,carAddRequestAdd)).thenReturn(car);
        when(carRepository.save(car)).thenReturn(car);

        Long result = service.editCars(carAddRequestAdd);

        verify(carRepository).getReferenceById(carAddRequestAdd.getId());
        verify(carRepository).save(car);
        verify(carMerger).merge(car,carAddRequestAdd);

        assertEquals(1L, result);

    }

    @Test
    void getCarByNumber(){
        numberRequest.setNumber("ABC123");
        car.setId(1L);
        car.setCarNumber("ABC123");
        carResponse.setId(1L);
        carResponse.setCarNumber("ABC123");
        cars.add(car);
        when(carRepository.findAll()).thenReturn(cars);
        when(carResponseMapper.from(car)).thenReturn(carResponse);

        List<CarResponse> result = service.getCarByNumber(numberRequest);
        verify(carRepository).findAll();
        verify(carResponseMapper).from(car);
        assertEquals(1, result.size());
        assertEquals(carResponse, result.get(0));
    }

    private CarResponse getCarResponse() {
        return new CarResponse()
                .setId(ID);
    }

    private Car getCar() {
        return new Car(ID);
    }
}

