package com.example.systemtask.service;

import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void create(TaskDTO taskDTO);
    TaskDTO readTask(Long id);

    void update(TaskDTO taskUpdate);

    void delete(Long id);

    List<Task> showAll();

}
