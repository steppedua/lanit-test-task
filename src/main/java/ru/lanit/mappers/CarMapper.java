package ru.lanit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.lanit.domain.Car;
import ru.lanit.domain.Person;
import ru.lanit.dto.CarDto;
import ru.lanit.exceptions.CarBadRequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mapper
public interface CarMapper {


    @Mappings({
            @Mapping(target = "id", source = "carDto.id"),
            @Mapping(target = "model", source = "carDto.model"),
            @Mapping(target = "horsepower", source = "carDto.horsepower"),
            @Mapping(target = "ownerId", source = "carDto.ownerId")
    })
    default Car toCreateCar(CarDto carDto, Person person) {

        final Pattern pattern = Pattern.compile("[a-zA-Z\s]+-[a-zA-Z0-9]+", Pattern.CASE_INSENSITIVE);

        final Matcher matcher = pattern.matcher(carDto.getModel());

        if (matcher.matches()) {
            String[] vendorModel = carDto.getModel().split("-");

            return new Car(
                    carDto.getCarId(),
                    vendorModel[0],
                    vendorModel[1],
                    carDto.getHorsepower(),
                    person
            );
        }

        throw new CarBadRequestException("не прошел валидацию");
    }
}
