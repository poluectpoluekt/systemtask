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

    public TaskErrorResponse(String message, Long timestamp){
        this.message = message;
        this.timestamp = timestamp;
    }

}
