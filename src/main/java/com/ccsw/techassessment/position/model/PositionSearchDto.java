package com.ccsw.techassessment.position.model;

import com.ccsw.techassessment.common.pagination.PageableRequest;

public class PositionSearchDto {
    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }
}
