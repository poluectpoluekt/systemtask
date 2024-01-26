package com.example.systemtask.service;

import com.example.systemtask.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    void create(PersonDTO personDTO);

    PersonDTO findPerson(String email);

    List<PersonDTO> showAll();

    void editPerson(String email, PersonDTO personUpdate);

    void delete(PersonDTO personDTO);
}
