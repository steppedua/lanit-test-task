package ru.lanit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.lanit.domain.Person;
import ru.lanit.dto.PersonDto;
import ru.lanit.dto.PersonWithCarsDto;

@Mapper
public interface PersonMapper {

    @Mappings({
            @Mapping(target = "id", source = "personDto.personId"),
            @Mapping(target = "name", source = "personDto.name"),
            @Mapping(target = "birthday", source = "personDto.birthday")
    })
    default Person toCreatePersonDto(PersonDto personDto) {
        return new Person(
                personDto.getPersonId(),
                personDto.getName(),
                personDto.getBirthday()
        );
    }

    @Mappings({
            @Mapping(target = "id", source = "person.personId"),
            @Mapping(target = "name", source = "person.name"),
            @Mapping(target = "birthday", source = "person.birthday"),
            @Mapping(target = "cars", source = "person.cars")
    })
    PersonWithCarsDto toGetCarWithPersonDto(Person person);
}
