package ru.lanit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", nullable = false)
    private Long personId;


    @Column(name = "name", nullable = false)
    private String name;

    @Past
    @DateTimeFormat(pattern="dd.MM.yyyy")
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Car> cars;


    public Person(Long personId, String name, LocalDate birthday) {
        this.personId = personId;
        this.name = name;
        this.birthday = birthday;
    }
}
