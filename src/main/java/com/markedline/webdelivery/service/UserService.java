package com.markedline.webdelivery.service;

import com.markedline.webdelivery.entity.User;
import com.markedline.webdelivery.service.validator.ValidatorException;

public interface UserService {

    boolean primaryRegistration(User user) throws ServiceException, ValidatorException;

    boolean isLoginTaken(String login) throws ServiceException;

    User authorization(String login, String password) throws ServiceException;
}
