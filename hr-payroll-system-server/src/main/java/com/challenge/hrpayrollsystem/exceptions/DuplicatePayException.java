package com.challenge.hrpayrollsystem.exceptions;

public class DuplicatePayException extends Exception {

	 
    public DuplicatePayException() {}

    // Constructor that accepts a message
    public DuplicatePayException(String message)
    {
       super(message);
    }
    public DuplicatePayException(String message, Throwable cause) {
        super(message, cause);
    }
}
