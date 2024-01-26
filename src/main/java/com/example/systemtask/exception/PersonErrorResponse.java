package com.example.systemtask.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * Класс, которым будем отвечать пользователю
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonErrorResponse {
    private String message;
    private Long timestamp;



}
