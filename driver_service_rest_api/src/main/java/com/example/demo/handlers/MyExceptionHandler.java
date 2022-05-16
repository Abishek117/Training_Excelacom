package com.example.demo.handlers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class MyExceptionHandler 
{
	@ExceptionHandler(value = Exception.class)
	public ErrorMessage handleAll(Exception ex,WebRequest req)
	{
		
		return new ErrorMessage(ex.getMessage(),LocalDateTime.now(),req.getDescription(false));
	}
	
}
