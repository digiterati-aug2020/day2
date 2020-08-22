package com.digiterati.spring.docs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digiterati.spring.docs.model.ErrorException;
import com.digiterati.spring.docs.model.ErrorInfo;

@RestControllerAdvice
public class ErrorAdvice {
	
	
	@ExceptionHandler(ErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleCustomException(ErrorException exception) {
        return new ErrorInfo(exception.getErrorMessage());
    }

}
