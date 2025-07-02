package com.interview.kafka;

import org.springframework.stereotype.Repository;

@Repository
public interface OutboxStatusRepository {
    void updateStatus(Long outboxId, Status status);
}
