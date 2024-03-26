package com.ccsw.techassessment.interviewer.model;

import com.ccsw.techassessment.common.pagination.PageableRequest;

public class InterviewerSearchDto {

    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }

}
