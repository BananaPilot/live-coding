
package com.pasqualehorse.livecoding.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pasqualehorse.livecoding.controller.dto.BaseResponse;
import com.pasqualehorse.livecoding.exceptions.ConflictException;
import com.pasqualehorse.livecoding.exceptions.NoContentException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConflictException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public BaseResponse handleConflictException(ConflictException e) {
		return new BaseResponse(e.getMessage());
	}
	
	@ExceptionHandler(NoContentException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public BaseResponse handleNoContentException(NoContentException e) {
		return new BaseResponse(e.getMessage());
	}
	
}
