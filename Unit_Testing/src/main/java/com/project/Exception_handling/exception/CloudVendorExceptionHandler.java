package com.project.Exception_handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = {CloudVendornotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendornotFoundException cloudVendornotFoundException){
        CloudVendorException cloudVendorException=new CloudVendorException(cloudVendornotFoundException.getMessage(),cloudVendornotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
