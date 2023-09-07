package org.kamenchuk.rentModule.service;

import org.kamenchuk.dto.carDTO.CarCreateRequest;
import org.kamenchuk.dto.carDTO.CarResponse;
import org.kamenchuk.dto.carDTO.CarUpdateRequest;
import org.kamenchuk.rentModule.feinClient.FeignCarClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final FeignCarClient feignCarClient;

    @Autowired
    public CarService(FeignCarClient feignCarClient) {
        this.feignCarClient = feignCarClient;
    }

    public List<CarResponse> getAll() {
        return feignCarClient.getAll();
    }

    public CarResponse getCarById(Integer idCar) {
        return feignCarClient.getCarById(idCar);
    }

    public CarResponse getByCarNumber(String carNumber) {
        return feignCarClient.getByCarNumber(carNumber);
    }

    public CarResponse create(CarCreateRequest request) {
        return feignCarClient.create(request);
    }

    public void deleteById(Integer id) {
        feignCarClient.deleteById(id);
    }

    public void deleteByCarNumber(String carNumber) {
        feignCarClient.deleteByCarNumber(carNumber);
    }

    public CarResponse update(CarUpdateRequest request, Integer idCar) {
        return feignCarClient.update(request, idCar);
    }
}
