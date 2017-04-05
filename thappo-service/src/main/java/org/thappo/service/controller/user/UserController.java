package org.thappo.service.controller.user;

import ma.glasnost.orika.MapperFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thappo.api.user.models.request.model.PagingRequestDTO;
import org.thappo.api.user.models.UserDTO;
import org.thappo.domain.exception.ValidationException;
import org.thappo.domain.feature.user.model.UserDomain;
import org.thappo.domain.feature.user.service.UserService;
import org.thappo.domain.feature.commons.model.PaginatedResponse;
import org.thappo.domain.feature.commons.model.PagingRequest;

@RestController
@RequestMapping("/v3/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private UserService userService;
	private MapperFacade mapper;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	@Qualifier("serviceMapper")
	public void setMapper(MapperFacade mapper) {
		this.mapper = mapper;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<PaginatedResponse<UserDTO>> getUsers(PagingRequestDTO params) throws ValidationException {
		LOGGER.info("[CONTROLLER] Starting getUsers request");
		LOGGER.debug(">>> Recieved params: " + params.toString());
		PagingRequest pagingRequest = this.mapper.map(params, PagingRequest.class);
		PaginatedResponse<UserDomain> usersDomain = this.userService.getUsers(pagingRequest);

		PaginatedResponse.Builder<UserDTO> paginatedResponseBuilder = new PaginatedResponse.Builder<UserDTO>();
		paginatedResponseBuilder.setPaging(usersDomain.getPaging());
		paginatedResponseBuilder.setOrderBy(usersDomain.getOrderBy());
		paginatedResponseBuilder.setItems(this.mapper.mapAsList(usersDomain.getItems(), UserDTO.class));

		return new ResponseEntity<PaginatedResponse<UserDTO>>(paginatedResponseBuilder.build(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId) throws ValidationException {
		LOGGER.info("[CONTROLLER] Starting getUser request");
		LOGGER.debug(">>> Recieved param: " + userId);
		UserDomain userDomain = this.userService.getUser(userId);
		UserDTO result = this.mapper.map(userDomain, UserDTO.class);
		return new ResponseEntity<UserDTO>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO userRequestDTO) throws ValidationException {
		LOGGER.info("[CONTROLLER] Starting postUser request");
		LOGGER.debug(">>> Recieved params: " + userRequestDTO.toString());
		UserDomain userDomain = this.mapper.map(userRequestDTO, UserDomain.class);
		UserDomain userDomainResponse = this.userService.addUser(userDomain);
		UserDTO userResponseDTO = this.mapper.map(userDomainResponse, UserDTO.class);
		return new ResponseEntity<UserDTO>(userResponseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> putUser(@RequestBody UserDTO userRequestDTO, @PathVariable("userId") Integer userId) throws ValidationException {
		LOGGER.info("[CONTROLLER] Starting put User request");
		userRequestDTO.setUserId(userId);
		LOGGER.debug(">>> Recieved params: " + userRequestDTO.toString());
		UserDomain userDomain = this.mapper.map(userRequestDTO, UserDomain.class);
		UserDomain userDomainResponse = this.userService.updateUser(userDomain);
		UserDTO userResponseDTO = this.mapper.map(userDomainResponse, UserDTO.class);
		return new ResponseEntity<UserDTO>(userResponseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") Integer userId) throws ValidationException {
		LOGGER.info("[CONTROLLER] Starting deleteUser request");
		LOGGER.debug(">>> Recieved param: " + userId);
		this.userService.deleteUser(userId);
	}

}
