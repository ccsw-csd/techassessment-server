package com.ccsw.techassessment.applicant.model;

import com.ccsw.techassessment.common.pagination.PageableRequest;

public class ApplicantSearchDto {

    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }

}