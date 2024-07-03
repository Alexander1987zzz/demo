package com.example.demo.string.lostupdate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TestService2 {
    @Autowired
    private TestRepository testRepository;

    @Transactional
    void update(Long id, Integer quantity) {
        Order byId = testRepository.findById(id).get();
        byId.setQuantity(byId.getQuantity() + quantity);
        testRepository.save(byId);
        log.info("service2");
    }
}
