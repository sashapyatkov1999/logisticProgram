package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.mapper.car.CarMapper;
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
public class CarDomainServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private CarResponseMapper carResponseMapper;
    @Mock
    private CarMapper carMapper;
    @InjectMocks
    private CarDomainService service;

    private final CarAddRequest carAddRequestAdd = new CarAddRequest();
    private final List<Car> cars = new ArrayList<>();
    private final Car car = new Car(1L);
    private final List<CarResponse> pointResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;


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
        pointResponses.add(new CarResponse());
        pointResponses.add(new CarResponse());

        when(carRepository.findAll()).thenReturn(cars);
        when(carResponseMapper.from(cars)).thenReturn(pointResponses);

        List<CarResponse> result = service.getAllCars();

        assertEquals(pointResponses, result);
        assertNotNull(result);
        verify(carRepository).findAll();
        verify(carResponseMapper).from(cars);

        verifyNoMoreInteractions(carRepository, carResponseMapper);
        verifyNoInteractions(carMapper);
    }

    @Test
    void deleteUserTest() {
        service.deleteCar(id);
        verify(carRepository).deleteById(id);

        verifyNoMoreInteractions(carRepository, carResponseMapper);
        verifyNoInteractions(carMapper);
    }

    @Test
    void addUserTest() {
        when(carMapper.from(carAddRequestAdd)).thenReturn(car);
        when(carRepository.save(car)).thenReturn(car);
        Long id = service.addCar(carAddRequestAdd);
        assertEquals(car.getId(), id.longValue());
        verify(carMapper).from(carAddRequestAdd);
        verify(carRepository).save(car);
        verifyNoMoreInteractions(carRepository, carResponseMapper);
    }

    private CarResponse getCarResponse() {
        return new CarResponse()
                .setId(ID);
    }

    private Car getCar() {
        return new Car(ID);
    }
}

