package com.example.lostupdate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TestService1 {

    @Autowired
    private TestRepository testRepository;

    @Transactional
    void update(Long id, Integer quantity) {
        Order byId = (Order)this.testRepository.findById(id).get();
        byId.setQuantity(byId.getQuantity() + quantity);
        this.testRepository.save(byId);
        log.info("service1");
    }
}
