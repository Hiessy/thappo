package org.thappo.domain.feature.user.service;

import org.thappo.domain.feature.user.model.UserDomain;
import org.thappo.domain.feature.commons.model.BusinessService;
import org.thappo.domain.feature.commons.model.PaginatedResponse;
import org.thappo.domain.feature.commons.model.PagingRequest;

public interface UserService
    extends BusinessService {

    public PaginatedResponse<UserDomain> getUsers(PagingRequest params);

    public UserDomain getUser(String id);

    public UserDomain addUser(UserDomain user);

    public void deleteUser(String id);

    public UserDomain updateUser(UserDomain user);

}
