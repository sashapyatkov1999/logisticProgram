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

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    private final Long ID = 0L;




    @Test
    void getCarTest() {
        when(carResponseMapper.from(any(Car.class))).thenReturn(getCarResponse());
        when(carRepository.getReferenceById(anyLong())).thenReturn(getCar());

        var result = service.getCarById(ID);

        assertThat(result).isNotNull();

        verify(carRepository).getReferenceById(anyLong());
        verify(carResponseMapper).from(any(Car.class));
        verifyNoMoreInteractions(carRepository, carResponseMapper);
        verifyNoInteractions(carMapper);
    }

    @Test
    void getAllCarsTest() {
        when(carRepository.findAll()).thenReturn(Collections.singletonList(getCar()));
        when(carResponseMapper.from(anyList())).thenReturn(Collections.singletonList(getCarResponse()));

        List<CarResponse> result = service.getAllCars();

        assertThat(result).isNotNull();

        verify(carRepository).findAll();
        verify(carResponseMapper).from(anyList());
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
        when(carMapper.from(any(CarAddRequest.class))).thenReturn(getCar());
        when(carRepository.save(any())).thenReturn(getCar());

        Long id = service.addCar(carAddRequestAdd());

        assertThat(id).isEqualTo(ID);

        verify(carMapper).from(any(CarAddRequest.class));
        verify(carRepository).save(any());
        verifyNoMoreInteractions(carRepository, carResponseMapper);
    }

    @Test
    void editCarsTest(){
        when(carRepository.getReferenceById(anyLong())).thenReturn(getCar());
        when(carMerger.merge(any(),any())).thenReturn(getCar());
        when(carRepository.save(any())).thenReturn(getCar());

        Long result = service.editCars(carAddRequestAdd());

        assertThat(result).isEqualTo(ID);

        verify(carRepository).getReferenceById(anyLong());
        verify(carRepository).save(any());
        verify(carMerger).merge(any(),any());
        verifyNoMoreInteractions(carRepository,carMerger);

    }

    @Test
    void getCarByNumber(){
        when(carRepository.findAll()).thenReturn(Collections.singletonList(getCar()));
        when(carResponseMapper.from(any(Car.class))).thenReturn(getCarResponse());

        List<CarResponse> result = service.getCarByNumber(numberRequest());

        assertThat(result).hasSize(result.size()).isNotEmpty();
        assertThat(result.get(0)).isEqualTo(getCarResponse());
        verify(carRepository).findAll();
        verify(carResponseMapper).from(any(Car.class));


        verify(carRepository, times(1)).findAll();
        verify(carResponseMapper, times(1)).from(any(Car.class));


    }
    private  CarNumberRequest numberRequest() { return new CarNumberRequest().setNumber("ABC123");}

    private CarResponse getCarResponse() {
        return new CarResponse()
                .setId(ID)
                .setCarNumber("ABC123");
    }
    private CarAddRequest carAddRequestAdd(){
        return new CarAddRequest().setId(ID);
    }

    private Car getCar() {
        return new Car(ID).setCarNumber("ABC123");
    }
}

