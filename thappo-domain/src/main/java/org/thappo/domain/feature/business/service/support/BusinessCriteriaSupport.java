package org.thappo.domain.feature.business.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import org.thappo.domain.feature.commons.support.CriteriaSupport;

@Component
public class BusinessCriteriaSupport
    extends CriteriaSupport {

    @Override
    public List<Order> getAllOrders() {
        List<Order> sortings = new ArrayList<Order>();
        sortings.add(new Order(Sort.Direction.ASC, "lastName"));
        sortings.add(new Order(Sort.Direction.DESC, "lastName"));
        sortings.add(new Order(Sort.Direction.ASC, "profile"));
        sortings.add(new Order(Sort.Direction.DESC, "profile"));
        sortings.add(new Order(Sort.Direction.ASC, "state"));
        sortings.add(new Order(Sort.Direction.DESC, "state"));
        return sortings;
    }

}
