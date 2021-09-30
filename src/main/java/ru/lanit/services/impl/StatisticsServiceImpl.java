package ru.lanit.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.domain.Car;
import ru.lanit.domain.Person;
import ru.lanit.dto.StatisticsDto;
import ru.lanit.repository.CarRepository;
import ru.lanit.repository.PersonRepository;
import ru.lanit.services.StatisticsService;


@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Override
    public StatisticsDto getStatistics() {

        Long carCount = carRepository.findAll()
                .stream()
                .map(Car::getCarId)
                .count();

        Long personCount = personRepository.findAll()
                .stream()
                .map(Person::getPersonId)
                .count();

        Long uniqueVendorCount = carRepository.findAll().stream()
                .map(Car::getModel)
                .distinct()
                .count();

        return new StatisticsDto(personCount, carCount, uniqueVendorCount);
    }
}
