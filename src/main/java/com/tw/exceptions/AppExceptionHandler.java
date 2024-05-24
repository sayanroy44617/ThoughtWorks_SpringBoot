package com.tw.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tw.model.response.ErrorMessage;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex , WebRequest webRequest)
	{
		String messageDesc = ex.getLocalizedMessage();
		if(messageDesc==null) messageDesc=ex.toString(); 
		ErrorMessage errorMessage = new ErrorMessage(new Date() , messageDesc);
		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception ex , WebRequest webRequest)
	{
		String messageDesc = ex.getLocalizedMessage();
		if(messageDesc==null) messageDesc=ex.toString(); 
		ErrorMessage errorMessage = new ErrorMessage(new Date() , messageDesc);
		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
