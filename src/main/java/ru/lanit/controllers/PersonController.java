package ru.lanit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.domain.Person;
import ru.lanit.dto.PersonDto;
import ru.lanit.dto.PersonWithCarsDto;
import ru.lanit.mappers.PersonMapper;
import ru.lanit.services.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;
    private final PersonMapper personMapper;

    @PostMapping("/person")
    public ResponseEntity<Void> createPerson(@Valid @RequestBody PersonDto personDto) {
        personService.createPerson(personDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/personwithcars")
    public ResponseEntity<PersonWithCarsDto> getPerson(@RequestParam Long personId) {

        Optional<Person> person = personService.getPerson(personId);

        return ResponseEntity.ok(personMapper.toGetCarWithPersonDto(person.get()));
    }
}
