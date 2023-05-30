package com.example.kafkaproducer;

import lombok.Data;

@Data
public class NotificationDto {
    private Long authorId;
    private Long receiverId;
    private String notificationType;
    private Long entityId;
}
