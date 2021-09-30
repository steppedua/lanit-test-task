package ru.lanit.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.domain.Car;
import ru.lanit.domain.Person;
import ru.lanit.dto.CarDto;
import ru.lanit.exceptions.CarBadRequestException;
import ru.lanit.exceptions.PersonNotFoundException;
import ru.lanit.mappers.CarMapper;
import ru.lanit.repository.CarRepository;
import ru.lanit.repository.PersonRepository;
import ru.lanit.services.CarService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMapper carMapper;
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Override
    public Car createCar(CarDto carDto) {

        if (carRepository.existsByCarId(carDto.getCarId())) {
            throw new CarBadRequestException(String.format("Машина с id = %s уже существует", carDto.getCarId()));
        }

        if (!personRepository.existsByPersonId(carDto.getOwnerId())) {
            throw new PersonNotFoundException(String.format("Человека с id = %s не существует", carDto.getOwnerId()));
        }

        Optional<Person> person = personRepository.findById(carDto.getOwnerId());

        return carRepository.save(
                carMapper.toCreateCar(carDto, person.get())
        );

    }
}
