package com.example.systemtask.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * Класс, которым будем отвечать пользователю
 */

@AllArgsConstructor
@Getter
@Setter
public class PersonErrorResponse {
    private String message;
    private long timestamp;
}
