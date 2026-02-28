package com.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSpecification<E, F> {
public Specification<E> buildFilter(F filter) {
    return (root, query, cb) -> {
        List<Predicate> predicates = new ArrayList<>();
        addPredicates(filter, root, cb, predicates);
        return cb.and(predicates.toArray(new Predicate[0]));
    };
}

protected abstract void addPredicates(
        F filter,
        Root<E> root,
        CriteriaBuilder cb,
        List<Predicate> predicates
);
}
