package com.example.systemtask.service;

import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.exception.TaskNotFoundException;
import com.example.systemtask.mapper.TaskMapper;
import com.example.systemtask.model.Task;
import com.example.systemtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    //private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        //this.taskMapper = taskMapper;
    }


    @Override
    public void create(TaskDTO taskDTO) {
        //Task task = taskMapper.toTask(taskDTO);
        Task task = TaskMapper.INSTANCE.toTask(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public TaskDTO readTask(Long id) {
        return TaskMapper.INSTANCE.toTaskDto(taskRepository.findById(id).orElseThrow(TaskNotFoundException::new));
    }


    @Override
    public void update(TaskDTO taskUpdate) { //пересмотреть, укоротить
        Task task = taskRepository.findById(taskUpdate.getId()).orElseThrow(TaskNotFoundException::new);

        task.setTitle(taskUpdate.getTitle());
        task.setDescription(taskUpdate.getDescription());
        task.setExecutor(taskUpdate.getExecutor());
        task.setPriority(taskUpdate.getPriority());
        task.setStatus(taskUpdate.getStatus());
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDTO> showAll() {

        return taskRepository.findAll().stream().map(TaskMapper.INSTANCE::toTaskDto).collect(Collectors.toList());
    }
}
