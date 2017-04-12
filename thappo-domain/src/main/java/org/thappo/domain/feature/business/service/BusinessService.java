package org.thappo.domain.feature.business.service;

import org.thappo.domain.feature.business.model.BusinessDomain;
import org.thappo.domain.feature.commons.model.PaginatedResponse;
import org.thappo.domain.feature.commons.model.PagingRequest;

public interface BusinessService {

    public PaginatedResponse<BusinessDomain> getBusinesses(PagingRequest params);

    public BusinessDomain getBusiness(Integer id);

    public BusinessDomain addBusiness(BusinessDomain business);

    public void deleteBusiness(Integer id);

    public BusinessDomain updateBusiness(BusinessDomain business);

}
