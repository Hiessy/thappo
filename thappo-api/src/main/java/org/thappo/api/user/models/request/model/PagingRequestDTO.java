package org.thappo.api.user.models.request.model;

import java.util.List;

import org.thappo.commons.util.databind.ParamName;

public class PagingRequestDTO {

    private Integer offset;
    private Integer limit;
    @ParamName("order_by_criteria")
    private List<String> orderByCriteria;
    @ParamName("order_by_direction")
    private List<String> orderByDirection;

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getOrderByCriteria() {
        return this.orderByCriteria;
    }

    public void setOrderByCriteria(List<String> orderByCriteria) {
        this.orderByCriteria = orderByCriteria;
    }

    public List<String> getOrderByDirection() {
        return this.orderByDirection;
    }

    public void setOrderByDirection(List<String> orderByDirection) {
        this.orderByDirection = orderByDirection;
    }

    @Override
    public String toString() {
        return "PagingRequestDTO [offset=" + this.offset + ", limit=" + this.limit + ", orderByCriteria="
            + this.orderByCriteria + ", orderByDirection=" + this.orderByDirection + "]";
    }

}
