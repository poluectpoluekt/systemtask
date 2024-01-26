package com.example.systemtask.service;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.exception.PersonAlreadyRegistered;
import com.example.systemtask.exception.PersonNotFoundExcepton;
import com.example.systemtask.mapper.PersonMapper;
import com.example.systemtask.model.Person;
import com.example.systemtask.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    @Transactional
    public void create(PersonDTO personDTO) {
        if (personRepository.findByEmail(personDTO.getEmail()).isPresent()){
            throw new PersonAlreadyRegistered();
        } else {
            Person person = personMapper.toPerson(personDTO); // Переделать mapper, чтобы добавлялся через конструктор
            personRepository.save(person);
        }
    }

    @Override
    public PersonDTO findPerson(String email) {
        return personMapper.toDto(personRepository.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new));
    }

    @Override
    public List<PersonDTO> showAll() {
        return personRepository.findAll().stream().map(personMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void editPerson(String email, PersonDTO personUpdate) {
        Person person = new Person();
        person = personRepository.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new);

        person.setEmail(personUpdate.getEmail());
        person.setPassword(personUpdate.getPassword());
    }

    @Override
    @Transactional
    public void delete(PersonDTO personDTO) { // можно передалать код лучше
        //personRepository.delete(personMapper.toPerson(personDTO));
        Person person = personRepository.findByEmail(personDTO.getEmail()).orElseThrow(PersonNotFoundExcepton::new);
        personRepository.deleteById(person.getId());
    }
}
