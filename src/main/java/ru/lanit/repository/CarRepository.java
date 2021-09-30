package ru.lanit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Boolean existsByCarId(Long carId);
}
