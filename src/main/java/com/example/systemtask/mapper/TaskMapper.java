package com.example.systemtask.mapper;

import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toTaskDto(Task task);

    Task toTask(TaskDTO taskDTO);
}
