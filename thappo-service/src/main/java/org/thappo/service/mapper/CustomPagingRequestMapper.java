package org.thappo.service.mapper;

import ma.glasnost.orika.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.thappo.api.models.request.PagingRequestDTO;
import org.thappo.domain.feature.commons.model.PagingRequest;
	
public class CustomPagingRequestMapper extends CustomMapper<PagingRequest, PagingRequestDTO> {

    @Override
    public void mapBtoA(PagingRequestDTO b, PagingRequest a, MappingContext context) {
        a.setLimit(b.getLimit());
        a.setOffset(b.getOffset());
        List<Order> orders = new ArrayList<Order>();

        if (b.getOrderByCriteria() != null) {
            if (b.getOrderByDirection() != null) {
                Integer difference = b.getOrderByCriteria().size() - b.getOrderByDirection().size();
                for (int i = 0; i < difference; i++) {
                    b.getOrderByDirection().add(null);
                }
            }
            for (int i = 0; i < b.getOrderByCriteria().size(); i++) {
                String criteriaName = b.getOrderByCriteria().get(i);
                Direction criteriaDirection = null;
                if (b.getOrderByDirection() != null && b.getOrderByDirection().get(i) != null) {
                    criteriaDirection = Direction.valueOf(b.getOrderByDirection().get(i).toUpperCase());
                }
                orders.add(new Order(criteriaDirection, criteriaName));
            }
            a.setOrders(orders);
        }
    }
}
