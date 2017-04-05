package org.thappo.domain.feature.commons.model;

public class PagingResponse {

    private Integer offset;
    private Integer limit;
    private Long total;

    public PagingResponse(Integer offset, Integer limit, Long total) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Long getTotal() {
        return this.total;
    }

    public static class Builder {

        private Integer offset;
        private Integer limit;
        private Long total;

        public PagingResponse build() {
            return new PagingResponse(this.offset, this.limit, this.total);
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

    }

}
