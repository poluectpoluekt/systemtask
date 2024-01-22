package com.example.systemtask.service;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.exception.PersonAlreadyRegistered;
import com.example.systemtask.exception.PersonNotFoundExcepton;
import com.example.systemtask.mapper.PersonMapper;
import com.example.systemtask.model.Person;
import com.example.systemtask.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    //private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
        //this.personMapper = personMapper;
    }

    @Override
    public void create(PersonDTO personDTO) {

        if(personRepository.findByEmail(personDTO.getEmail()).isEmpty()){ // проверить

//            Person person = new Person();
//            person = personMapper.toPerson(personDTO);
//            Person person = PersonMapper.INSTANCE.toPerson(personDTO);
            System.out.println(PersonMapper.INSTANCE.toPerson(personDTO));
            //personRepository.save(person);
        }else {
            throw new PersonAlreadyRegistered();
        }
    }

    @Override
    public PersonDTO findPerson(String email) {
        return PersonMapper.INSTANCE.toDto(personRepository.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new));
    }

    @Override
    public List<PersonDTO> showAll() {
        return personRepository.findAll().stream().map(PersonMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public void update(String email, PersonDTO personUpdate) {
        Person person = personRepository.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new);

        person.setEmail(personUpdate.getEmail());
        person.setPassword(personUpdate.getPassword());
    }

    @Override
    public void delete(PersonDTO personDTO) {
        personRepository.delete(PersonMapper.INSTANCE.toPerson(personDTO));
    }
}
