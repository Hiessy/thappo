package org.thappo.domain.feature.user.service;

import java.util.List;

import ma.glasnost.orika.MapperFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import org.thappo.commons.annotation.Valid;
import org.thappo.commons.annotation.ValidateGroups;
import org.thappo.commons.model.Cause;
import org.thappo.domain.exception.InvalidIDException;
import org.thappo.domain.feature.user.dao.UserDAO;
import org.thappo.domain.feature.user.model.User;
import org.thappo.domain.feature.user.model.UserDomain;
import org.thappo.domain.feature.user.model.UserDomain.AddValidations;
import org.thappo.domain.feature.user.model.UserDomain.UpdateValidations;
import org.thappo.domain.feature.user.service.support.UserCriteriaSupport;
import org.thappo.domain.feature.user.service.support.UserDefaultValuesLoader;
import org.thappo.domain.feature.commons.annotation.ValidId;
import org.thappo.domain.feature.commons.model.PaginatedResponse;
import org.thappo.domain.feature.commons.model.PagingRequest;
import org.thappo.domain.feature.commons.model.PagingResponse;
import org.thappo.domain.feature.commons.model.SelectableOrder;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserDAO dao;
	private MapperFacade mapper;

	@Autowired
	private UserCriteriaSupport criteriaSupport;

	@Autowired
	private UserDefaultValuesLoader defaultValuesLoader;

	@Autowired
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}

	@Autowired
	@Qualifier("domainMapper")
	public void setMapper(MapperFacade mapper) {
		this.mapper = mapper;
	}

	public PaginatedResponse<UserDomain> getUsers(PagingRequest params) {
		LOGGER.info("[DOMAIN] Executing getUsers request");
		LOGGER.debug(">>> Request params: " + params.toString());
		PagingRequest alteredParams = this.defaultValuesLoader.loadDefaultPagingValues(params);

		List<Order> orders = this.criteriaSupport.getOrders(alteredParams.getOrders());

		LOGGER.debug(">>> Find all with params: " + alteredParams.toString());
		Page<User> usersEntity = this.dao.findAll(new PageRequest(alteredParams.getOffset(), alteredParams.getLimit(), new Sort(orders)));

		LOGGER.debug(">>> Obtained " + usersEntity.getNumberOfElements() + " elements of  " + usersEntity.getTotalElements() + " total results");
		LOGGER.info(usersEntity.getContent().get(0).getContacts().get(0).toString());
		List<UserDomain> usersDomain = this.mapper.mapAsList(usersEntity.getContent(), UserDomain.class);
		LOGGER.info(usersDomain.get(0).getContactsDomain().get(0).toString());
		// Build paginated response
		PagingResponse.Builder paging = new PagingResponse.Builder();
		paging.setLimit(alteredParams.getLimit());
		paging.setOffset(alteredParams.getOffset());
		paging.setTotal(usersEntity.getTotalElements());
		List<SelectableOrder> sortings = this.criteriaSupport.selectOrders(orders);

		return new PaginatedResponse<UserDomain>(usersDomain, sortings, paging.build());
	}

	public UserDomain getUser(@ValidId Integer id) {
        LOGGER.info("[DOMAIN] Executing getUser request");
        LOGGER.debug(">>> Request param: " + id);
        User userEntity = this.dao.findOne(id);
        if (userEntity == null) {
            throw new InvalidIDException(new Cause(String.valueOf(id), "Nonexistent ID"));
        }
        return this.mapper.map(userEntity, UserDomain.class);
    }

    @ValidateGroups(AddValidations.class)
    public UserDomain addUser(@Valid UserDomain user) {
        LOGGER.info("[DOMAIN] Executing addUser request");
        LOGGER.debug(">>> Request params: " + user.toString());
        User userEntity = this.mapper.map(user, User.class);
        User userEntityResponse = this.dao.save(userEntity);
        return this.mapper.map(userEntityResponse, UserDomain.class);
    }

    public void deleteUser(@ValidId Integer id) {
        LOGGER.info("[DOMAIN] Executing deleteUser request");
        LOGGER.debug(">>> Request param: " + id);
        try {
            this.dao.delete(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new InvalidIDException(new Cause(String.valueOf(id), "Nonexistent ID"));
        }
    }

    @ValidateGroups(UpdateValidations.class)
    public UserDomain updateUser(@Valid UserDomain user) {
        
        LOGGER.info("[DOMAIN] Executing updateUser request");
        LOGGER.debug(">>> Request params: " + user.toString());
        User userEntity = this.mapper.map(user, User.class);
        User dbUser = this.dao.findOne(user.getUserId());
        if (dbUser == null) {
            throw new InvalidIDException(new Cause(String.valueOf(user.getUserId()), "Nonexistent ID"));
        }

        LOGGER.debug(">>> Merging with original data: " + dbUser.toString());
        
        if (userEntity.getFirstName() == null) {
            userEntity.setFirstName(dbUser.getFirstName());
        }
        
        if (userEntity.getLastName() == null) {
            userEntity.setLastName(dbUser.getLastName());
        }
        
        if (userEntity.getEmail() == null) {
            userEntity.setEmail(dbUser.getEmail());
        }
        if (userEntity.getPassword() == null) {
            userEntity.setPassword(dbUser.getPassword());
        }
        if (userEntity.getDob() == null) {
            userEntity.setDob(dbUser.getDob());
        }
        if (userEntity.getProfile() == null) {
            userEntity.setProfile(dbUser.getProfile());
        }
        if (userEntity.getState() == null) {
            userEntity.setState(dbUser.getState());
        }


        LOGGER.debug(">>> Saving user: " + userEntity.toString());
        User userEntityResponse = this.dao.save(userEntity);
        
        return this.mapper.map(userEntityResponse, UserDomain.class);
    }

}
