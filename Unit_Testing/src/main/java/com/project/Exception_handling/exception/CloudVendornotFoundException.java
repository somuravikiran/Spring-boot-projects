package com.project.Exception_handling.exception;

public class CloudVendornotFoundException extends RuntimeException{

    public CloudVendornotFoundException(String message) {
        super(message);
    }

    public CloudVendornotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
