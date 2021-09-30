package ru.lanit.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.domain.Person;
import ru.lanit.dto.PersonDto;
import ru.lanit.exceptions.PersonBadRequestException;
import ru.lanit.exceptions.PersonNotFoundException;
import ru.lanit.mappers.PersonMapper;
import ru.lanit.repository.PersonRepository;
import ru.lanit.services.PersonService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    public Person createPerson(PersonDto personDto) {
        if (personRepository.existsByPersonId(personDto.getPersonId())) {
            throw new PersonBadRequestException(String.format("Человек с id = %s уже существует", personDto.getPersonId()));
        }

        return personRepository.save(personMapper.toCreatePersonDto(personDto));
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        if (!personRepository.existsByPersonId(id)) {
            throw new PersonBadRequestException(String.format("Человека с id = %s не существует", id));
        }

        if (!personRepository.existsByPersonId(id)) {
            throw new PersonNotFoundException(String.format("Человека с id = %s не существует", id));
        }


        return personRepository.findByPersonId(id);
    }

    @Override
    public void deleteAllPersonsAndCars() {
        personRepository.deleteAll();
    }
}
