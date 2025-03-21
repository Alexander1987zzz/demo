package com.interview.lostupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void update(Long id, Integer quantity) {
        orderRepository.findById(id).ifPresent(o -> o.setQuantity(o.getQuantity() + quantity));
    }
}
