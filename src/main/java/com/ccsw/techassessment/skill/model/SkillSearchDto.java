package com.ccsw.techassessment.skill.model;

import com.ccsw.techassessment.common.pagination.PageableRequest;

public class SkillSearchDto {
    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }
}
