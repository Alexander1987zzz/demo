package com.example.demo.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    @Autowired
    private  TestRepository testRepository;

    @Transactional
    
    public Runnable order(Long id){
        Order byId = testRepository.findById(id).orElse(null);
        byId.setQuantity(byId.getQuantity() - 1);
        testRepository.save(byId);

        return null;
    }
}
