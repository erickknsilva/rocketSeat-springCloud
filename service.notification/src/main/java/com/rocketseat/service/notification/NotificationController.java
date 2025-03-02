package com.rocketseat.service.notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("notification")
@RestController
public class NotificationController {

    @PostMapping
    public ResponseEntity<Void> createNotifcation(@RequestBody NotificationRequest request) {

        System.out.println("================================");
        System.out.println(request.message());
        return ResponseEntity.ok().build();
    }
}
