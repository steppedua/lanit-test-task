package ru.lanit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.domain.Car;
import ru.lanit.dto.CarDto;
import ru.lanit.services.impl.CarServiceImpl;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carService;

    @PostMapping("/car")
    public ResponseEntity<Void> createCar(@Valid @RequestBody CarDto carDto) {
        carService.createCar(carDto);
        return ResponseEntity.ok().build();
    }
}
