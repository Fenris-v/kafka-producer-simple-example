package com.example.kafkaproducer;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageResource {
    private final KafkaTemplate<Long, NotificationDto> kafkaTemplate;

    @GetMapping("/")
    private @NotNull String sendMessage() {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setAuthorId(2L);
        notificationDto.setEntityId(1L);
        notificationDto.setNotificationType("POST");

        kafkaTemplate.send("notification.event", notificationDto);
        return "Message sent to topic";
    }
}
