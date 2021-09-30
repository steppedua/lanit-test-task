package ru.lanit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto implements Serializable {

    @NotNull
    @JsonProperty("id")
    private Long carId;

    @NotNull
    @JsonProperty("model")
    private String model;

    @NotNull
    @Min(1)
    @JsonProperty("horsepower")
    private Integer horsepower;

    @NotNull
    @JsonProperty("ownerId")
    private Long ownerId;
}
