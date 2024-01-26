package com.example.systemtask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String description;
    @Setter
    @Getter
    private String status;
    @Setter
    @Getter
    private String priority;
    @Setter
    @Getter
    private String author;
    @Setter
    @Getter
    private String executor;

    @Setter
    @Getter
    private LocalDateTime createAt;
}
