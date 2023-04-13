package com.excample.demo.exceptioncontroller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exception.EmployeeNotFoundException;



@ControllerAdvice
public class EmployeeExceptionController {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exception(EmployeeNotFoundException ex){
		return ex.getMessage();
		
	}
}
