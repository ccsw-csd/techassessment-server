package com.ccsw.techassessment.skill;

import com.ccsw.techassessment.common.criteria.SearchCriteria;
import com.ccsw.techassessment.skill.model.Skill;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;


public class SkillSpecification implements Specification<Skill> {

    private static final long serialVersionUID = 1L;

    private final SearchCriteria criteria;

    public SkillSpecification(SearchCriteria criteria) {

        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Skill> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
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

    private Path<?> getPath(Root<Skill> root) {
        String key = criteria.getKey();
        String[] split = key.split("[.]", 0);

        Path<String> expression = root.get(split[0]);
        for (int i = 1; i < split.length; i++) {
            expression = expression.get(split[i]);
        }

        return expression;
    }

}
