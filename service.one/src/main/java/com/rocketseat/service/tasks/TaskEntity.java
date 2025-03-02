package com.rocketseat.service.tasks;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity(name = "Task")
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String email;

    private LocalDateTime dueDate;

    private boolean notified;

    public TaskEntity(TaskRequest request) {
        this.title = request.title();
        this.email = request.email();
        this.dueDate = request.dueDate();
        this.notified = request.notified();
    }

}
