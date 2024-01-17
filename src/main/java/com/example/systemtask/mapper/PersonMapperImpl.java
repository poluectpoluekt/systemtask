package com.example.systemtask.mapper;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {


    @Override
    public PersonDTO toDto(Person person) {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setEmail(person.getEmail());

        return personDTO;
    }

    @Override
    public Person toPerson(PersonDTO personDTO) {

        Person person = new Person();
        person.setEmail(personDTO.getEmail());
        person.setPassword(personDTO.getPassword());

        return person;
    }
}
