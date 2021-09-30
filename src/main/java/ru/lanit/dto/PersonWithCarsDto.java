package ru.lanit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.lanit.domain.Car;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonWithCarsDto implements Serializable {

    @NotBlank
    @JsonProperty("id")
    private Long id;

    @NotBlank
    @JsonProperty("name")
    private String name;

    @Past
    @NotBlank
    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern="dd.MM.yyyy")
    @JsonProperty("birthday")
    private Date birthday;

    @NotBlank
    @JsonDeserialize(as = ArrayList.class)
    @JsonProperty("cars")
    private List<Car> cars;

}
