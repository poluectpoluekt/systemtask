package com.example.systemtask.service;

import com.example.systemtask.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    void create(TaskDTO taskDTO);
    TaskDTO readTask(Long id);

    void editTask(TaskDTO taskUpdate);

    void delete(Long id);

    List<TaskDTO> showAll();

}
