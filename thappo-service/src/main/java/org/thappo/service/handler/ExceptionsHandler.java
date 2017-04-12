package org.thappo.service.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thappo.api.models.response.ErrorResponseDTO;
import org.thappo.commons.exception.BusinessException;
import org.thappo.service.exception.BusinessCodes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class ExceptionsHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);

	@Autowired
	private ObjectMapper mapper;

	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<ErrorResponseDTO> handleDefaultException(HttpServletRequest request, Exception ex) throws JsonProcessingException {
		LOGGER.error("[CONTROLLER] Exception: " + ex.getClass().getName());
		LOGGER.trace(">>> Trace: ", ex);
		BusinessCodes exceptionData = BusinessCodes.getBusinessException(ex);

		ErrorResponseDTO.Builder errorBuilder = new ErrorResponseDTO.Builder();
		errorBuilder.setCode(Integer.valueOf(String.valueOf(exceptionData.getStatusCode()) + String.valueOf(exceptionData.getInternalCode())));
		errorBuilder.setException(ex.getClass().getSimpleName());
		errorBuilder.setMessage(ex.getMessage());
		errorBuilder.setCauses(null);
		ErrorResponseDTO error = errorBuilder.build();

		ResponseEntity<ErrorResponseDTO> result = new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.valueOf(exceptionData.getStatusCode().intValue()));
		LOGGER.error("[CONTROLLER] Service response: " + this.mapper.writeValueAsString(error));
		return result;
	}

	@ExceptionHandler(BusinessException.class)
	public @ResponseBody ResponseEntity<ErrorResponseDTO> handleBusinessException(HttpServletRequest request, BusinessException ex) throws JsonProcessingException {
		LOGGER.error("[CONTROLLER] Exception: " + ex.getClass().getName());
		LOGGER.trace(">>> Trace: ", ex);
		BusinessCodes exceptionData = BusinessCodes.getBusinessException(ex);
		ErrorResponseDTO.Builder errorBuilder = new ErrorResponseDTO.Builder();
		errorBuilder.setCode(Integer.valueOf(String.valueOf(exceptionData.getStatusCode()) + String.valueOf(exceptionData.getInternalCode())));
		errorBuilder.setException(ex.getClass().getSimpleName());
		errorBuilder.setMessage(exceptionData.getDescription());
		errorBuilder.setCauses(ex.getCauses());
		ErrorResponseDTO error = errorBuilder.build();

		ResponseEntity<ErrorResponseDTO> result = new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.valueOf(exceptionData.getStatusCode().intValue()));
		LOGGER.error("[CONTROLLER] Service response: " + this.mapper.writeValueAsString(error));
		return result;
	}
}
