package com.example.systemtask.mapper;

import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.exception.PersonNotFoundExcepton;
import com.example.systemtask.exception.TaskNotFoundException;
import com.example.systemtask.model.Person;
import com.example.systemtask.model.Task;
import com.example.systemtask.repository.PersonRepository;
import com.example.systemtask.service.PersonServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    //TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    //PersonRepository REP = Mappers.getMapper(PersonRepository.class);


    @Mapping(target = "author", qualifiedByName = "personToString")
    //@Mapping(target = "author", expression = "java(person.getEmail)")
    TaskDTO toTaskDto(Task task);

    //@Mapping(target = "author", qualifiedByName = "stringToPerson")
    @Mapping(target = "author", ignore = true)
    Task toTask(TaskDTO taskDTO);

    @Named("personToString")
    default String personToString(Person person){
        return person.getEmail();
    }
//
//    @Named("stringToPerson")
//    default Person stringToPerson(String authorEmail){
//
//        if (authorEmail.isEmpty()) throw new TaskNotFoundException();
//        //Person person = PersonRepository.class.
//        Person person = new Person();
//        person.setEmail(authorEmail);
//        return person;
//    }

//    @Named("stringToPerson")
//    default Person custom(String email){
//      //Person person = REP.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new);
//
//        return null;
//        //return REP.findByEmail(email).orElseThrow(PersonNotFoundExcepton::new);
//    }


}
