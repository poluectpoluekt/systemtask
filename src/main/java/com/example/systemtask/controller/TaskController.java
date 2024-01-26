package com.example.systemtask.controller;


import com.example.systemtask.dto.TaskDTO;
import com.example.systemtask.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task/api")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    @Autowired
    public TaskController(TaskServiceImpl taskServiceImpl){
        this.taskServiceImpl = taskServiceImpl;
    }

    @PostMapping("/create")
    public void createTask(@RequestBody TaskDTO taskDTO){

        taskServiceImpl.create(taskDTO);
    }

    @GetMapping("/showAll")
    public List<TaskDTO> showAll(){
        return taskServiceImpl.showAll();
    }

    @GetMapping("/showTask")
    public TaskDTO showTask(@RequestParam Long id){
        return taskServiceImpl.readTask(id);
    }

    @PatchMapping("/edit")
    public void updateTask(@RequestBody TaskDTO taskDTO){
        taskServiceImpl.editTask(taskDTO);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam Long id){
        taskServiceImpl.delete(id);
    }

}
