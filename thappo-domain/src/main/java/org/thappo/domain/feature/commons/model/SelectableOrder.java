package org.thappo.domain.feature.commons.model;


public class SelectableOrder {

    private String criteria;
    private String direction;
    private Integer selectedOrder;
    private Boolean selected;

    public String getCriteria() {
        return this.criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getSelectedOrder() {
        return this.selectedOrder;
    }

    public void setSelectedOrder(Integer selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public Boolean getSelected() {
        return this.selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
