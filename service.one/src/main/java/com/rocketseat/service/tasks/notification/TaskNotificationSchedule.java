package com.rocketseat.service.tasks.notification;

import com.rocketseat.service.tasks.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskNotificationSchedule {

    private final TaskService taskService;

    @Scheduled(fixedRate =  360)
    public void checkAndNotifyTask() {
        this.taskService.sendNotificationForDueTask();
    }

}
