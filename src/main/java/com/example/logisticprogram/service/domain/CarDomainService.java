package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.dto.request.car.CarNumberRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.mapper.car.CarMapper;
import com.example.logisticprogram.mapper.car.CarMerger;
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
    private final CarMerger carMerger;
    @Transactional
    public CarResponse getCarById(Long id) {
        return carResponseMapper.from(carRepository.getReferenceById(id));
    }


    @Transactional
    public List<CarResponse> getAllCars() {
        return carResponseMapper.from(carRepository.findAll());

    }

    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    public Long addCar(CarAddRequest request) {
        return carRepository.save(carMapper.from(request)).getId();

    }

    @Transactional
    public Long editCars(CarAddRequest request) {
        var car = carRepository.getReferenceById(request.getId());
        return carRepository.save(carMerger.merge(car, request)).getId();
    }

    @Transactional
    public  List<CarResponse> getCarByNumber(CarNumberRequest numberRequest) {
        return  carRepository.findAll()
                .stream()
                .filter(car-> car
                        .getCarNumber()
                        .toLowerCase()
                        .contains(numberRequest
                                .getNumber()
                                .toLowerCase()))
                .map(carResponseMapper::from)
                .toList();
    }
}
