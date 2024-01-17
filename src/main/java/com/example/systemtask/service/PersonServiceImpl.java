package com.example.systemtask.service;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.exception.PersonAlreadyRegistered;
import com.example.systemtask.exception.PersonNotFoundExcepton;
import com.example.systemtask.mapper.PersonMapperImpl;
import com.example.systemtask.model.Person;
import com.example.systemtask.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapperImpl personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapperImpl personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public void create(PersonDTO personDTO) {

        if(personRepository.findByEmail(personDTO.getEmail()).isEmpty()){ // проверить

            Person person = new Person();
            person = personMapper.toPerson(personDTO);
            personRepository.save(person);
        }else {
            throw new PersonAlreadyRegistered();
        }
    }

    @Override
    public Person findPerson(String email) {
        return personRepository.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new);
    }

    @Override
    public List<Person> showAll() {
        return personRepository.findAll();
    }

    @Override
    public void update(String email, Person personUpdate) {
        Person person = personRepository.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new);

        person.setEmail(personUpdate.getEmail());
        person.setPassword(personUpdate.getPassword());
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
