package ru.lanit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto implements Serializable {
    @NotBlank
    @JsonProperty("id")
    private Long personId;

    @NotBlank
    @JsonProperty("name")
    private String name;

    @Past
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonProperty("birthday")
    private LocalDate birthday;
}
