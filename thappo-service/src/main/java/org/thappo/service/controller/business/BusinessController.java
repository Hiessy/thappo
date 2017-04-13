package org.thappo.service.controller.business;

import ma.glasnost.orika.MapperFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thappo.api.models.business.BusinessDTO;
import org.thappo.api.models.request.PagingRequestDTO;
import org.thappo.domain.exception.ValidationException;
import org.thappo.domain.feature.business.model.BusinessDomain;
import org.thappo.domain.feature.business.service.BusinessService;
import org.thappo.domain.feature.commons.model.PaginatedResponse;
import org.thappo.domain.feature.commons.model.PagingRequest;

@RestController
@RequestMapping("/v3/business")
public class BusinessController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);

	private BusinessService businessService;
	private MapperFacade mapper;

	@Autowired
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}

	@Autowired
	@Qualifier("serviceMapper")
	public void setMapper(MapperFacade mapper) {
		this.mapper = mapper;
	}

	//
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<PaginatedResponse<BusinessDTO>> getBusinesses(PagingRequestDTO params) throws ValidationException {
		LOGGER.info("[CONTROLLER] Starting getBusinesses request");
		LOGGER.debug(">>> Recieved params: " + params.toString());
		PagingRequest pagingRequest = this.mapper.map(params, PagingRequest.class);
		
		PaginatedResponse<BusinessDomain> businessDomain = this.businessService.getBusinesses(pagingRequest);

		PaginatedResponse.Builder<BusinessDTO> paginatedResponseBuilder = new PaginatedResponse.Builder<BusinessDTO>();
		paginatedResponseBuilder.setPaging(businessDomain.getPaging());
		paginatedResponseBuilder.setOrderBy(businessDomain.getOrderBy());
		paginatedResponseBuilder.setItems(this.mapper.mapAsList(businessDomain.getItems(), BusinessDTO.class));

		return new ResponseEntity<PaginatedResponse<BusinessDTO>>(paginatedResponseBuilder.build(), HttpStatus.OK);

	}
	//
	// @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	// public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer
	// userId) throws ValidationException {
	// LOGGER.info("[CONTROLLER] Starting getUser request");
	// LOGGER.debug(">>> Recieved param: " + userId);
	// UserDomain userDomain = this.userService.getUser(userId);
	// UserDTO result = this.mapper.map(userDomain, UserDTO.class);
	// return new ResponseEntity<UserDTO>(result, HttpStatus.OK);
	// }
	//
	// @RequestMapping(value = "", method = RequestMethod.POST)
	// public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO
	// userRequestDTO) throws ValidationException {
	// LOGGER.info("[CONTROLLER] Starting postUser request");
	// LOGGER.debug(">>> Recieved params: " + userRequestDTO.toString());
	// UserDomain userDomain = this.mapper.map(userRequestDTO,
	// UserDomain.class);
	// UserDomain userDomainResponse = this.userService.addUser(userDomain);
	// UserDTO userResponseDTO = this.mapper.map(userDomainResponse,
	// UserDTO.class);
	// return new ResponseEntity<UserDTO>(userResponseDTO, HttpStatus.OK);
	// }
	//
	// @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	// public ResponseEntity<UserDTO> putUser(@RequestBody UserDTO
	// userRequestDTO, @PathVariable("userId") Integer userId) throws
	// ValidationException {
	// LOGGER.info("[CONTROLLER] Starting put User request");
	// userRequestDTO.setUserId(userId);
	// LOGGER.debug(">>> Recieved params: " + userRequestDTO.toString());
	// UserDomain userDomain = this.mapper.map(userRequestDTO,
	// UserDomain.class);
	// UserDomain userDomainResponse = this.userService.updateUser(userDomain);
	// UserDTO userResponseDTO = this.mapper.map(userDomainResponse,
	// UserDTO.class);
	// return new ResponseEntity<UserDTO>(userResponseDTO, HttpStatus.OK);
	// }
	//
	// @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	// public void deleteUser(@PathVariable("userId") Integer userId) throws
	// ValidationException {
	// LOGGER.info("[CONTROLLER] Starting deleteUser request");
	// LOGGER.debug(">>> Recieved param: " + userId);
	// this.userService.deleteUser(userId);
	// }

}
