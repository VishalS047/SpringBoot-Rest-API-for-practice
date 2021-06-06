package com.rest.api.restapis.ExceptionResource;

import java.util.Date;

import com.rest.api.restapis.Entity.UserNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntitytExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request) {
        
        ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResource, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest request) {
        
        ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResource, HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        ExceptionResource exceptionResource = new ExceptionResource(new Date(), "Validation failed", ex.getBindingResult().toString(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(exceptionResource, HttpStatus.BAD_REQUEST);
	}
}
