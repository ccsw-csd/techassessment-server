package com.ccsw.techassessment.position;


import com.ccsw.techassessment.common.criteria.SearchCriteria;
import com.ccsw.techassessment.position.model.Position;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class PositionSpecification implements Specification<Position> {


    private static final long serialVersionUID = 1L;

    private final SearchCriteria criteria;

    public PositionSpecification(SearchCriteria criteria) {

        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Position> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(":") && criteria.getValue() != null) {
            Path<String> path = (Path<String>) getPath(root);
            if (path.getJavaType() == String.class) {
                return builder.like(path, "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(path, criteria.getValue());
            }
        }
        return null;
    }

    private Path<?> getPath(Root<Position> root) {
        String key = criteria.getKey();
        String[] split = key.split("[.]", 0);

        Path<String> expression = root.get(split[0]);
        for (int i = 1; i < split.length; i++) {
            expression = expression.get(split[i]);
        }

        return expression;
    }

}
