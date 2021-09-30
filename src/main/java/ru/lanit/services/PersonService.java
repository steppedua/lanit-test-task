package ru.lanit.services;

import ru.lanit.domain.Person;
import ru.lanit.dto.PersonDto;

import java.util.Optional;

public interface PersonService {
    Person createPerson(PersonDto personDto);

    Optional<Person> getPerson(Long id);

    void deleteAllPersonsAndCars();
}
