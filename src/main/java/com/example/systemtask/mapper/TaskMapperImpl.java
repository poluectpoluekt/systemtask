package com.example.systemtask.mapper;

import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.model.Task;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper{

    @Override
    public TaskDTO toTaskDto(Task task) {
//        Task taskDto = new Task();
//
//        taskDto.setId(task.getId());
//        taskDto.setTitle(task.getTitle());
        return new TaskDTO(); //TODO
    }

    @Override
    public Task toTask(TaskDTO taskDTO) {
        return null; //TODO
    }
}
