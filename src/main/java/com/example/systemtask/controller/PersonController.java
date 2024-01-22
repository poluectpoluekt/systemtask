package com.example.systemtask.controller;

import com.example.systemtask.dto.PersonDTO;
import com.example.systemtask.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/api")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService){
        this.personService = personService;
    }

    @PostMapping("/create")
    public void create(@RequestBody PersonDTO personDTO){
        personService.create(personDTO);
    }

    @GetMapping("/showAll")
    public List<PersonDTO> showAll(){
        return personService.showAll();
    }

    @GetMapping("/showPerson")
    public PersonDTO showPerson(@RequestParam String email){
        return personService.findPerson(email);
    }

    @PatchMapping("/update")
    public void updatePerson(@RequestBody PersonDTO personDTO){
        personService.update(personDTO.getEmail(), personDTO);
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestBody PersonDTO personDTO){
        personService.delete(personDTO);
    }

}
