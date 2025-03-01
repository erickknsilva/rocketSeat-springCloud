package com.rocketseat.service.tasks.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")
public interface NotificationClient {


    @PostMapping("/nofitification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);

}
