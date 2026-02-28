package com.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class UserSpecification extends BaseSpecification<User, UserFilter> {


    public static Specification<User> buildUserFilter(UserFilter filter) {
        return new UserSpecification().buildFilter(filter);
    }

    @Override
    protected void addPredicates(
            UserFilter filter,
            Root<User> root,
            CriteriaBuilder cb,
            List<Predicate> predicates
    ) {
        if (filter.name() != null) {
            predicates.add(cb.like(
                    cb.lower(root.get("name")),
                    "%" + filter.name().toLowerCase() + "%"
            ));
        }

        if (filter.email() != null) {
            predicates.add(cb.equal(
                    cb.lower(root.get("email")),
                    filter.email().toLowerCase()
            ));
        }
    }
}
