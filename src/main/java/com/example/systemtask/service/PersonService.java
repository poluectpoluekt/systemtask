package com.example.systemtask.service;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    void create(PersonDTO personDTO);

    Person findPerson(String email);

    List<Person> showAll();

    void update(String email, Person person);

    void delete(Person person);
}
