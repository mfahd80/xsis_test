package com.example.xsis.business.movie.domain.service;


import com.example.xsis.business.movie.domain.entities.MovieEntity;
import com.example.xsis.business.shared_domain.base.entity.BaseSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification extends BaseSpecification {

    public Specification<MovieEntity> restrictBy(String search){
        return ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Predicate predicate;

            if (search != null && !search.isEmpty()){
                String searchLike = String.format("%%%s%%", search.toLowerCase());
                predicate = builder.or(
                        builder.like(builder.lower(root.get("title")), searchLike),
                        builder.like(builder.lower(root.get("description")), searchLike)
                );
                predicates.add(predicate);
            }

            ((CriteriaQuery) query).where(builder.and(predicates.toArray(new Predicate[]{})));
            return query.getRestriction();
        });
    }
}
