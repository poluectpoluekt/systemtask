package com.example.systemtask.advice;

import com.example.systemtask.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionController {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private ExceptionResponse error(RuntimeException ex) {
        return new ExceptionResponse(ex.getMessage(), System.currentTimeMillis());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PersonNotFoundExcepton.class)
    private PersonErrorResponse notFoundPerson(PersonNotFoundExcepton e){
        return new PersonErrorResponse("User with this email does not exist",
                System.currentTimeMillis());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PersonAlreadyRegistered.class)
    private PersonErrorResponse userAlreadyRegistred(PersonNotFoundExcepton e){
        return new PersonErrorResponse("A user with this email address already exists",
                System.currentTimeMillis());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    private TaskErrorResponse notFoundTask(){
        return new TaskErrorResponse("Task with this number was not found", System.currentTimeMillis());
    }



}
