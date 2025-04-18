package com.interview.lostupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void update(Long id, Integer quantity) {
        productRepository.findById(id).ifPresent(p -> p.setQuantity(p.getQuantity() + quantity));
    }
}
