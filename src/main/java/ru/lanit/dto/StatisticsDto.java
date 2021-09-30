package ru.lanit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class StatisticsDto implements Serializable {

    @JsonProperty("personcount")
    private Long personcount;

    @JsonProperty("carcount")
    private Long carcount;

    @JsonProperty("uniquevendorcount")
    private Long uniquevendorcount;

}
