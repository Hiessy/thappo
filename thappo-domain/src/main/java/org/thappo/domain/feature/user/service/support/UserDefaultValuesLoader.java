package org.thappo.domain.feature.user.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import org.thappo.domain.feature.commons.model.PagingRequest;

@Component
public class UserDefaultValuesLoader {

    @Value("${default.paginated.limit}")
    private Integer DEFAULT_LIMIT;
    @Value("${default.paginated.offset}")
    private Integer DEFAULT_OFFSET;
    @Value("${default.paginated.user.criteria}")
    private String DEFAULT_CRITERIA;
    @Value("${default.paginated.user.direction}")
    private String DEFAULT_DIRECTION;

    public synchronized PagingRequest loadDefaultPagingValues(PagingRequest params) {
        final Integer limit = params.getLimit() == null ? this.DEFAULT_LIMIT : params.getLimit();
        final Integer offset = params.getOffset() == null ? this.DEFAULT_OFFSET : params.getOffset();

        List<Order> orders = new ArrayList<Order>();
        if (params.getOrders() == null) {
            orders.add(new Order(Direction.valueOf(this.DEFAULT_DIRECTION), this.DEFAULT_CRITERIA));
        } else {
            orders.addAll(params.getOrders());
        }

        params.setLimit(limit);
        params.setOffset(offset);
        params.setOrders(orders);

        return params;
    }

}
