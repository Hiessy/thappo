package org.thappo.domain.feature.commons.model;

import java.util.List;

import org.springframework.data.domain.Sort.Order;


public class PagingRequest {

    private Integer offset;
    private Integer limit;
    private List<Order> orders;

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

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "PagingRequest [offset=" + this.offset + ", limit=" + this.limit + ", orders=" + this.orders + "]";
    }

}
