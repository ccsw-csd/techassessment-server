package com.ccsw.techassessment.position.model;

import com.ccsw.techassessment.common.pagination.PageableRequest;
import com.ccsw.techassessment.position.model.FiltersDto;

public class PositionSearchDto {
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