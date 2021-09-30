package ru.lanit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.domain.Person;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Boolean existsByPersonId(Long personId);


    Optional<Person> findByPersonId(Long id);

    void deleteAll();
}
