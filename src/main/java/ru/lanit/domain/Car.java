package ru.lanit.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "Car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", nullable = false)
    private Long carId;

    @NotNull
    @Column(name = "vendor")
    private String vendor;

    @NotNull
    @Column(name = "model")
    private String model;


    @Min(1)
    @Column(name = "horsepower")
    private Integer horsepower;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Car(Long carId, String vendor, String model, Integer horsepower, Person person) {
        this.carId = carId;
        this.vendor = vendor;
        this.model = model;
        this.horsepower = horsepower;
        this.person = person;
    }
}
