package com.example.systemtask.mapper;


import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.model.Person;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface PersonMapper {

    PersonDTO toDto(Person person);
    Person toPerson(PersonDTO personDTO);
}
