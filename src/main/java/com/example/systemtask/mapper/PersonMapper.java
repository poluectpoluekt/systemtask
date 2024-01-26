package com.example.systemtask.mapper;


import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    //PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDto(Person person);
    Person toPerson(PersonDTO personDTO);
}
