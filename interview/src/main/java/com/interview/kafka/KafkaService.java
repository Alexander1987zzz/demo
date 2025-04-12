//package com.interview.kafka;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class KafkaService {
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    @Value("${kafka.topic}")
//    private String topic;
//
//    public void sendMessage(String message) {
//        log.info("Sending message '{}': to topic {}", topic, message);
//        kafkaTemplate.send(topic, message);
//        log.info("Successfully sent message '{}': to topic {}", topic, message);
//    }
//}
