package com.markedline.webdelivery.service.validator.impl;

import com.markedline.webdelivery.service.validator.CommonValidator;
import com.markedline.webdelivery.service.validator.ValidatorException;
import com.markedline.webdelivery.service.validator.info.ValidationInfo;

public class RegistrationInfoValidator implements CommonValidator {

    private static final int LOGIN_MIN_LENGTH = 3;
    private static final int LOGIN_MAX_LENGTH = 20;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 128;
    private static final String INCORRECT_LOGIN_LENGTH = "Некорректная длина логина";
    private static final String INCORRECT_PASSWORD_LENGTH = "Некорректная длина пароля";
    private static final String NO_UPPERCASE_LETTERS_IN_PASSWORD = "Пароль должен содержать как минимум одну прописную букву";

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
