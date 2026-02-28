package com.example.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<D, ID, F> {
    Page<D> findAll(F filter, Pageable pageable);
    D create(D dto);
    Optional<D> findById(ID id);
    D update(ID id, D dto);
    void delete(ID id);

}

