package com.challenge.hrpayrollsystem.exceptions;

public class DuplicatePayException extends Exception {

	 
    public DuplicatePayException() {}

   
    public DuplicatePayException(String message)
    {
       super(message);
    }
    public DuplicatePayException(String message, Throwable cause) {
        super(message, cause);
    }
}
