package com.interview.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final OutboxStatusRepository outboxRepo;

    public void sendMessage(Long outboxId, String message) {
        log.info("Отправка сообщения {}", message);
        kafkaTemplate.send("topic", message);
        outboxRepo.updateStatus(outboxId, Status.SENT);
        log.info("Сообщение отправлено {}", message);
    }
}
