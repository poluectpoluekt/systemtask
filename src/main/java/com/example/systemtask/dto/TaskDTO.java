package com.example.systemtask.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String author;
    private String executor;
}
