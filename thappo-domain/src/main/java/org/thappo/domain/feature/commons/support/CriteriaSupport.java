package org.thappo.domain.feature.commons.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.thappo.commons.model.Cause;
import org.thappo.domain.exception.InvalidCriteriaException;
import org.thappo.domain.feature.commons.model.SelectableOrder;

public abstract class CriteriaSupport {

    private List<Order> orders;

    public CriteriaSupport() {
        this.orders = this.getAllOrders();
    }

    public abstract List<Order> getAllOrders();

    public synchronized Order getOrder(Order order) {
        Order result = null;
        Boolean foundCriteria = false;
        Boolean foundCriteriaDirection = false;
        Cause cause = null;
        for (Order selectedOrder : this.orders) {
            if (order.getProperty().equalsIgnoreCase(selectedOrder.getProperty())) {
                foundCriteria = true;
                if (order.getDirection() == selectedOrder.getDirection()) {
                    foundCriteriaDirection = true;
                    result = selectedOrder;
                }
            }
        }

        if (!foundCriteria || !foundCriteriaDirection) {
            if (!foundCriteria) {
                cause = new Cause(order.getProperty(), "Criteria's state not found");
            } else if (!foundCriteriaDirection) {
                cause = new Cause(String.valueOf(order.getDirection()), "Criteria's direction not found");
            } else {
                cause = new Cause(String.valueOf(order.getDirection()), "Invalid direction");
            }
        }

        if (result == null) {
            throw new InvalidCriteriaException(cause);
        }

        return result;
    }

    public synchronized List<Order> getOrders(List<Order> orders) {
        Boolean foundAllCriterias = true;
        List<Cause> causes = new ArrayList<Cause>();
        List<Order> result = new ArrayList<Order>();
        for (Order order : orders) {
            try {
                result.add(this.getOrder(order));
            } catch (InvalidCriteriaException invalidCriteriaException) {
                causes.addAll(invalidCriteriaException.getCauses());
                foundAllCriterias = false;
            }
        }

        if (!foundAllCriterias) {
            throw new InvalidCriteriaException(causes);
        }

        return result;
    }

    public synchronized List<SelectableOrder> selectOrders(List<Order> orders) {
        List<SelectableOrder> sortings = new ArrayList<SelectableOrder>();
        for (Order order : this.orders) {
            SelectableOrder sortingResponse = new SelectableOrder();
            sortingResponse.setCriteria(order.getProperty());
            sortingResponse.setDirection(order.getDirection().toString());
            for (int i = 0; i < orders.size(); i++) {
                Order selectedOrder = orders.get(i);
                if (selectedOrder.getProperty().equals(order.getProperty())
                    && selectedOrder.getDirection().equals(order.getDirection())) {
                    sortingResponse.setSelected(true);
                    sortingResponse.setSelectedOrder(i);
                }
            }
            sortings.add(sortingResponse);
        }
        return sortings;
    }

}
