package ru.lanit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.services.impl.PersonServiceImpl;

@RestController
@RequiredArgsConstructor
public class ClearController {

    private final PersonServiceImpl personService;

    @DeleteMapping("/clear")
    public ResponseEntity<Void> deleteCarsAndPersons() {
        personService.deleteAllPersonsAndCars();

        return ResponseEntity.ok().build();
    }
}
