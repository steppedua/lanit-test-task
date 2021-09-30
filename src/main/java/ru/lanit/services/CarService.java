package ru.lanit.services;

import ru.lanit.domain.Car;
import ru.lanit.dto.CarDto;

public interface CarService {
    Car createCar(CarDto carDto);
}
