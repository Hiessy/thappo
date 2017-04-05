package org.thappo.domain.feature.commons.model;

import java.util.List;

public class PaginatedResponse<T> {

    private List<T> items;
    private List<SelectableOrder> orderBy;
    private PagingResponse paging;

    public PaginatedResponse(List<T> items2, List<SelectableOrder> orderBy, PagingResponse paging) {
        this.items = items2;
        this.orderBy = orderBy;
        this.paging = paging;
    }

    public List<T> getItems() {
        return this.items;
    }

    public List<SelectableOrder> getOrderBy() {
        return this.orderBy;
    }

    public PagingResponse getPaging() {
        return this.paging;
    }

    public static class Builder<T> {

        private List<T> items;
        private List<SelectableOrder> orderBy;
        private PagingResponse paging;

        public void setItems(List<T> items) {
            this.items = items;
        }

        public void setOrderBy(List<SelectableOrder> orderBy) {
            this.orderBy = orderBy;
        }

        public void setPaging(PagingResponse paging) {
            this.paging = paging;
        }

        public PaginatedResponse<T> build() {
            return new PaginatedResponse<T>(this.items, this.orderBy, this.paging);
        }

    }

}
