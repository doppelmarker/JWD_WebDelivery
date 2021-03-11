package com.markedline.webdelivery.service.validator.impl;

import com.markedline.webdelivery.service.validator.CommonValidator;
import com.markedline.webdelivery.service.validator.ValidatorException;
import com.markedline.webdelivery.service.validator.info.ValidationInfo;

public class RegistrationInfoValidator implements CommonValidator {

    private static final int LOGIN_MIN_LENGTH = 3;
    private static final int LOGIN_MAX_LENGTH = 20;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 128;
    private static final String INCORRECT_LOGIN_LENGTH = "Login length must be from " + LOGIN_MIN_LENGTH +
            " to " + LOGIN_MAX_LENGTH + " symbols!";
    private static final String INCORRECT_PASSWORD_LENGTH = "Password length must be from " + PASSWORD_MIN_LENGTH +
            " to " + PASSWORD_MAX_LENGTH + " symbols!";
    private static final String NO_UPPERCASE_LETTERS_IN_PASSWORD = "Password must contain at least one uppercase letter!";

    @Override
    public boolean validate(ValidationInfo info) throws ValidatorException {
        String login = info.getLogin();
        String password = info.getPassword();
        if (login.length() < LOGIN_MIN_LENGTH || login.length() > LOGIN_MAX_LENGTH) {
            throw new ValidatorException(INCORRECT_LOGIN_LENGTH);
        }
        if (password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH) {
            throw new ValidatorException(INCORRECT_PASSWORD_LENGTH);
        }
        if (!isAnyUpperCase(password)) {
            throw new ValidatorException(NO_UPPERCASE_LETTERS_IN_PASSWORD);
        }
        return true;
    }

    private boolean isAnyUpperCase(String str) {
        return !str.equals(str.toLowerCase());
    }
}
