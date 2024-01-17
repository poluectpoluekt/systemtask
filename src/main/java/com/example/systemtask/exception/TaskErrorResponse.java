package com.example.systemtask.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class TaskErrorResponse {

    private String message;
    private long timestamp;
}
