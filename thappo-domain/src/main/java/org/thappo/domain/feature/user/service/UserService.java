package org.thappo.domain.feature.user.service;

import org.thappo.domain.feature.user.model.UserDomain;
import org.thappo.domain.feature.commons.model.PaginatedResponse;
import org.thappo.domain.feature.commons.model.PagingRequest;

public interface UserService {

    public PaginatedResponse<UserDomain> getUsers(PagingRequest params);

    public UserDomain getUser(Integer id);

    public UserDomain addUser(UserDomain user);

    public void deleteUser(Integer id);

    public void changeUserToInactive(Integer id);
    
    public UserDomain updateUser(UserDomain user);

}
