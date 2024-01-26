package com.example.systemtask.service;

import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.exception.PersonNotFoundExcepton;
import com.example.systemtask.exception.TaskNotFoundException;
import com.example.systemtask.mapper.TaskMapper;
import com.example.systemtask.model.Person;
import com.example.systemtask.model.Task;
import com.example.systemtask.repository.PersonRepository;
import com.example.systemtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    private final PersonRepository personRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, PersonRepository personRepository){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public void create(TaskDTO taskDTO) {
        Task task = taskMapper.toTask(taskDTO);
        task.setAuthor(personRepository.findByEmail(taskDTO.getAuthor()).orElseThrow(PersonNotFoundExcepton::new));
        task.setCreateAt(LocalDateTime.now());
        System.out.println(task);
        taskRepository.save(task);
    }

    @Override
    public TaskDTO readTask(Long id) {
        return taskMapper.toTaskDto(taskRepository.findById(id).orElseThrow(TaskNotFoundException::new));
    }


    @Override
    @Transactional
    public void editTask(TaskDTO taskUpdate) { //пересмотреть, укоротить

        if (taskRepository.findById(taskUpdate.getId()).isPresent()) {
            Task task = taskRepository.findById(taskUpdate.getId()).orElseThrow(TaskNotFoundException::new);

            task.setDescription(taskUpdate.getDescription());
            task.setStatus(taskUpdate.getStatus());
            task.setPriority(taskUpdate.getPriority());
            task.setExecutor(taskUpdate.getExecutor());

        } else throw new TaskNotFoundException();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDTO> showAll() {

        return taskRepository.findAll().stream().map(taskMapper::toTaskDto).collect(Collectors.toList());
    }
}
