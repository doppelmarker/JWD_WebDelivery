package com.markedline.webdelivery.service;

import com.markedline.webdelivery.entity.User;

public interface UserService {
    boolean registration(User user) throws ServiceException;

    User authorization(String login, String password) throws ServiceException;
}
