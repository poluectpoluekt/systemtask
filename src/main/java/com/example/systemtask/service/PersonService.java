package com.example.systemtask.service;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    void create(PersonDTO personDTO);

    PersonDTO findPerson(String email);

    List<PersonDTO> showAll();

    void update(String email, PersonDTO personUpdate);

    void delete(PersonDTO personDTO);
}
