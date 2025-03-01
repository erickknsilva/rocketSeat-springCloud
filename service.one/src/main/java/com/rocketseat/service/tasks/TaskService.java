package com.rocketseat.service.tasks;


import com.rocketseat.service.tasks.notification.NotificationClient;
import com.rocketseat.service.tasks.notification.NotificationRequest;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class TaskService {

    private final TaskEntityRepository taskEntityRepository;
    private final NotificationClient notificationClient;

    public void sendNotificationForDueTask() {

        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<TaskEntity> listTaks = taskEntityRepository.findTasksDueWithinDeadLine(deadline);

        for (TaskEntity task : listTaks) {
            NotificationRequest notificationRequest =
                    new NotificationRequest("Sua tarefa: " + task.getTitle() + " está preste a vencer.",
                            task.getEmail());
            notificationClient.sendNotification(notificationRequest);
        }
    }

}
