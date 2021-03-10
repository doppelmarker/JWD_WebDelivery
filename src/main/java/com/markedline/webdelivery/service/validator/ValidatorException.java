package com.markedline.webdelivery.service.validator;

public class ValidatorException extends Exception {
    private static final long serialVersionUID = 5579627996438039830L;

    public ValidatorException() {
        super();
    }

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(Exception e) {
        super(e);
    }

    public ValidatorException(String message, Exception e) {
        super(message, e);
    }
}
