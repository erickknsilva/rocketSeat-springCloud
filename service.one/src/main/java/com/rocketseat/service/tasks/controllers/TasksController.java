package com.rocketseat.service.tasks.controllers;

import com.rocketseat.service.tasks.TaskEntity;
import com.rocketseat.service.tasks.TaskEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskEntityRepository taskEntityRepository;

    @PostMapping
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity taskEntity) {
        return ResponseEntity.ok().body(taskEntityRepository.save(taskEntity));
    }

}
