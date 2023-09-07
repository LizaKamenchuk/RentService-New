package org.kamenchuk.rentModule.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.dto.carDTO.CarCreateRequest;
import org.kamenchuk.dto.carDTO.CarResponse;
import org.kamenchuk.dto.carDTO.CarUpdateRequest;
import org.kamenchuk.rentModule.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent_module/car")
@SecurityRequirement(name = "bearerToken")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/admin/getAll")
    public List<CarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping(value = "/getCarById/{idCar}")
    public CarResponse getCarById(@PathVariable Integer idCar) {
        return carService.getCarById(idCar);
    }

    @GetMapping(value = "/getByCarNumber/{carNumber}")
    public CarResponse getByCarNumber(@PathVariable String carNumber) {
        return carService.getByCarNumber(carNumber);
    }

    @PostMapping(value = "/admin/create")
    public CarResponse create(@RequestPart CarCreateRequest request) {
        return carService.create(request);
    }

    @DeleteMapping(value = "/admin/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        carService.deleteById(id);
    }

    @DeleteMapping(value = "/admin/deleteByCarNumber/{carNumber}")
    public void deleteByCarNumber(@PathVariable String carNumber) {
        carService.deleteByCarNumber(carNumber);
    }

    @PatchMapping(value = "/admin/update")
    public CarResponse update(@RequestBody CarUpdateRequest request, @RequestParam Integer idCar) {
        return carService.update(request, idCar);
    }
}
