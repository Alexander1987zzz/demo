package com.example;

import com.example.generic.GenericRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends GenericRepository<User, Long> {
    boolean existsByEmail(String email);
}
