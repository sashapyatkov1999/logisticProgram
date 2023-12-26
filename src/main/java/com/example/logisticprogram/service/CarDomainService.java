package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.mapper.car.CarMapper;
import com.example.logisticprogram.mapper.car.CarResponseMapper;
import com.example.logisticprogram.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarDomainService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarResponseMapper carResponseMapper;
    @Transactional
    public CarResponse getCarById(Long id) {
        return carResponseMapper.from(carRepository.getReferenceById(id));
    }


    @Transactional
    public List<CarResponse> getAllCars() {
        return carResponseMapper.from(carRepository.findAll());//сейчас не разберу в чем ошибка

    }
    //@Transactional
    //public List<CarResponse> getAllCars() {
    //    List<Car> cars = carRepository.findAll();
    //    List<CarResponse> carResponses = new ArrayList<>();
    //
    //    for (Car car : cars) {
    //        carResponses.add(carResponseMapper.from(car));
    //    }
    //
    //    return carResponses;
    //}

    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    public Long addCar(CarAddRequest request) {
        return carRepository.save(carMapper.from(request)).getId();

    }
}
