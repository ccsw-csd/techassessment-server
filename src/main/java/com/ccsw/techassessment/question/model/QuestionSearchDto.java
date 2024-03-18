package com.ccsw.techassessment.question.model;

import com.ccsw.techassessment.common.pagination.PageableRequest;

public class QuestionSearchDto {

    private PageableRequest pageable;
    private FiltersDto filterParams;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }

    public FiltersDto getFilterParams() {
        return filterParams;
    }

    public void setFilterParams(FiltersDto filterParams) {
        this.filterParams = filterParams;
    }
}
